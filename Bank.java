import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts = new HashMap<>();

    public void createAccount(String accNo, String name, double initialDeposit) {
        if (accounts.containsKey(accNo)) {
            throw new IllegalArgumentException("Account number already exists!");
        }
        if (initialDeposit < 500) {
            throw new IllegalArgumentException("Minimum initial deposit is Rs. 500");
        }
        Account acc = new Account(accNo, name, initialDeposit);
        accounts.put(accNo, acc);
        System.out.println("Account Created Successfully: " + acc);
    }

    public Account getAccount(String accNo) {
        Account acc = accounts.get(accNo);
        if (acc == null) throw new IllegalArgumentException("Account not found!");
        return acc;
    }

    public void deposit(String accNo, double amount) {
        getAccount(accNo).deposit(amount);
        System.out.println("Deposited Rs. " + amount + ". New Balance: " + getAccount(accNo).getBalance());
    }

    public void withdraw(String accNo, double amount) {
        getAccount(accNo).withdraw(amount);
        System.out.println("Withdrawn Rs. " + amount + ". New Balance: " + getAccount(accNo).getBalance());
    }

    public void transfer(String fromAcc, String toAcc, double amount) {
        Account sender = getAccount(fromAcc);
        Account receiver = getAccount(toAcc);
        if (fromAcc.equals(toAcc)) throw new IllegalArgumentException("Cannot transfer to same account");
        sender.withdraw(amount);
        receiver.deposit(amount);
        System.out.println("Transferred Rs. " + amount + " from " + fromAcc + " to " + toAcc);
    }

    public void showAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }
        System.out.println("\n--- All Accounts ---");
        for (Account acc : accounts.values()) {
            System.out.println(acc);
        }
    }

    public void deleteAccount(String accNo) {
        if (accounts.remove(accNo) == null) throw new IllegalArgumentException("Account not found!");
        System.out.println("Account " + accNo + " deleted.");
    }
}