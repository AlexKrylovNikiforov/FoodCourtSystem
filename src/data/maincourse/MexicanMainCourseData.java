package data.maincourse;


import interfaces.CourseItem;

public enum MexicanMainCourseData implements CourseItem {
    BURRITO("Burrito", 11.2F),
    ENCHILADA("Enchilada", 10.5F),
    QUESADILLA("Quesadilla", 10.5F);

    private final String name;
    private final float price;

    MexicanMainCourseData(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
