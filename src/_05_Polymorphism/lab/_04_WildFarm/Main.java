package _05_Polymorphism.lab._04_WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        List<Animal> animals = new ArrayList<>();

        while (!command.equals("End")){
            Animal animal = createAnimal(command);
            String[] foodData = scanner.nextLine().split("\\s+");
            Food food = createFood(foodData);
            animal.makeSound();
            animal.eat(food);
            animals.add(animal);
            command = scanner.nextLine();
        }
        for (Animal animal : animals){
            System.out.println(animal.toString());
        }
    }

    private static Animal createAnimal(String input){
        String[] commandParts = input.split("\\s+");
        String animalType = commandParts[0];
        Animal animal = null;
        if (animalType.equals("Cat")){
            animal = new Cat(commandParts[1], animalType, Double.parseDouble(commandParts[2]),commandParts[3],commandParts[4]);
        } else if (animalType.equals("Mouse")){
            animal = new Mouse(commandParts[1], animalType, Double.parseDouble(commandParts[2]), commandParts[3]);
        } else if (animalType.equals("Tiger")){
            animal = new Tiger(commandParts[1], animalType, Double.parseDouble(commandParts[2]), commandParts[3]);
        } else if (animalType.equals("Zebra")){
            animal = new Zebra(commandParts[1], animalType, Double.parseDouble(commandParts[2]), commandParts[3]);
        }
        return animal;
    }

    private static Food createFood(String[] input){
        Food food = null;
        if (input[0].equals("Vegetable")){
            food = new Vegetable(Integer.parseInt(input[1]));
        } else {
            food = new Meat(Integer.parseInt(input[1]));
        }
        return food;
    }

    private static boolean isCat(String input){
        if (input.equals("Cat")){
            return true;
        } else {
            return false;
        }
    }
}
