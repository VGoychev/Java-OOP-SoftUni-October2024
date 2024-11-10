package _Exam_05August2023.bank.entities.client;

public abstract class BaseClient implements Client{
   private String name;
   private String ID;
   private int interest;
   private double income;

    public BaseClient(String name, String ID, int interest, double income) {
        this.setName(name);
        this.setID(ID);
        this.setInterest(interest);
        this.setIncome(income);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Client name cannot be null or empty.");
        } else {
            this.name = name;
        }
    }

    public String getID() {
        return ID;
    }

    private void setID(String ID) {
        if (ID == null || ID.trim().isEmpty()) {
            throw new IllegalArgumentException("Client's ID cannot be null or empty.");
        } else {
            this.ID = ID;
        }
    }

    @Override
    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    @Override
    public double getIncome() {
        return income;
    }

    private void setIncome(double income) {
        if (income <= 0) {
            throw new IllegalArgumentException("Client income cannot be below or equal to 0.");
        } else {
            this.income = income;
        }
    }

    @Override
    public abstract void increase();
}
