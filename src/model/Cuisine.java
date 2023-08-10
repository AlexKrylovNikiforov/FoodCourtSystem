package model;

import interfaces.CourseItem;
import interfaces.DessertItem;

import java.util.List;

public class Cuisine {
    private String name;

    private List<? extends CourseItem> mainCourseList;

    public String getName() {
        return name;
    }

    public List<? extends CourseItem> getMainCourseList() {
        return mainCourseList;
    }

    public void setMainCourseList(List<? extends CourseItem> mainCourseList) {
        this.mainCourseList = mainCourseList;
    }

    public List<? extends DessertItem> getDessertList() {
        return dessertList;
    }

    public void setDessertList(List<? extends DessertItem> dessertList) {
        this.dessertList = dessertList;
    }

    private List<? extends DessertItem> dessertList;

    public void setName(String name) {
        this.name = name;
    }
}
