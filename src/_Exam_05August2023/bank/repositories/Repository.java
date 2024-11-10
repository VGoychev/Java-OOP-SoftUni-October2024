package _Exam_05August2023.bank.repositories;

import _Exam_05August2023.bank.entities.loan.Loan;

public interface Repository {

    void addLoan(Loan loan);

    boolean removeLoan(Loan loan);

    Loan findFirst(String type);
}
