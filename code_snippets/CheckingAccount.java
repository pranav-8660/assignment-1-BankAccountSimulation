class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(String accountHolderName, double balance, double overdraftLimit) {
        super(accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance + overdraftLimit) >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn. Remaining balance: " + balance);
        } else {
            System.out.println("Withdrawal failed! Exceeds overdraft limit.");
        }
    }
}
