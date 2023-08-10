package builder;

import interfaces.CourseItem;
import interfaces.DessertItem;
import model.Cuisine;

import java.util.List;

public class CuisineBuilder implements Builder{

    private Cuisine cuisine = new Cuisine();


    public Cuisine build() {
        return cuisine;
    }

    public CuisineBuilder name(String name) {
        cuisine.setName(name);
        return this;
    }

    public CuisineBuilder mainCourseList(List<? extends CourseItem> mainCourseList) {
        cuisine.setMainCourseList(mainCourseList);
        return this;
    }

    public CuisineBuilder dessertList(List<? extends DessertItem> dessertList) {
        cuisine.setDessertList(dessertList);
        return this;
    }
}
