package _01_WorkingWithAbstraction.exercise._01_CardSuit;

import javax.smartcardio.Card;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        for (CardSuit suit : CardSuit.values()){
            System.out.printf("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit);
        }
    }
}
