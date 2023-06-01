public class Item {

    private String name;
    private Double price;
    private String currentOffer;

    public Item(String name, Double price, String currentOffer){
        this.name = name;
        this.price = price;
        this.currentOffer = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrentOffer() {
        return currentOffer;
    }

    public void setCurrentOffer(String Offer) {
        this.currentOffer = Offer;
    }
}
