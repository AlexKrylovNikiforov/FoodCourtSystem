package model;

public class FreeComplement extends Complement{

    private static final float price = 0.0F;
    @Override
    public float getPrice() {
        return price;
    }

    public FreeComplement(String name) {
        super(name, price);
    }
}
