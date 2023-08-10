package model;

public class Drink {

    private final String name;

    private final float price;

    public Drink(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

}
