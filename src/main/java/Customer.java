public class Customer {

    private String name;
    private ShoppingBasket shoppingBasket;
    private boolean loyaltyMember;

    public Customer(String name, ShoppingBasket shoppingBasket, boolean loyaltyMember){
        this.name = name;
        this.shoppingBasket = shoppingBasket;
        this.loyaltyMember = loyaltyMember;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShoppingBasket getShoppingBasket() {
        return shoppingBasket;
    }

    public boolean isLoyaltyMember() {
        return loyaltyMember;
    }

    public void setLoyaltyMember(boolean loyaltyMember) {
        this.loyaltyMember = loyaltyMember;
    }


    public Double getTotalValueAfterLoyaltyMemberCheck(Double totalAfterOffersAndOver20Discount){
        if (this.loyaltyMember){
            totalAfterOffersAndOver20Discount *= 0.98;}
        return totalAfterOffersAndOver20Discount;
    }
}
