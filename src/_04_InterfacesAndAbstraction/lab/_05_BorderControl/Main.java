package _04_InterfacesAndAbstraction.lab._05_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Identifiable> entries = new ArrayList<>();
        String command = scanner.nextLine();

        while (!command.equals("End")){
            String[] commandParts = command.split("\\s+");

            if (commandParts.length == 2){
                String model = commandParts[0];
                String id = commandParts[1];
                Robot robot = new Robot(id, model);
                entries.add(robot);
            } else {
                String name = commandParts[0];
                int age = Integer.parseInt(commandParts[1]);
                String id = commandParts[2];
                Citizen citizen = new Citizen(name, age, id);
                entries.add(citizen);
            }

            command = scanner.nextLine();
        }
        String endNumbers = scanner.nextLine();

        for (Identifiable identifiable : entries){
            if (identifiable.getId().endsWith(endNumbers)){
                System.out.println(identifiable.getId());
            }
        }
    }
}
