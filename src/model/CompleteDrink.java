package model;

import interfaces.ComplementItem;

import java.util.List;

public class CompleteDrink {
    private Drink mainDrink;

    private String name;
    private float price;
    private List<? extends Complement> complements;
    public String getName() {
        return name;
    }

    public float getPrice() {
        price = mainDrink.getPrice();
        for(Complement complement: complements) {
            price += complement.getPrice();
        }
        return price;
    }

    public void setDrink(Drink drink) {
        this.mainDrink = drink;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComplements(List<? extends Complement> complements) {
        this.complements = complements;
    }
}
