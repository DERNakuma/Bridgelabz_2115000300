class Bank {
    String name;

    Bank(String name) {
        this.name = name;
    }

    void openAccount(Customer customer) {
        System.out.println("Account opened for " + customer.name + " at " + this.name);
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }

    void viewBalance() {
        System.out.println("Viewing balance for " + this.name);
    }
}

public class BankAndAcc{
    public static void main(String[] args) {
        Bank bank = new Bank("SBI");
        Customer customer = new Customer("Bhupender Singh");
        bank.openAccount(customer);
        customer.viewBalance();
    }
}