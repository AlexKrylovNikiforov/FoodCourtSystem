package builder;

import model.Dessert;
import model.Lunch;
import model.MainCourse;

public class LunchBuilder implements Builder{

    private Lunch lunch = new Lunch();

    public Lunch build() {
        return lunch;
    }

    public LunchBuilder mainCourse(MainCourse mainCourse) {
        lunch.setMainCourse(mainCourse);
        return this;
    }

    public LunchBuilder dessert(Dessert dessert) {
        lunch.setDessert(dessert);
        return this;
    }
}
