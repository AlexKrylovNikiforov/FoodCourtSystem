package model;

import interfaces.CourseItem;
import interfaces.DessertItem;

public class Lunch{

    private CourseItem mainCourse;
    private DessertItem dessert;

    private float price = mainCourse.getPrice() + dessert.getPrice();

    public CourseItem getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(CourseItem mainCourse) {
        this.mainCourse = mainCourse;
    }

    public DessertItem getDessert() {
        return dessert;
    }

    public void setDessert(DessertItem dessert) {
        this.dessert = dessert;
    }


    public float getPrice() {
        return price;
    }
}

