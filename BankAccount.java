class BankAccount {
    static String bankName = "SBI";
    static int totalAccounts = 0;
    final int accountNumber;
    String accountHolderName;

    BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    static void getTotalAccounts() {
        System.out.println(totalAccounts);
    }

    void display() {
        if (this instanceof BankAccount) {
            System.out.println(accountHolderName + " " + accountNumber);
        }
    }

    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("Bhupender", 101);
        BankAccount b2 = new BankAccount("Ram", 102);
        b1.display();
        b2.display();
        getTotalAccounts();
    }
}
