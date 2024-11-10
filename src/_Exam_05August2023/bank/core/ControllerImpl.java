package _Exam_05August2023.bank.core;

import _Exam_05August2023.bank.entities.bank.Bank;
import _Exam_05August2023.bank.entities.bank.BranchBank;
import _Exam_05August2023.bank.entities.bank.CentralBank;
import _Exam_05August2023.bank.entities.client.Adult;
import _Exam_05August2023.bank.entities.client.Client;
import _Exam_05August2023.bank.entities.client.Student;
import _Exam_05August2023.bank.entities.loan.Loan;
import _Exam_05August2023.bank.entities.loan.MortgageLoan;
import _Exam_05August2023.bank.entities.loan.StudentLoan;
import _Exam_05August2023.bank.repositories.LoanRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller{
    private Collection<Bank> banks;
    private LoanRepository loans;

    public ControllerImpl(){
        this.banks = new ArrayList<>();
        this.loans = new LoanRepository();
    }
    @Override
    public String addBank(String type, String name) {
        Bank bank;
        if (type.equals("CentralBank")){
            bank = new CentralBank(name);
        } else if (type.equals("BranchBank")){
            bank = new BranchBank(name);
        } else {
            throw new NullPointerException("Invalid bank type.");
        }
        this.banks.add(bank);

        return String.format("%s is successfully added.", type);
    }

    @Override
    public String addLoan(String type) {
        Loan loan;
        if (type.equals("StudentLoan")){
            loan = new StudentLoan();
        } else if (type.equals("MortgageLoan")){
            loan = new MortgageLoan();
        } else {
            throw new IllegalArgumentException("Invalid loan type.");
        }
        this.loans.addLoan(loan);
        return String.format("%s is successfully added.", type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Loan loan = this.loans.findFirst(loanType);
        if (loan == null){
            throw new IllegalArgumentException("Loan of type " + loanType + " is missing.");
        }
        for (Bank bank : banks){
            if (bank.getName().equals(bankName)) {
                bank.addLoan(loan);
                this.loans.removeLoan(loan);
            }
        }
        return String.format("%s successfully added to %s.", loanType, bankName);
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        Client client;
        if (clientType.equals("Student")){
            client = new Student(clientName,clientID,income);
        } else if (clientType.equals("Adult")) {
            client = new Adult(clientName,clientID,income);
        } else {
            throw new IllegalArgumentException("Invalid client type.");
        }

        if (clientType.equals("Student")){
            for (Bank bank : this.banks){
                if (bank.getClass().getSimpleName().equals("BranchBank")){
                    if (bank.getName().equals(bankName)){
                        bank.addClient(client);
                        return String.format("%s successfully added to %s.", clientType, bankName);
                    }
                }
            }
        } else if (clientType.equals("Adult")){
            for (Bank bank : this.banks){
                if (bank.getClass().getSimpleName().equals("CentralBank")){
                    if (bank.getName().equals(bankName)){
                        bank.addClient(client);
                        return String.format("%s successfully added to %s.", clientType, bankName);
                    }
                }
            }
        }
        return "Unsuitable bank.";
    }

    @Override
    public String finalCalculation(String bankName) {
        double sum = 0;
        for (Bank bank : this.banks){
            if (bank.getName().equals(bankName)){
                for (Client client : bank.getClients()){
                    sum += client.getIncome();
                }
                for (Loan loan : bank.getLoans()){
                    sum += loan.getAmount();
                }
            }
        }
        return String.format("The funds of bank %s is %.2f.", bankName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Bank bank : banks){
            sb.append(bank.getStatistics());
        }
        return sb.toString();
    }
}
