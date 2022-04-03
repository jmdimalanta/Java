public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount();

        b1.deposit("savings", 10000).deposit("checking",50000);
        b2.deposit("checking", 90000).deposit("savings", 100000);
        System.out.println("\n");
        b1.withdraw("savings", 500).withdraw("checking", 10000);
        b2.withdraw("checking", 200).withdraw("savings", 5000);
        System.out.println("\n");
        b1.getAccountBalance();
        b2.getAccountBalance();
        System.out.println("\n");
        BankAccount.getAccounts();
        BankAccount.getAccountValues();
    }
}
