package by.it.malishevskiy.jd03_03.beans;

import java.util.Objects;

public class Ads {
    private int ID;
    private String animal;
    private double weight;
    private String color;
    private int Price;
    private String price;
    private String description;
    private String adress;
    private int users_ID;


    public Ads() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getUser_ID() {
        return users_ID;
    }

    public void setUser_ID(int user_ID) {
        this.users_ID = user_ID;
    }

    public void setPrice(int price) {
        Price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ads ads = (Ads) o;
        return ID == ads.ID && Price == ads.Price && users_ID == ads.users_ID && Objects.equals(animal, ads.animal) && Objects.equals(weight, ads.weight) && Objects.equals(color, ads.color) && Objects.equals(price, ads.price) && Objects.equals(description, ads.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, animal, weight, color, Price, price, description, users_ID);
    }

    public Ads(int ID, String animal, double weight, String color, int price, String price1, String description, String adress, int user_ID) {
        this.ID = ID;
        this.animal = animal;
        this.weight = weight;
        this.color = color;
        Price = price;
        this.price = price1;
        this.description = description;
        this.adress = adress;
        this.users_ID = user_ID;
    }

    public Ads(String ID, String animal, double weight, String s, String color, String description, String adress, long user_ID) {
    }

    @Override
    public String toString() {
        return "Ads{" + "ID=" + ID +
                ", animal='" + animal + '\'' +
                ", weight='" + weight + '\'' +
                ", color='" + color + '\'' +
                ", Price=" + Price + ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", adress" + adress + '\'' +
                ", user_ID=" + users_ID + '}';
    }
}
