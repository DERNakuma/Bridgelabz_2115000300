import java.util.*;
class BankingSystem {
    private Map<String, Integer> accounts = new HashMap<>();
    private TreeMap<Integer, String> sortedByBalance = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    void createAccount(String accountNumber, int balance) {
        accounts.put(accountNumber, balance);
        sortedByBalance.put(balance, accountNumber);
    }

    void deposit(String accountNumber, int amount) {
        if (accounts.containsKey(accountNumber)) {
            int newBalance = accounts.get(accountNumber) + amount;
            sortedByBalance.remove(accounts.get(accountNumber));
            accounts.put(accountNumber, newBalance);
            sortedByBalance.put(newBalance, accountNumber);
        }
    }

    void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        }
    }

    void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for: " + accountNumber);
        }
    }

    void displaySortedAccounts() {
        sortedByBalance.forEach((balance, account) -> System.out.println(account + ": " + balance));
    }
}

public class BankingApp {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.createAccount("A001", 5000);
        bank.createAccount("A002", 3000);
        bank.createAccount("A003", 7000);

        System.out.println("Accounts sorted by balance:");
        bank.displaySortedAccounts();

        bank.requestWithdrawal("A002");
        bank.requestWithdrawal("A001");

        System.out.println("\nProcessing withdrawals:");
        bank.processWithdrawals();
    }
}
