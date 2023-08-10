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
        builder.append("\n").append(cuisine.getName().toUpperCase()).append(" MAIN COURSES:").append("\n");
        for (CourseItem courseItem: cuisine.getMainCourseList()) {
            builder.append(courseItem.getName()).append(": ").append(courseItem.getPrice()).append("EUR\n");
        }
        return builder.toString();
    }

    public String formatDessertOutput(Cuisine cuisine) {
        StringBuilder builder = new StringBuilder();
        builder.append(cuisine.getName().toUpperCase()).append(" DESSERTS:").append("\n");
        for (DessertItem dessertItem: cuisine.getDessertList()) {
            builder.append(dessertItem.getName()).append(": ").append(dessertItem.getPrice()).append("EUR\n");
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
        if(order.getLunch() != null) {
            builder.append(order.getLunch().getMainCourse().getName()).append("\n");
            builder.append(order.getLunch().getDessert().getName()).append("\n");
        } else {
            builder.append("No lunch selected\n");
        }
        builder.append(order.getDrink() != null ? order.getDrink().getName() + "\n" : "No drink selected\n");
        builder.append("Total price: ").append(order.getPrice());
        return builder.toString();
    }

    public String formatCuisineListOutput (List<Cuisine> cuisines) {
        StringBuilder builder = new StringBuilder();
        int count = 1;
        for(Cuisine cuisine: cuisines) {
            builder.append(count).append(". ").append(cuisine.getName()).append("\n");
            count++;
        }
        return builder.toString();
    }

    public String formatDrinkOutput() {
        StringBuilder builder = new StringBuilder();
        List<DrinkData> availableDrinks = Arrays.stream(DrinkData.values()).toList();
        for(DrinkData drink: availableDrinks) {
            builder.append(drink.getName()).append(": ").append(drink.getPrice()).append("EUR").append("\n");
        }
        return builder.toString();
    }

    public String formatComplementOutput() {
        StringBuilder builder = new StringBuilder();
        builder.append("COMPLEMENTS: " + "\n");
        List<FreeComplementData> availableComplements = Arrays.stream(FreeComplementData.values()).toList();
        for(FreeComplementData complement: availableComplements) {
            builder.append(complement.getName()).append(": FREE\n");
            return builder.toString();
        }
        return null;
    }
}
