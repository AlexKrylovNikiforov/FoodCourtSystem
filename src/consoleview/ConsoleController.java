package consoleview;

import manager.FoodCourtManager;
import model.*;
import service.OutputFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleController {
    private final FoodCourtManager foodCourtManager = new FoodCourtManager();
    private final Scanner sc = new Scanner(System.in);
    private final OutputFormatter outputFormatter = new OutputFormatter();
    public Cuisine selectCuisine(List<Cuisine> currentCuisines) {
        String name = sc.nextLine();
        return foodCourtManager.getCuisineByName(currentCuisines, name);
    }

    public MainCourse selectMainCourse(Cuisine cuisine) {
        String courseName = sc.nextLine();
        return foodCourtManager.getCourseByName(cuisine, courseName);
    }

    public Dessert selectDessert(Cuisine cuisine) {
        String dessertName = sc.nextLine();
        return foodCourtManager.getDessertByName(cuisine, dessertName);
    }

    public Lunch selectLunch (List <Cuisine> availableCuisines) {
        System.out.println("PLEASE SELECT CUISINE FOR MAIN COURSE");
        System.out.println(outputFormatter.formatCuisineListOutput(availableCuisines));
        Cuisine cuisineForMainCourse = selectCuisine(availableCuisines);
        System.out.println(outputFormatter.formatMainCourseOutput(cuisineForMainCourse));
        System.out.println("PLEASE SELECT MAIN COURSE");
        MainCourse selectedMainCourse = selectMainCourse(cuisineForMainCourse);
        System.out.println(selectedMainCourse.getClass());
        System.out.println("SELECTED MAIN COURSE: " + selectedMainCourse.getName());
        System.out.println("PLEASE SELECT CUISINE FOR DESSERT");
        System.out.println(outputFormatter.formatCuisineListOutput(availableCuisines));
        Cuisine cuisineForDessert = selectCuisine(availableCuisines);
        System.out.println(outputFormatter.formatDessertOutput(cuisineForDessert));
        System.out.println("PLEASE SELECT THE DESSERT");
        Dessert selectedDessert = selectDessert(cuisineForDessert);
        System.out.println("SELECTED DESSERT: " + selectedDessert.getName());
        return foodCourtManager.getLunch(selectedMainCourse, selectedDessert);
    }

    public Drink selectDrink () {
        System.out.println("PLEASE SELECT YOUR DRINK");
        System.out.println(outputFormatter.formatDrinkOutput());
        String selectedDrink = sc.nextLine();
        return foodCourtManager.getDrinkByName(selectedDrink);
    }

    public List<String> selectComplements() {
        List<String> userSelection = new ArrayList<>();
        int userInput = Integer.parseInt(sc.nextLine());
        switch (userInput) {
            case 1 -> userSelection.add("ice");
            case 2 ->
                userSelection.add("ice");
            case 3 -> {
                userSelection.add("ice");
                userSelection.add("lemon");
            }
        }
        return userSelection;
    }
}
