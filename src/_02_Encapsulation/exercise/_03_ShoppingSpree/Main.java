package _02_Encapsulation.exercise._03_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] persons = scanner.nextLine().split(";");
        List<Person> personList = new ArrayList<>();
        fillPersonsData(persons, personList);
        String[] food = scanner.nextLine().split(";");
        List<Product> products = new ArrayList<>();
        fillFoodData(food, products);

        String command = scanner.nextLine();
        while (!command.equals("END")){
            String[] commandParts = command.split("\\s++");
            for (Person person : personList){
                if (person.getName().equals(commandParts[0])){
                    for (Product product : products){
                        if (product.getName().equals(commandParts[1])){
                            person.buyProduct(product);
                        }
                    }
                }
            }
            command = scanner.nextLine();
        }
        for (Person person : personList){
            printPersonData(person);
        }
    }

    private static void fillPersonsData(String[] input, List<Person> personList) {
        for (String people : input) {
            String[] personData = people.split("=");
            String personName = personData[0];
            double personMoney = Double.parseDouble(personData[1]);
            Person person = new Person(personName, personMoney);
            personList.add(person);
        }
    }
    private static void fillFoodData(String[] food, List<Product> products) {
        for (String current : food) {
            String[] foodData = current.split("=");
            String foodName = foodData[0];
            double foodCost = Double.parseDouble(foodData[1]);
            Product product = new Product(foodName, foodCost);
            products.add(product);
        }
    }
    private static void printPersonData(Person person){
       if (person.getProducts().isEmpty()){
           System.out.printf("%s - Nothing bought%n", person.getName());
       } else {
           System.out.printf("%s - ", person.getName());
           for (int i = 0; i < person.getProducts().size(); i++) {
               System.out.printf("%s", person.getProducts().get(i).getName());
               if (i < person.getProducts().size() - 1){
                   System.out.print(", ");
               }
           }
           System.out.printf("%n");
       }
    }
}
