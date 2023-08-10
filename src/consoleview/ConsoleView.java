package consoleview;


import interfaces.CourseItem;
import interfaces.DessertItem;
import manager.FoodCourtManager;
import model.*;
import service.OutputFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private ConsoleController controller = new ConsoleController();
    private OutputFormatter outputFormatter= new OutputFormatter();
    private FoodCourtManager foodCourtManager = new FoodCourtManager();
    private Scanner sc = new Scanner(System.in);
    private int userInput;
    private List<Cuisine> availableCuisines = foodCourtManager.initializeFoodCourt();;

    public void startApp() {
        System.out.println("HELLO");
        displayMenu();
        while(sc.hasNextLine()) {
            userInput = Integer.parseInt((sc.nextLine()));
            switch (userInput) {
                case 1 -> {
                    System.out.println(outputFormatter.formatMenuOutput(availableCuisines));
                    displayMenu();
                }
                case 2 -> {
                    Lunch currentLunch = controller.selectLunch(availableCuisines);
                    CompleteDrink currentDrink = null;
                    Order currentOrder = foodCourtManager.createOrder(currentLunch, currentDrink);
                    System.out.println("YOUR ORDER: \n" + outputFormatter.formatOrderOutput(currentOrder));
                    displayMenu();
                }
                case 3 -> {
                    Lunch currentLunch = controller.selectLunch(availableCuisines);
                    Drink currentDrink = controller.selectDrink();
                    System.out.println(outputFormatter.formatComplementOutput());
                    displayComplementSelection();
                    List<String> userSelection = controller.selectComplements();
                    List<? extends Complement> selectedComplements = foodCourtManager.getComplementList(userSelection);
                    CompleteDrink completeDrink = foodCourtManager.getCompleteDrink(currentDrink, selectedComplements);
                    Order currentOrder = foodCourtManager.createOrder(currentLunch, completeDrink);
                    System.out.println("YOUR ORDER: \n" + outputFormatter.formatOrderOutput(currentOrder));
                    displayMenu();
                }
                case 4 -> {
                    Drink currentDrink = controller.selectDrink();
                    List<String> userSelection = controller.selectComplements();
                    List<? extends Complement> selectedComplements = foodCourtManager.getComplementList(userSelection);
                    CompleteDrink completeDrink = foodCourtManager.getCompleteDrink(currentDrink, selectedComplements);
                    Lunch lunch = null;
                    Order currentOrder = foodCourtManager.createOrder(lunch, completeDrink);
                    System.out.println("YOUR ORDER: \n" + outputFormatter.formatOrderOutput(currentOrder));
                    displayMenu();
                }
                case 5 -> {
                    System.out.println("BYE, HOPE TO SEE YOU AGAIN");
                    return;
                }
                default -> throw new IllegalStateException("Unexpected value: " + userInput);
            }
        }

    }
    private void displayMenu() {
        System.out.println(("PLEASE MAKE YOUR SELECTION"));
        System.out.println("1. SHOW MENU");
        System.out.println("2. SELECT ONLY LUNCH");
        System.out.println("3. SELECT LUNCH & DRINK");
        System.out.println("4. SELECT ONLY DRINK");
        System.out.println("5. EXIT");
    }

    private void displayComplementSelection() {
        System.out.println("PLEASE SELECT COMPLEMENT");
        System.out.println("1. ONLY ICE");
        System.out.println("2. ONLY LEMON");
        System.out.println("3. ICE & LEMON");
    }

}
