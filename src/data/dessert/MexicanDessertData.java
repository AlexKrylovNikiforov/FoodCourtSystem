package data.dessert;


import interfaces.DessertItem;

public enum MexicanDessertData implements DessertItem {
    CHURROS("Churros", 5.2F),
    FLAN("Flan de huevo", 4.7F),
    TRES_LECHES("Tarta Tres Leches",4.2F);

    private final String name;
    private final float price;

    MexicanDessertData(String name, float price) {
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
