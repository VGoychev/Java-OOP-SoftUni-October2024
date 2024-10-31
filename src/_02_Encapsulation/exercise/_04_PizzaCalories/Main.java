package _02_Encapsulation.exercise._04_PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaElements = scanner.nextLine().split("\\s+");
        Pizza pizza = new Pizza(pizzaElements[1], Integer.parseInt(pizzaElements[2]));

        String[] doughElements = scanner.nextLine().split("\\s+");
        Dough dough = new Dough(doughElements[1], doughElements[2], Double.parseDouble(doughElements[3]));

        pizza.setDough(dough);

        String command = scanner.nextLine();

        while (!command.equals("END")){
            String[] toppingElement = command.split("\\s+");
            Topping topping = new Topping(toppingElement[1], Double.parseDouble(toppingElement[2]));

            pizza.addTopping(topping);
            command = scanner.nextLine();
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
