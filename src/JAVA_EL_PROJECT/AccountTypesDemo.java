package JAVA_EL_PROJECT;

import java.util.Scanner;

class BasicAccount {
    protected String accountNumber;
    protected double balance;

    public BasicAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void showBalance() {
        System.out.println("Account " + accountNumber + " balance: " + balance);
    }
}

class SavingTypeAccount extends BasicAccount {
    public SavingTypeAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public void addInterest(double rate) {
        double interest = balance * rate;
        balance += interest;
        System.out.println("Interest added: " + interest);
    }
}

class CurrentTypeAccount extends BasicAccount {
    public CurrentTypeAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public void deductFee(double fee) {
        balance -= fee;
        System.out.println("Fee deducted: " + fee);
    }
}

class PremiumSavingTypeAccount extends SavingTypeAccount {
    public PremiumSavingTypeAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public void addBonus(double bonus) {
        balance += bonus;
        System.out.println("Bonus added: " + bonus);
    }
}

public class AccountTypesDemo {
    public static void run(Scanner scanner) {
        System.out.println("---- Different Account Types ----");

        // Example 1
        System.out.println("\nExample 1: Saving type");
        System.out.print("Enter account number: ");
        String sAccNo = scanner.nextLine();

        double sBal;
        if (AccountStore.hasAccount(sAccNo)) {
            sBal = AccountStore.getBalance(sAccNo);
            System.out.println("Existing balance: " + sBal);
        } else {
            System.out.print("Enter balance: ");
            sBal = Double.parseDouble(scanner.nextLine());
        }

        System.out.print("Enter interest rate (e.g. 0.04): ");
        double rate = Double.parseDouble(scanner.nextLine());

        SavingTypeAccount sa = new SavingTypeAccount(sAccNo, sBal);
        sa.showBalance();
        sa.addInterest(rate);
        sa.showBalance();
        AccountStore.setBalance(sAccNo, sa.balance);

        // Example 2
        System.out.println("\nExample 2: Current type");
        System.out.print("Enter account number: ");
        String cAccNo = scanner.nextLine();

        double cBal;
        if (AccountStore.hasAccount(cAccNo)) {
            cBal = AccountStore.getBalance(cAccNo);
            System.out.println("Existing balance: " + cBal);
        } else {
            System.out.print("Enter balance: ");
            cBal = Double.parseDouble(scanner.nextLine());
        }

        System.out.print("Enter fee: ");
        double fee = Double.parseDouble(scanner.nextLine());

        CurrentTypeAccount ca = new CurrentTypeAccount(cAccNo, cBal);
        ca.showBalance();
        ca.deductFee(fee);
        ca.showBalance();
        AccountStore.setBalance(cAccNo, ca.balance);

        // Example 3
        System.out.println("\nExample 3: Premium saving type");
        System.out.print("Enter account number: ");
        String pAccNo = scanner.nextLine();

        double pBal;
        if (AccountStore.hasAccount(pAccNo)) {
            pBal = AccountStore.getBalance(pAccNo);
            System.out.println("Existing balance: " + pBal);
        } else {
            System.out.print("Enter balance: ");
            pBal = Double.parseDouble(scanner.nextLine());
        }

        System.out.print("Enter interest rate (e.g. 0.05): ");
        double pRate = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter bonus: ");
        double bonus = Double.parseDouble(scanner.nextLine());

        PremiumSavingTypeAccount psa = new PremiumSavingTypeAccount(pAccNo, pBal);
        psa.showBalance();
        psa.addInterest(pRate);
        psa.addBonus(bonus);
        psa.showBalance();
        AccountStore.setBalance(pAccNo, psa.balance);
    }
}
