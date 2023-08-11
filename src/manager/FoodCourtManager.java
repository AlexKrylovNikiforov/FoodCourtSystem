package manager;

import data.dessert.ItalianDessertData;
import data.dessert.MexicanDessertData;
import data.dessert.PolishDessertData;
import data.maincourse.ItalianMainCourseData;
import data.maincourse.MexicanMainCourseData;
import data.maincourse.PolishMainCourseData;
import interfaces.CourseItem;
import interfaces.DessertItem;
import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoodCourtManager implements Manager{
    private final CuisineManager cuisineManager = new CuisineManager();
    private final OrderManager orderManager = new OrderManager();

    public List<Cuisine> initializeFoodCourt() {
        List<Cuisine> availableCuisines = new ArrayList<>();
        List<ItalianMainCourseData> italianMainCourseItems = Arrays.stream(ItalianMainCourseData.values()).toList();
        List<ItalianDessertData> italianDessertItems = Arrays.stream(ItalianDessertData.values()).toList();
        List<MexicanMainCourseData> mexicanMainCourseItems = Arrays.stream(MexicanMainCourseData.values()).toList();
        List<MexicanDessertData> mexicanDessertItems = Arrays.stream(MexicanDessertData.values()).toList();
        List<PolishMainCourseData> polishMainCourseItems = Arrays.stream(PolishMainCourseData.values()).toList();
        List<PolishDessertData> polishDessertItems = Arrays.stream(PolishDessertData.values()).toList();
        Cuisine italianCuisine = initializeCuisine("Italian", italianMainCourseItems, italianDessertItems);
        Cuisine mexicanCuisine = initializeCuisine("Mexican", mexicanMainCourseItems, mexicanDessertItems);
        Cuisine polishCuisine = initializeCuisine("Polish", polishMainCourseItems, polishDessertItems);
        availableCuisines.add(italianCuisine);
        availableCuisines.add(mexicanCuisine);
        availableCuisines.add(polishCuisine);
        return availableCuisines;
    }

    public Cuisine getCuisineByName(List<Cuisine> cuisines, String name) {
        return cuisineManager.findCuisineByName(cuisines, name);
    }

    public MainCourse getCourseByName(Cuisine cuisine, String courseName) {
        return cuisineManager.findCourseByName(cuisine, courseName);
    }

    public Dessert getDessertByName (Cuisine cuisine, String dessertName) {
        return cuisineManager.findDessertByName(cuisine, dessertName);
    }

    public Drink getDrinkByName(String name) {
        return cuisineManager.findDrinkByName(name);
    }

    private Cuisine initializeCuisine(String name, List<? extends CourseItem> mainCourses, List<? extends DessertItem> desserts) {
        return cuisineManager.initializeCuisine(name, mainCourses, desserts);
    }

    public Lunch getLunch(MainCourse mainCourse, Dessert dessert) {
        return cuisineManager.getLunch(mainCourse, dessert);
    }

    public Order createOrder(Lunch lunch, CompleteDrink drink) {
        return orderManager.createOrder(lunch, drink);
    }

    public CompleteDrink getCompleteDrink(Drink drink, List<? extends Complement> complements) {
        return cuisineManager.getCompleteDrink(drink, complements);
    }

    public List<? extends Complement> getComplementList(List<String> selectedComplements) {
        List<Complement> currentComplements = new ArrayList<>();
        for(String selectedCoplement: selectedComplements) {
            currentComplements.add(cuisineManager.findFreeComplementByName(selectedCoplement));
        }
        return currentComplements;
    }
}
