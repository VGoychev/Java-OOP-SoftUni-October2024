package _08_ExceptionsAndErrorHandling.lab;

import java.util.Scanner;

public class _02_SquareRoot {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try{
            int number = Integer.parseInt(input);
            if (number < 0){
                System.out.println("Invalid");
            } else {
                double result = Math.sqrt(number);
                System.out.printf("%.2f%n", result);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }
}
