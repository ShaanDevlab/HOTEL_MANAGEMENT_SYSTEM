package JAVA_EL_PROJECT;

import java.util.HashMap;
import java.util.Map;

public class AccountStore {

    private static final Map<String, Double> accounts = new HashMap<>();

    public static boolean hasAccount(String accountNumber) {
        return accounts.containsKey(accountNumber);
    }

    public static double getBalance(String accountNumber) {
        return accounts.getOrDefault(accountNumber, 0.0);
    }

    public static void setBalance(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }

    public static void printAllAccounts() {
        System.out.println("---- All Accounts in Store ----");
        if (accounts.isEmpty()) {
            System.out.println("No accounts yet.");
        } else {
            for (Map.Entry<String, Double> e : accounts.entrySet()) {
                System.out.println("Account " + e.getKey() + " -> balance: " + e.getValue());
            }
        }
    }
}
