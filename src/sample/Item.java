package sample;

public class Item {
    private String typeI;
    private String namel;
    private String description;
    private double price;
    private String mf;
    private String picture;

    public Item(String typeI, String namel, String description, double price, String mf, String picture) {
        this.typeI = typeI;
        this.namel = namel;
        this.description = description;
        this.price = price;
        this.mf = mf;
        this.picture = picture;
    }

    public String getTypeI() {
        return typeI;
    }

    public void setTypeI(String typeI) {
        this.typeI = typeI;
    }

    public String getNamel() {
        return namel;
    }

    public void setNamel(String namel) {
        this.namel = namel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMf() {
        return mf;
    }

    public void setMf(String mf) {
        this.mf = mf;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Item{" +
                "typeI='" + typeI + '\'' +
                ", namel='" + namel + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", mf=" + mf +
                ", picture='" + picture + '\'' +
                '}';
    }
}
