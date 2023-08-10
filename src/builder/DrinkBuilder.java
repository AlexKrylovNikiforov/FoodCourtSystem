package builder;

import interfaces.ComplementItem;
import model.Complement;
import model.CompleteDrink;
import model.Drink;

import java.util.List;

public class DrinkBuilder implements Builder {

    private CompleteDrink drink = new CompleteDrink();

    public CompleteDrink build() {
        return drink;
    }


    public DrinkBuilder drink(Drink drinkItem) {
        drink.setDrink(drinkItem);
        return this;
    }

    public DrinkBuilder complements(List<? extends Complement> complements) {
        drink.setComplements(complements);
        return this;
    }
}
