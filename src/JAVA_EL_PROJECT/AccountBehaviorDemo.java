package JAVA_EL_PROJECT;

import java.util.Scanner;

class BehaviorAccount {
    public void printAccountType() {
        System.out.println("General bank account");
    }
}

class BehaviorSavingAccount extends BehaviorAccount {
    @Override
    public void printAccountType() {
        System.out.println("Savings bank account");
    }
}

class BehaviorCurrentAccount extends BehaviorAccount {
    @Override
    public void printAccountType() {
        System.out.println("Current bank account");
    }
}

public class AccountBehaviorDemo {
    public static void run(Scanner scanner) {
        System.out.println("---- Choosing Account Behavior ----");

        System.out.print("Enter account number (to show balance if exists): ");
        String accNo = scanner.nextLine();

        if (AccountStore.hasAccount(accNo)) {
            System.out.println("Known balance: " + AccountStore.getBalance(accNo));
        } else {
            System.out.println("No stored balance for this account yet.");
        }

        System.out.print("Choose type (1 = savings, 2 = current): ");
        String choice = scanner.nextLine();

        BehaviorAccount acc;
        if ("1".equals(choice)) {
            acc = new BehaviorSavingAccount();
        } else {
            acc = new BehaviorCurrentAccount();
        }

        acc.printAccountType();
    }
}
