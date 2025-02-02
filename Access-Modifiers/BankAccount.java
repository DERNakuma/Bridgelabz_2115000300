public class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber + ", Account Holder: " + accountHolder);
    }

    // Main method
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("123456", "Bhupender", 100000.0);
        savings.displayDetails();
        System.out.println("Balance: " + savings.getBalance());
    }
}