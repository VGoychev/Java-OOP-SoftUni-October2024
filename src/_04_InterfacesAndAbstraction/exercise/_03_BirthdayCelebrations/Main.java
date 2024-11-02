package _04_InterfacesAndAbstraction.exercise._03_BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        List<Birthable> birthableList = new ArrayList<>();
        while (!command.equals("End")){
            String[] commandParts = command.split("\\s+");
            switch (commandParts[0]){
                case "Citizen":
                    Birthable birthable = new Citizen(commandParts[1],
                            Integer.parseInt(commandParts[2]),
                            commandParts[3],
                            commandParts[4]);
                    birthableList.add(birthable);
                    break;
                case "Pet":
                    Birthable birthable1 = new Pet(commandParts[1],
                            commandParts[2]);
                    birthableList.add(birthable1);
                    break;
            }

            command = scanner.nextLine();
        }
        String year = scanner.nextLine();
        for (Birthable birthable : birthableList){
            if (birthable.getBirthDate().endsWith(year)){
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
