
import java.io.Serializable;

public class Account implements Serializable {
    private String accountNumber;
    private String holderName;
    private double balance;

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdraw amount must be positive");
        if (amount > balance) throw new IllegalArgumentException("Insufficient Balance! Current: " + balance);
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Account No: " + accountNumber + " | Name: " + holderName + " | Balance: Rs. " + balance;
    }
}