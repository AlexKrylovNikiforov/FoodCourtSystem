package data.maincourse;

import interfaces.CourseItem;


public enum PolishMainCourseData implements CourseItem {
    FLAKI("Flaki", 11.2F),
    BIGOS("Bigos", 10.5F),
    PIEROGI("Pierogi", 10.5F);

    private final String name;
    private final float price;

    PolishMainCourseData(String name, float price) {
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
