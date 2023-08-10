package data.drink;

public enum DrinkData {
    FANTA("Fanta", 1.1F),
    COCA_COLA("Coca Cola", 1.1F),
    ORANGE_JUICE("Orange Juice", 1.1F),
    WATER("Mineral Water", 0.8F),
    COFFEE("Simple Expresso", 1.2F),
    TEA("Earl Grey Tea", 1.1F);
    private final String name;
    private final float price;

    DrinkData(String label, float price) {
        this.name = label;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
