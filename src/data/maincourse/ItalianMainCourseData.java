package data.maincourse;


import interfaces.CourseItem;

public enum ItalianMainCourseData implements CourseItem {
    PASTA("Pasta", 11.2F),
    RISOTTO("Risotto", 10.5F),
    LASAGNA("Lasagna", 10.5F);

    private final String name;
    private final float price;

    ItalianMainCourseData(String name, float price) {
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
