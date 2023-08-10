package builder;

import interfaces.CourseItem;
import interfaces.DessertItem;
import model.Lunch;

public class LunchBuilder implements Builder{

    private Lunch lunch = new Lunch();

    public Lunch build() {
        return lunch;
    }

    public LunchBuilder mainCourse(CourseItem mainCourse) {
        lunch.setMainCourse(mainCourse);
        return this;
    }

    public LunchBuilder dessert(DessertItem dessert) {
        lunch.setDessert(dessert);
        return this;
    }
}
