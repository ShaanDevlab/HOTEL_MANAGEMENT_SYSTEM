package JAVA_EL_PROJECT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Banking System ===");
            System.out.println("1. Bank account details");
            System.out.println("2. Different account types");
            System.out.println("3. Choosing account behavior");
            System.out.println("4. Yearly return on balance");
            System.out.println("5. Show all accounts in store");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a number (0–5): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> BankAccountDetailsDemo.run(scanner);
                case 2 -> AccountTypesDemo.run(scanner);
                case 3 -> AccountBehaviorDemo.run(scanner);
                case 4 -> YearlyReturnDemo.run(scanner);
                case 5 -> AccountStore.printAllAccounts();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice, please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
