package model;

public class Lunch{

    private MainCourse mainCourse;
    private Dessert dessert;
    private float price;

    public MainCourse getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourse = mainCourse;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }


    public float getPrice() {
        return mainCourse.getPrice() + dessert.getPrice();
    }
}

