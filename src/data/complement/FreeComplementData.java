package data.complement;

import interfaces.FreeItem;

public enum FreeComplementData implements FreeItem {
    ICE("Ice Cube"),
    LEMON("Lemon Slice");

    private final String label;
    FreeComplementData(String label) {
        this.label = label;
    }

    @Override
    public String getName() {
        return label;
    }

    public float getPrice() {
        return this.getPrice();
    }
}
