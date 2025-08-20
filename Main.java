import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Banking System Menu =====");
            System.out.println("1. Open Savings Account");
            System.out.println("2. Open Checking Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Apply Interest (Savings only)");
            System.out.println("6. Display Account Info");
            System.out.println("7. Display All Accounts");
            System.out.println("8. Close Account");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    sc.nextLine(); 
                    System.out.print("Enter Holder Name: ");
                    String name = sc.nextLine();   
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    System.out.print("Enter Interest Rate: ");
                    double rate = sc.nextDouble();
                    bank.openAccount(new SavingsAccount(name, bal, rate));
                    break;
                }
                case 2: {
                    sc.nextLine(); 
                    System.out.print("Enter Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    System.out.print("Enter Overdraft Limit: ");
                    double limit = sc.nextDouble();
                    bank.openAccount(new CheckingAccount(name, bal, limit));
                    break;
                }

                case 3: {
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.next();
                    Account acc = bank.findAccount(accNo);
                    if (acc != null) {
                        System.out.print("Enter Deposit Amount: ");
                        double amt = sc.nextDouble();
                        acc.deposit(amt);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                }
                case 4: {
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.next();
                    Account acc = bank.findAccount(accNo);
                    if (acc != null) {
                        System.out.print("Enter Withdrawal Amount: ");
                        double amt = sc.nextDouble();
                        acc.withdraw(amt);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                }
                case 5: {
                    System.out.print("Enter Savings Account Number: ");
                    String accNo = sc.next();
                    Account acc = bank.findAccount(accNo);
                    if (acc instanceof SavingsAccount) {
                        ((SavingsAccount) acc).applyInterest();
                    } else {
                        System.out.println("Account not found or not a savings account!");
                    }
                    break;
                }
                case 6: {
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.next();
                    Account acc = bank.findAccount(accNo);
                    if (acc != null) {
                        acc.displayAccountInfo();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                }
                case 7: {
                    bank.displayAllAccounts();
                    break;
                }
                case 8: {
                    System.out.print("Enter Account Number to Close: ");
                    String accNo = sc.next();
                    bank.closeAccount(accNo);
                    break;
                }
                case 9: {
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
