import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        boolean running = true;

        while (running) {
            System.out.println("\n====== COMMAND LINE BANKING SYSTEM ======");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Account Details");
            System.out.println("6. View All Accounts");
            System.out.println("7. Delete Account");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Enter Account Number: ");
                        String accNo = sc.nextLine();
                        System.out.print("Enter Holder Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Initial Deposit (min 500): ");
                        double init = Double.parseDouble(sc.nextLine());
                        bank.createAccount(accNo, name, init);
                        break;
                    case 2:
                        System.out.print("Enter Account Number: ");
                        accNo = sc.nextLine();
                        System.out.print("Enter Amount to Deposit: ");
                        double dep = Double.parseDouble(sc.nextLine());
                        bank.deposit(accNo, dep);
                        break;
                    case 3:
                        System.out.print("Enter Account Number: ");
                        accNo = sc.nextLine();
                        System.out.print("Enter Amount to Withdraw: ");
                        double wit = Double.parseDouble(sc.nextLine());
                        bank.withdraw(accNo, wit);
                        break;
                    case 4:
                        System.out.print("Enter From Account: ");
                        String from = sc.nextLine();
                        System.out.print("Enter To Account: ");
                        String to = sc.nextLine();
                        System.out.print("Enter Amount: ");
                        double amt = Double.parseDouble(sc.nextLine());
                        bank.transfer(from, to, amt);
                        break;
                    case 5:
                        System.out.print("Enter Account Number: ");
                        accNo = sc.nextLine();
                        System.out.println(bank.getAccount(accNo));
                        break;
                    case 6:
                        bank.showAllAccounts();
                        break;
                    case 7:
                        System.out.print("Enter Account Number to Delete: ");
                        accNo = sc.nextLine();
                        bank.deleteAccount(accNo);
                        break;
                    case 8:
                        running = false;
                        System.out.println("Thank you for using Banking System!");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
