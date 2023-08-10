package data.dessert;


import interfaces.DessertItem;

public enum PolishDessertData implements DessertItem {
    CIASTA("Ciasta",5.2F),
    MAZUREK("Mazurek",4.7F),
    KOLACZKI("Kolaczki", 4.2F);

    private final String name;
    private final float price;

    PolishDessertData(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
