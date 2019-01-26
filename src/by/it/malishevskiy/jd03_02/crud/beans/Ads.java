package by.it.malishevskiy.jd03_02.crud.beans;

import java.util.Objects;

public class Ads {
    private int ID;
    private String animal;
    private String weight;
    private String color;
    private int Price;
    private String price;
    private String description;
    private int user_ID;

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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
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

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public void setPrice(int price) {
        Price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ads ads = (Ads) o;
        return ID == ads.ID && Price == ads.Price && user_ID == ads.user_ID && Objects.equals(animal, ads.animal) && Objects.equals(weight, ads.weight) && Objects.equals(color, ads.color) && Objects.equals(price, ads.price) && Objects.equals(description, ads.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, animal, weight, color, Price, price, description, user_ID);
    }

    public Ads(int ID, String animal, String weight, String color, int price, String price1, String description, int user_ID) {
        this.ID = ID;
        this.animal = animal;
        this.weight = weight;
        this.color = color;
        Price = price;
        this.price = price1;
        this.description = description;
        this.user_ID = user_ID;
    }

    public Ads(String ID, String animal, double weight, String s, String color, String description, long user_ID) {
    }

    @Override
    public String toString() {
        return "Ads{" + "ID=" + ID +
                ", animal='" + animal + '\'' +
                ", weight='" + weight + '\'' +
                ", color='" + color + '\'' +
                ", Price=" + Price + ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", user_ID=" + user_ID + '}';
    }
}
