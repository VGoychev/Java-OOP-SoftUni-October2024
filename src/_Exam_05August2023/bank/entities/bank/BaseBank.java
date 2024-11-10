package _Exam_05August2023.bank.entities.bank;

import _Exam_05August2023.bank.entities.client.Client;
import _Exam_05August2023.bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public abstract class BaseBank implements Bank{

    private String name;
    private int capacity;
    private Collection<Loan> loans;
    private Collection<Client> clients;

    public BaseBank(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.loans = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Bank name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public Collection<Client> getClients() {
        return Collections.unmodifiableCollection(clients);
    }

    @Override
    public Collection<Loan> getLoans() {
        return Collections.unmodifiableCollection(loans);
    }

    @Override
    public void addClient(Client client) {
        if (capacity > this.clients.size()) {
            this.clients.add(client);
        } else {
            throw new IllegalStateException("Not enough capacity for this client.");
        }
    }

    @Override
    public void removeClient(Client client) {
        this.clients.remove(client);
    }

    @Override
    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    @Override
    public int sumOfInterestRates() {
       int sum = 0;
       for (Loan loan : this.loans){
           sum += loan.getInterestRate();
       }
        return sum;
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(this.name).append(", Type: ").append(this.getClass().getSimpleName()).append(System.lineSeparator());
        if (this.clients.isEmpty()) {
            sb.append("Clients: none").append(System.lineSeparator());
        } else {
            sb.append("Clients: ").append(this.clients.stream().map(Client::getName).collect(Collectors.joining(", "))).append(System.lineSeparator());
        }
        sb.append("Loans: ").append(this.loans.size()).append(", ").append("Sum of interest rates: ").append(sumOfInterestRates()).append(System.lineSeparator());

        return sb.toString();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
