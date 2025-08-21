import java.util.Random;

abstract class Account {
    private String accountNumber;
    private String accountHolderName;
    protected double balance;

    private String createRandomAccountNumber(){  // default acc no length = 7 nos

        Random rand = new Random();

        long accno = rand.nextLong(1000000,9999999);

        return String.valueOf(accno);

    }

    public Account(String accountHolderName, double balance) {
        this.accountNumber = createRandomAccountNumber();
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public abstract void withdraw(double amount); // Abstract (different behavior in subclasses)

    public double getBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
