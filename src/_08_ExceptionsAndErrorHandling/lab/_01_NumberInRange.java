package _08_ExceptionsAndErrorHandling.lab;

import java.util.Scanner;

public class _01_NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        System.out.println("Range: [" + start + "..." + end + "]");
        int validNumber = readValidNumber(scanner, start, end);
        System.out.println("Valid number: " + validNumber);

    }
    private static int readValidNumber(Scanner scanner, int startRange, int endRange) {
        while (true) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number >= startRange && number <= endRange) {
                    return number;
                }
                System.out.printf("Invalid number: %s%n", input);
            } catch (NumberFormatException exception) {
                System.out.printf("Invalid number: %s%n", input);
            }
        }
    }
}
