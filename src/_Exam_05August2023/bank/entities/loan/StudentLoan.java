package _Exam_05August2023.bank.entities.loan;

public class StudentLoan extends BaseLoan{
    private static final int INTEREST_RATE = 1;
    private static final double AMOUNT = 10000;

    public StudentLoan() {
        super(INTEREST_RATE, AMOUNT);
    }
}
