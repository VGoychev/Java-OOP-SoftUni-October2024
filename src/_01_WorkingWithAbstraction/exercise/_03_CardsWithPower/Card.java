package _01_WorkingWithAbstraction.exercise._03_CardsWithPower;

public class Card {
    private int power;
    private CardRank rank;
    private CardSuit suit;
    Card(CardRank rank, CardSuit suit){
        this.rank = rank;
        this.suit = suit;
        this.power = rank.getPower() + suit.getPower();
    }

    public int getPower(){
        return power;
    }

}
