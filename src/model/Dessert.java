package model;

import interfaces.DessertItem;

public class Dessert implements DessertItem {
    private final String name;
    private final float price;

    public Dessert(String name, float price) {
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
