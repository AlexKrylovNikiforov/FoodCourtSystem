package data.complement;

import interfaces.Item;

public enum ComplementData implements Item {
    ;
    private String label;
    private float price;

    @Override
    public String getName() {
        return label;
    }

    public float getPrice() {
        return price;
    }


}
