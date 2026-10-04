package BankDemo;


class BankAccount {

    private final String accountNumber;
    private final String accountHolderName;
    protected double balance;

    BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    void deposit(double amount) {

        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    double getBalance() {
        return balance;
    }

    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}


class SavingsAccount extends BankAccount {

    private double interestRate;

    SavingsAccount(String accountNumber, String accountHolderName,
                   double balance, double interestRate) {

        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    void calculateInterest() {
        double interest = getBalance() * interestRate / 100;
        System.out.println("Interest: " + interest);
    }
}


class PremiumSavingsAccount extends SavingsAccount {

    private double cashback;

    PremiumSavingsAccount(String accountNumber, String accountHolderName,
                          double balance, double interestRate, double cashback) {

        super(accountNumber, accountHolderName, balance, interestRate);
        this.cashback = cashback;
    }

    void displayPremiumBenefits() {
        System.out.println("Cashback:" + cashback);
    }
}


public class Bankdetails {

    public static void main(String[] args) {

        PremiumSavingsAccount account =
                new PremiumSavingsAccount(
                        "ACC15",
                        "Ram",
                        10000,
                        10,
                        1000
                );

        account.displayAccountDetails();

        account.deposit(20000);

        account.calculateInterest();

        account.displayPremiumBenefits();

        System.out.println("Final Balance:" + account.getBalance());
    }
}
