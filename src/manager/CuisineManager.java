package manager;

import builder.CuisineBuilder;
import builder.DrinkBuilder;
import builder.LunchBuilder;
import data.complement.FreeComplementData;
import data.drink.DrinkData;
import interfaces.CourseItem;
import interfaces.DessertItem;
import model.*;


import java.util.ArrayList;
import java.util.List;


public class CuisineManager implements Manager{

    public Cuisine initializeCuisine(String name, List<? extends CourseItem> mainCourses, List<? extends DessertItem> desserts) {
        return new CuisineBuilder().name(name).mainCourseList(mainCourses).dessertList(desserts).build();
    }

    public MainCourse findCourseByName (Cuisine cuisine, String name) {
        for(CourseItem mainCourse: cuisine.getMainCourseList()) {
            if(mainCourse.getName().equalsIgnoreCase(name)) {
                return new MainCourse(name, mainCourse.getPrice());
            }
        }
        throw new RuntimeException("No course found");
    }

    public Dessert findDessertByName (Cuisine cuisine, String name) {
        for(DessertItem dessert: cuisine.getDessertList()) {
            if(dessert.getName().equalsIgnoreCase(name)) {
                return new Dessert(name, dessert.getPrice());
            }
        }
        throw new RuntimeException("No dessert found");
    }

    public Cuisine findCuisineByName(List<Cuisine> cuisines, String name) {
        for(Cuisine cuisine: cuisines) {
            if(cuisine.getName().equalsIgnoreCase(name)) {
                return cuisine;
            }
        }
        throw new RuntimeException("No cuisine found");
    }

    public Lunch getLunch(MainCourse mainCourse, Dessert dessert) {
        return new LunchBuilder().mainCourse(mainCourse).dessert(dessert).build();
    }

    public Drink findDrinkByName(String name) {
        for(DrinkData drink: DrinkData.values()) {
            if(drink.getName().equalsIgnoreCase(name)) {
                return new Drink(name, drink.getPrice());
            }
        }
        throw new RuntimeException("No drink found");
    }

    public List<? extends Complement> getFreeComplements(List<String> selectedComplements) {
        List<FreeComplement> complements = new ArrayList<>();
        for(FreeComplementData complement: FreeComplementData.values()) {
            for(String selectedComplement: selectedComplements) {
                if(selectedComplement.equalsIgnoreCase(complement.getName())) {
                    complements.add(new FreeComplement(complement.getName()));
                }
            }
            return complements;
        }
        throw new RuntimeException("No complement found");
    }

    public CompleteDrink getCompleteDrink(Drink drink, List<? extends Complement> complements) {
        return new DrinkBuilder().drink(drink).complements(complements).build();
    }

    public Complement getFreeComplement(String selectedCoplement) {
        for(FreeComplementData freeComplementData: FreeComplementData.values()) {
            if(selectedCoplement.equalsIgnoreCase(freeComplementData.getName())) {
                return new FreeComplement(selectedCoplement);
            }
        }
        throw new RuntimeException("No complement found");
    }
}
