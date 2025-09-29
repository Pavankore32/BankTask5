import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {
    private String owner;
    private String accountNumber;
    private double balance;
    private List<String> transactions = new ArrayList<>();

    public Account(String owner, String accountNumber, double initialBalance) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        addTransaction("Account opened with balance " + initialBalance);
    }

    public synchronized void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        addTransaction("Deposited " + amount + ", balance: " + balance);
    }

    public synchronized boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            addTransaction("Failed withdraw " + amount + " (insufficient).");
            return false;
        }
        balance -= amount;
        addTransaction("Withdrew " + amount + ", balance: " + balance);
        return true;
    }

    private void addTransaction(String desc) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        transactions.add(time + " - " + desc);
    }

    public double getBalance() {
        return balance;
    }

    public void printStatement() {
        System.out.println("\nAccount statement for " + owner + " (" + accountNumber + "):");
        for (String t : transactions) {
            System.out.println(t);
        }
    }
}
