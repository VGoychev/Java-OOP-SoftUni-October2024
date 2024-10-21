package _01_WorkingWithAbstraction.lab._01_RhombusOfStars;

import java.util.Scanner;

public class _01_RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //size
        int size = Integer.parseInt(scanner.nextLine());

        
        printRhombusOfStars(size);
    }

    private static void printRhombusOfStars(int size) {

        if( size == 1){
            System.out.println("*");
            return;
        }
            // up
        for (int row = 1; row <= size; row++) {
            printRowOfStars(row, size);
        }

        //down
        for (int row = size - 1; row >= 1; row--) {
            printRowOfStars(row, size);
        }

        System.out.println();
    }

    private static void printRowOfStars(int row, int size) {

        int countOfWhiteSpace = size - row;
        for (int i = 1; i <= countOfWhiteSpace; i++) {
            System.out.print(" ");
        }
        for (int star = 1; star <= row; star++) {
            System.out.print("* ");

        }
        System.out.println();
    }


}
