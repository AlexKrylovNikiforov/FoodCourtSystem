package data.complement;

import interfaces.FreeItem;

public enum FreeComplementData implements FreeItem {
    ICE("Ice Cube"),
    LEMON("Lemon Slice");

    private final String name;
    FreeComplementData(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public float getPrice() {
        return 0.0F;
    }
}
