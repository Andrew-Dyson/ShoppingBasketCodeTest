import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingBasketTest {

    Item fruit;
    Item bread;
    Item chocolate;
    Item readyMeal;
    ShoppingBasket myShoppingBasket;
    Customer alan;

    @Before
    public void setUp(){
        fruit = new Item("banana", 0.2, null);
        bread = new Item("wholemeal loaf", 1.3, "buy one get one free");
        chocolate = new Item("mars bar", 0.8, null);
        readyMeal = new Item("lasagne", 6.0, null);
        myShoppingBasket = new ShoppingBasket();
        alan = new Customer("Alan", myShoppingBasket, true);
    }

    @Test
    public void canAddItemsToShoppingBasket(){
        alan.getShoppingBasket().addItemToShoppingBasket(fruit);
        assertEquals(1, alan.getShoppingBasket().countNumberOfItems());
    }

    @Test
    public void canRemoveItemsFromShoppingBasket(){
        alan.getShoppingBasket().addItemToShoppingBasket(fruit);
        alan.getShoppingBasket().removeItemFromShoppingBasket(fruit);
        assertEquals(0, alan.getShoppingBasket().countNumberOfItems());

    }

    @Test
    public void canEmptyTheShoppingBasket(){
        alan.getShoppingBasket().addItemToShoppingBasket(fruit);
        alan.getShoppingBasket().addItemToShoppingBasket(bread);
        alan.getShoppingBasket().addItemToShoppingBasket(readyMeal);
        alan.getShoppingBasket().emptyShoppingBasket();
        assertEquals(0, alan.getShoppingBasket().countNumberOfItems());

    }
    @Test
    public void canCountNumberOfParticularItemInShoppingBasket(){
        alan.getShoppingBasket().addItemToShoppingBasket(bread);
        alan.getShoppingBasket().addItemToShoppingBasket(bread);
        assertEquals(2, alan.getShoppingBasket().countNumberOfParticularItem(bread));
    }
    @Test
    public void canGetTotalValueOfShoppingBasketNoDiscountsOrOffers(){
        alan.getShoppingBasket().addItemToShoppingBasket(fruit);
        alan.getShoppingBasket().addItemToShoppingBasket(readyMeal);
        Double expectedValue = 6.2;
        assertEquals(expectedValue, alan.getShoppingBasket().getTotalValueWithOffers());
    }

    @Test
    public void canGetTotalValueOfShoppingBasketItemOfferApplied(){
        alan.getShoppingBasket().addItemToShoppingBasket(bread);
        alan.getShoppingBasket().addItemToShoppingBasket(bread);
        alan.getShoppingBasket().addItemToShoppingBasket(fruit);
        alan.getShoppingBasket().addItemToShoppingBasket(readyMeal);
        Double expectedValue = 8.8;
        assertEquals(expectedValue, alan.getShoppingBasket().getTotalValueWithOffers());
    }

    @Test
    public void canGetTotalValueOfShoppingBasketOfferNotApplied(){
        alan.getShoppingBasket().addItemToShoppingBasket(bread);
        alan.getShoppingBasket().addItemToShoppingBasket(fruit);
        alan.getShoppingBasket().addItemToShoppingBasket(readyMeal);
        Double expectedValue = 7.5;
        assertEquals(expectedValue, alan.getShoppingBasket().getTotalValueWithOffers());
    }

    @Test
    public void canGetTotalValueOfShoppingBasketTotalOver20Pounds(){
        alan.getShoppingBasket().addItemToShoppingBasket(bread);
        alan.getShoppingBasket().addItemToShoppingBasket(fruit);
        alan.getShoppingBasket().addItemToShoppingBasket(readyMeal);
        alan.getShoppingBasket().addItemToShoppingBasket(readyMeal);
        alan.getShoppingBasket().addItemToShoppingBasket(readyMeal);
        alan.getShoppingBasket().addItemToShoppingBasket(readyMeal);
        Double totalAfterOffers = alan.getShoppingBasket().getTotalValueWithOffers();
        Double expectedValue = 20.400000000000002;
        assertEquals(expectedValue, alan.getShoppingBasket().getTotalValueAfterOffersAndPriceDiscounts(totalAfterOffers));
    }

    @Test
    public void canGetTotalValueOfShoppingBasketWhenCustomerIsLoyaltyMember(){
        alan.getShoppingBasket().addItemToShoppingBasket(bread);
        alan.getShoppingBasket().addItemToShoppingBasket(fruit);
        alan.getShoppingBasket().addItemToShoppingBasket(readyMeal);
        alan.getShoppingBasket().addItemToShoppingBasket(readyMeal);
        alan.getShoppingBasket().addItemToShoppingBasket(readyMeal);
        alan.getShoppingBasket().addItemToShoppingBasket(readyMeal);
        Double totalAfterOffers = alan.getShoppingBasket().getTotalValueWithOffers();
        Double totalAfterOffersAndOver20Discount = alan.getShoppingBasket().getTotalValueAfterOffersAndPriceDiscounts(totalAfterOffers);
        Double expectedValue = 19.992;
        assertEquals(expectedValue, alan.getTotalValueAfterLoyaltyMemberCheck(totalAfterOffersAndOver20Discount));
    }
}
