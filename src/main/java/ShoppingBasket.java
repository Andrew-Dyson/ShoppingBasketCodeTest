import java.util.ArrayList;


public class ShoppingBasket {
    private ArrayList<Item> items;

    public ShoppingBasket() {
        this.items = new ArrayList<Item>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int countNumberOfItems() {
        return this.items.size();
    }

    public void addItemToShoppingBasket(Item item) {
        this.items.add(item);
    }

    public void removeItemFromShoppingBasket(Item item) {
        this.items.remove(item);
    }

    public void emptyShoppingBasket() {
        this.items = new ArrayList<Item>();
    }


    public int countNumberOfParticularItem(Item itemToCount) {
        int count = 0;
        for (Item item : this.items) {
            if (itemToCount == item) {
                count += 1;
            }
        }
        return count;
    }

    public Double getTotalValueWithOffers() {
        Double totalValue = 0.0;
        for (Item item : this.items) {
            if (item.getCurrentOffer() != null && countNumberOfParticularItem(item) == 2) {
                totalValue += (item.getPrice() / 2);
            } else {
                totalValue += item.getPrice();
            }
        }
       return totalValue;
    }
    public Double getTotalValueAfterOffersAndPriceDiscounts(Double totalAfterOffers){
        if (totalAfterOffers > 20.00){
            totalAfterOffers *= 0.8;}
        return totalAfterOffers;
    }


}
