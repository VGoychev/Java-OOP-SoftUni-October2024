package _05_Polymorphism.exercise._01_Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));

        String[] truckInfo = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            action(command, car, truck);
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
    }

    private static void action(String command, Vehicle car, Vehicle truck) {
        String[] commandParts = command.split("\\s+");
        switch (commandParts[0]){
            case "Drive":
                if (commandParts[1].equals("Car")){
                    car.drive(Double.parseDouble(commandParts[2]));
                } else if (commandParts[1].equals("Truck")){
                    truck.drive(Double.parseDouble(commandParts[2]));
                }
                break;
            case "Refuel":
                if (commandParts[1].equals("Car")){
                    car.refuel(Double.parseDouble(commandParts[2]));
                } else if (commandParts[1].equals("Truck")){
                    truck.refuel(Double.parseDouble(commandParts[2]));
                }
                break;
        }
    }
}
