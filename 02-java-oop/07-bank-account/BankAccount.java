import java.util.ArrayList;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private static ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();

    public BankAccount(){
        this.checkingBalance = 0;
        this.savingsBalance = 0;
    }

    public BankAccount getCheckingBalance(){
        System.out.println("Checking Balance: " + this.checkingBalance);
        return this;
    }

    public BankAccount getSavingsBalance(){
        System.out.println("Saving Balance: " + this.savingsBalance);
        return this;
    }

    public BankAccount deposit(String accountType, double amount){
        if (accountType.toLowerCase() == "checking"){
            this.checkingBalance += amount;
            System.out.println("Deposited: " + amount);
            getCheckingBalance();
        } else if(accountType.toLowerCase() == "savings"){
            this.savingsBalance += amount;
            System.out.println("Deposited: " + amount);
            getSavingsBalance();
        }
        return this;
    }

    public BankAccount withdraw(String accountType, double amount){
        if(accountType.toUpperCase() == "checking"){
            if(amount > this.checkingBalance) {
                System.out.println("Insufficient funds!!");
                amount = 0;
            } 
            
            else {
                this.checkingBalance -= amount;
            }
            System.out.println("Amount Withdrawn: " + amount);
            getCheckingBalance();
        } else if (accountType.toUpperCase() == "savings") {
            if(amount > this.savingsBalance) {
                System.out.println("Insufficient funds!!");
                amount = 0;
            } 
            
            else {
                this.savingsBalance -= amount;
            }
            System.out.println("Amount Withdrawn: " + amount);
            getSavingsBalance();
        }
        return this;
    }

    public BankAccount getAccountBalance(){
        getCheckingBalance();
        getSavingsBalance();
        System.out.println("Total Balance: " + this.checkingBalance + this.savingsBalance);
        return this;
    }

    public static int getAccounts() {
        int count = bankAccounts.size();
        System.out.println("Number of accounts: " + count);
        return count;
    }

    public static double getAccountValues() {
        double total = 0;
        for (BankAccount bankAccount : bankAccounts) {
            total += bankAccount.checkingBalance;
            total += bankAccount.savingsBalance;
        }
        System.out.println("Total value of accounts: " + total);
        return total;
    }


}