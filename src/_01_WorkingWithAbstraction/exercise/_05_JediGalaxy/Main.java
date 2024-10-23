package _01_WorkingWithAbstraction.exercise._05_JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    private static long sum = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = fillMatrix(scanner);
        String command = scanner.nextLine();

        while (!command.equals("Let the Force be with you")) {
            int[] playerCoordinates = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int evilX = evilCoordinates[0];
            int evilY = evilCoordinates[1];

            moveEvil(evilX, evilY, matrix);

            int playerX = playerCoordinates[0];
            int playerY = playerCoordinates[1];

            movePlayer(matrix, playerX, playerY);

            command = scanner.nextLine();
        }

        System.out.println(sum);

    }

    private static void movePlayer(int[][] matrix,int row, int col) {
        while (row >= 0 && col < matrix[1].length) {
            if (row < matrix.length && col >= 0) {
                sum += matrix[row][col];
            }

            col++;
            row--;
        }
    }

    private static void moveEvil(int row, int col, int[][] matrix) {
        while (row >= 0 && col >= 0) {
            if (row < matrix.length && col < matrix[0].length) {
                matrix[row] [col] = 0;
            }
            row--;
            col--;
        }
    }

    private static int[][] fillMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int x = dimensions[0];
        int y = dimensions[1];
        int[][] matrix = new int[x][y];
        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }
}
