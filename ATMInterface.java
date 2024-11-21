import java.util.Scanner;

class BankAccount {
    private double balance;

    // Constructor to initialize the account with an initial balance
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        }
    }

    // Method to withdraw amount from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Method to deposit amount into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Method to check the account balance
    public double getBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    // Constructor to initialize ATM with a bank account and scanner for user input
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the ATM menu options
    public void displayMenu() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Please choose an option (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to handle withdrawal
    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive amount.");
        } else if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful! Your new balance is: " + account.getBalance());
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }

    // Method to handle deposit
    private void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Deposit successful! Your new balance is: " + account.getBalance());
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive amount.");
        }
    }

    // Method to check the account balance
    private void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        // Creating a new bank account with an initial balance of 1000
        BankAccount userAccount = new BankAccount(1000.0);

        // Creating the ATM instance and passing the bank account to it
        ATM atm = new ATM(userAccount);

        // Display the ATM menu and allow the user to interact with it
        atm.displayMenu();
    }
}
