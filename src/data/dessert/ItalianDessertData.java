package data.dessert;

import interfaces.DessertItem;

public enum ItalianDessertData implements DessertItem {
    TIRAMISU("Tiramisu", 5.2F),
    PANNACOTTA("Pannacotta", 4.7F),
    ZUCOTTA("Zucotta", 4.2F);

    private final String name;
    private final float price;

    ItalianDessertData(String name, float price) {
        this.name = name;
        this.price = price;//
        }

    @Override
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
