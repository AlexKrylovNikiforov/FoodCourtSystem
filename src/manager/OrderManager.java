package manager;

import builder.OrderBuilder;
import model.CompleteDrink;
import model.Lunch;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager implements Manager {

    private List<Order> orderList = new ArrayList<>();

    public Order createOrder(Lunch lunch, CompleteDrink drink) {
        if(drink == null) {
            return new OrderBuilder().lunch(lunch).build();
        }
        else if(lunch == null) {
            return new OrderBuilder().drink(drink).build();
        }
        else {
            return new OrderBuilder().lunch(lunch).drink(drink).build();
        }
    }


    public void saveOrder(Order currentOrder) {
        orderList.add(currentOrder);
    }
}
