package service;

import data.complement.FreeComplementData;
import data.drink.DrinkData;
import interfaces.CourseItem;
import interfaces.DessertItem;
import model.Cuisine;
import model.Order;

import java.util.Arrays;
import java.util.List;

public class OutputFormatter {
    public String formatCuisineOutput (Cuisine cuisine) {
        return formatMainCourseOutput(cuisine) + formatDessertOutput(cuisine);
    }

    public String formatMainCourseOutput (Cuisine cuisine) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n" + cuisine.getName().toUpperCase() + " MAIN COURSES:" + "\n");
        for (CourseItem courseItem: cuisine.getMainCourseList()) {
            builder.append(courseItem.getName() + ": " + courseItem.getPrice() + "EUR\n");
        }
        return builder.toString();
    }

    public String formatDessertOutput(Cuisine cuisine) {
        StringBuilder builder = new StringBuilder();
        builder.append(cuisine.getName().toUpperCase() + " DESSERTS:" + "\n");
        for (DessertItem dessertItem: cuisine.getDessertList()) {
            builder.append(dessertItem.getName() + ": " + dessertItem.getPrice() + "EUR\n");
        }
        return builder.toString();
    }

    public String formatMenuOutput (List<Cuisine> availableCuisines) {
        StringBuilder builder = new StringBuilder();
        for(Cuisine cuisine: availableCuisines) {
            builder.append(formatCuisineOutput(cuisine));
        }
        return builder.toString();
    }

    public String formatOrderOutput(Order order) {
        StringBuilder builder = new StringBuilder();
        builder.append(order.getLunch() + "\n" + order.getDrink() != null ? order.getDrink() : "");
        builder.append("Total price: " + order.getPrice());
        return builder.toString();
    }

    public String formatCuisineListOutput (List<Cuisine> cuisines) {
        StringBuilder builder = new StringBuilder();
        int count = 1;
        for(Cuisine cuisine: cuisines) {
            builder.append(count + ". " + cuisine.getName() + "\n");
            count++;
        }
        return builder.toString();
    }

    public String formatDrinkOutput() {
        StringBuilder builder = new StringBuilder();
        List<DrinkData> availableDrinks = Arrays.stream(DrinkData.values()).toList();
        for(DrinkData drink: availableDrinks) {
            builder.append(drink.getName() + ": " + drink.getPrice() + "EUR");
        }
        return builder.toString();
    }

    public String formatComplementOutput() {
        StringBuilder builder = new StringBuilder();
        builder.append("COMPLEMENTS: " + "\n");
        List<FreeComplementData> availableComplements = Arrays.stream(FreeComplementData.values()).toList();
        for(FreeComplementData complement: availableComplements) {
            builder.append(complement.getName() + ": FREE");
            return builder.toString();
        }
        return null;
    }
}
