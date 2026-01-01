package JAVA_EL_PROJECT;

import java.util.Scanner;

abstract class ReturnAccount {
    protected String accountNumber;
    protected double balance;

    public ReturnAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void calculateYearlyAmount(double rate);

    public void showInfo() {
        System.out.println("Account: " + accountNumber + ", balance: " + balance);
    }
}

class SavingReturnAccount extends ReturnAccount {
    public SavingReturnAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void calculateYearlyAmount(double rate) {
        double amount = balance * rate;
        System.out.println("Yearly return at given rate: " + amount);
    }
}

public class YearlyReturnDemo {
    public static void run(Scanner scanner) {
        System.out.println("---- Yearly Return on Balance ----");

        System.out.print("Enter account number: ");
        String accNo = scanner.nextLine();

        double bal;
        if (AccountStore.hasAccount(accNo)) {
            bal = AccountStore.getBalance(accNo);
            System.out.println("Existing balance: " + bal);
        } else {
            System.out.print("Enter balance: ");
            bal = Double.parseDouble(scanner.nextLine());
        }

        System.out.print("Enter yearly rate (e.g. 0.05): ");
        double rate = Double.parseDouble(scanner.nextLine());

        ReturnAccount acc = new SavingReturnAccount(accNo, bal);
        acc.showInfo();
        acc.calculateYearlyAmount(rate);
    }
}
