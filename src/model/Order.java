package model;

public class Order{
    private Lunch lunch;
    private CompleteDrink drink;
    private float price = drink != null ? lunch.getPrice() + drink.getPrice() : lunch.getPrice();

    public Lunch getLunch() {
        return lunch;
    }

    public void setLunch(Lunch lunch) {
        this.lunch = lunch;
    }

    public CompleteDrink getDrink() {
        return drink;
    }

    public void setDrink(CompleteDrink drink) {
        this.drink = drink;
    }

    public float getPrice() {
        return price;
    }
}
