import java.time.LocalDate;
import java.util.ArrayList;

public class BankAccount {
    private static int totalBankAccounts;
    private CustomerProfile owner;
    private String accountID;
    private double balance;
    private ArrayList<String> history = new ArrayList<String>();
    private LocalDate dateCreated;

    public BankAccount(CustomerProfile profile){
        BankAccount.totalBankAccounts += 1;
        this.owner = profile;
        this.dateCreated = LocalDate.now();
        this.accountID = setAccountID(profile.getUserName(), BankAccount.totalBankAccounts);
        this.history.add("Account created at " + this.dateCreated);
    }
    // getters
    public String getAccountID(){
        return this.accountID;
    }
    public double getBalance(){
        return this.balance;
    }
    public LocalDate getDateCreated(){
        return this.dateCreated;
    }
    public String getOwnerUsername(){
        return this.owner.getUserName();
    }
    // setters
    private String setAccountID(String un, int n){
        return un + "-account-" + n;
    }
    // methods
}
