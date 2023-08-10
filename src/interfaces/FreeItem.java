package interfaces;

public interface FreeItem extends ComplementItem {
    String getName();
    default float getPrice() {
        return 0.0F;
    }
}
