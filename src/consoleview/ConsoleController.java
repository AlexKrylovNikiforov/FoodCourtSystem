package consoleview;

import interfaces.CourseItem;
import interfaces.DessertItem;
import manager.FoodCourtManager;
import model.Cuisine;
import model.Drink;
import model.Lunch;
import service.OutputFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleController {
    private FoodCourtManager foodCourtManager = new FoodCourtManager();
    private Scanner sc = new Scanner(System.in);
    private OutputFormatter outputFormatter = new OutputFormatter();
    public Cuisine selectCuisine(List<Cuisine> currentCuisines) {
        String name = sc.nextLine();
        return foodCourtManager.getCuisineByName(currentCuisines, name);
    }

    public CourseItem selectMainCourse(Cuisine cuisine) {
        String courseName = sc.nextLine();
        return foodCourtManager.getCourseByName(cuisine, courseName);
    }

    public DessertItem selectDessert(Cuisine cuisine) {
        String dessertName = sc.nextLine();
        return foodCourtManager.getDessertByName(cuisine, dessertName);
    }

    public Lunch selectLunch (List <Cuisine> availableCuisines) {
        System.out.println("PLEASE SELECT CUISINE FOR MAIN COURSE");
        System.out.println(outputFormatter.formatCuisineListOutput(availableCuisines));
        Cuisine cuisineForMainCourse = selectCuisine(availableCuisines);
        System.out.println(outputFormatter.formatMainCourseOutput(cuisineForMainCourse));
        System.out.println("PLEASE SELECT MAIN COURSE");
        CourseItem selectedMainCourse = selectMainCourse(cuisineForMainCourse);
        System.out.println(selectedMainCourse.getClass());
        System.out.println("SELECTED MAIN COURSE: " + selectedMainCourse.getName());
        System.out.println("PLEASE SELECT CUISINE FOR DESSERT");
        System.out.println(outputFormatter.formatCuisineListOutput(availableCuisines));
        Cuisine cuisineForDessert = selectCuisine(availableCuisines);
        System.out.println(outputFormatter.formatDessertOutput(cuisineForDessert));
        System.out.println("PLEASE SELECT THE DESSERT");
        DessertItem selectedDessert = selectDessert(cuisineForDessert);
        System.out.println("SELECTED DESSERT: " + selectedDessert.getName());
        Lunch currentLunch = foodCourtManager.getLunch(selectedMainCourse, selectedDessert);
        return currentLunch;
    }

    public Drink selectDrink () {
        System.out.println("PLEASE SELECT YOUR DRINK");
        System.out.println(outputFormatter.formatDrinkOutput());
        String selectedDrink = sc.nextLine();
        Drink currentDrink = foodCourtManager.getDrinkByName(selectedDrink);
        return currentDrink;
    }

    public List<String> selectComplements() {
        List<String> userSelection = new ArrayList<>();
        int userInput = Integer.parseInt(sc.nextLine());
        switch (userInput) {
            case 1 -> {
                userSelection.add("ice");
            }
            case 2 -> {
                userSelection.add("ice");
            }
            case 3 -> {
                userSelection.add("ice");
                userSelection.add("lemon");
            }
        }
        return userSelection;
    }
}
