package _01_WorkingWithAbstraction.lab._04_HotelReservation;

public enum Discount {
    VIP(0.20),
    SecondVisit(0.10),
    None(0);

    private double percentage;

    Discount(double percentage){
        this.percentage = percentage;
    }
    public double getPercentage(){
        return percentage;
    }
}
