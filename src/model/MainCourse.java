package model;

import interfaces.CourseItem;

public class MainCourse implements CourseItem {
    private final String name;
    private final float price;

    public MainCourse(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
