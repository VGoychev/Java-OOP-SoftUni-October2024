package _Exam_05August2023.bank.repositories;

import _Exam_05August2023.bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;

public class LoanRepository implements Repository{
    private Collection<Loan> loans;

    public LoanRepository(){
        this.loans = new ArrayList<>();
    }

    @Override
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    @Override
    public boolean removeLoan(Loan loan) {
        if (loans.contains(loan)){
            loans.remove(loan);
            return true;
        }
        return false;
    }

    @Override
    public Loan findFirst(String type) {
        for (Loan loan : this.loans){
            if (loan.getClass().getSimpleName().equals(type)){
                return loan;
            }
        }
        return null;
    }
}
