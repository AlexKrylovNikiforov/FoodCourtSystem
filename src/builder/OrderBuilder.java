package builder;

import model.CompleteDrink;
import model.Lunch;
import model.Order;

public class OrderBuilder implements Builder{

    private Order order = new Order();

    public Order build() {
        return order;
    }

    public OrderBuilder lunch(Lunch lunch) {
        order.setLunch(lunch);
        return this;
    }

    public OrderBuilder drink(CompleteDrink drink) {
        order.setDrink(drink);
        return this;
    }
}
