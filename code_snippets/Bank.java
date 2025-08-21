import java.util.ArrayList;

class Bank {
    private ArrayList<Account> accounts = new ArrayList<>();

    public void openAccount(Account account) {
        accounts.add(account);
        System.out.println("Account opened successfully! Account Number: " + account.getAccountNumber());
    }

    public void closeAccount(String accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            accounts.remove(account);
            System.out.println("Account " + accountNumber + " closed successfully!");
        } else {
            System.out.println("Account not found!");
        }
    }

    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }
        for (Account acc : accounts) {
            acc.displayAccountInfo();
            System.out.println("------------------");
        }
    }
}
