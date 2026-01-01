package JAVA_EL_PROJECT;

import java.util.Scanner;

class BankAccountDetails {

    private final String accountNumber;
    private final String ownerName;
    private double balance;

    public BankAccountDetails(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}

public class BankAccountDetailsDemo {
    public static void run(Scanner scanner) {
        System.out.println("---- Bank Account Details ----");
        System.out.print("Enter account number: ");
        String accNo = scanner.nextLine();

        double bal;
        String name;

        if (AccountStore.hasAccount(accNo)) {
            bal = AccountStore.getBalance(accNo);
            System.out.println("Existing account found with balance: " + bal);
            System.out.print("Enter owner name (for display only): ");
            name = scanner.nextLine();
        } else {
            System.out.print("Enter owner name: ");
            name = scanner.nextLine();
            System.out.print("Enter initial balance: ");
            bal = Double.parseDouble(scanner.nextLine());
        }

        BankAccountDetails acc = new BankAccountDetails(accNo, name, bal);

        System.out.println("Owner: " + acc.getOwnerName());
        System.out.println("Current balance: " + acc.getBalance());

        System.out.print("Enter amount to deposit: ");
        double dep = Double.parseDouble(scanner.nextLine());
        acc.deposit(dep);
        System.out.println("After deposit: " + acc.getBalance());

        System.out.print("Enter amount to withdraw: ");
        double wd = Double.parseDouble(scanner.nextLine());
        acc.withdraw(wd);
        System.out.println("After withdraw: " + acc.getBalance());

        // store updated balance globally
        AccountStore.setBalance(acc.getAccountNumber(), acc.getBalance());
    }
}
