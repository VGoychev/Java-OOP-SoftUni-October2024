package _04_InterfacesAndAbstraction.exercise._04_FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Citizen> citizens = new ArrayList<>();
        List<Rebel> rebels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            if (info.length == 4){
                Citizen citizen = new Citizen(info[0],
                        Integer.parseInt(info[1]), info[2], info[3]);
                citizens.add(citizen);
            } else if(info.length == 3){
                Rebel rebel = new Rebel(info[0],
                        Integer.parseInt(info[1]), info[2]);
                rebels.add(rebel);
            }

        }
        String command = scanner.nextLine();

        while (!command.equals("End")){
            for (Rebel rebel : rebels){
                if (rebel.getName().equals(command)){
                    rebel.buyFood();
                }
            }
            for (Citizen citizen : citizens){
                if (citizen.getName().equals(command)){
                    citizen.buyFood();
                }
            }
            command = scanner.nextLine();
        }

        int totalFood = 0;
        for (Rebel rebel : rebels){
            totalFood += rebel.getFood();
        }
        for (Citizen citizen : citizens){
            totalFood += citizen.getFood();
        }
        System.out.println(totalFood);

    }
}
