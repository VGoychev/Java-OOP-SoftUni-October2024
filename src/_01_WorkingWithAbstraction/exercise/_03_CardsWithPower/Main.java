package _01_WorkingWithAbstraction.exercise._03_CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CardRank rank = CardRank.valueOf(scanner.nextLine());
        CardSuit suit = CardSuit.valueOf(scanner.nextLine());

        Card card = new Card(rank, suit);

        System.out.printf("Card name: %s of %s; Card power: %d", rank, suit, card.getPower());
    }
}
