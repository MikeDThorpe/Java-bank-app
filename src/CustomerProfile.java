import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerProfile {
    private static int totalCustomerProfiles;
    private String customerID;
    private String userName;
    private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

    public CustomerProfile(String userName){
        customerProfileCreated();
        this.userName = userName;
        this.customerID = setCustomerID();
    }
    // getters
    public String getCustomerID(){
        return this.customerID;
    }
    public String getUserName(){
        return this.userName;
    }
    public ArrayList<BankAccount> getAccounts(){return this.accounts;}
    public BankAccount getBankAccount(int index){
        return this.accounts.get(index-1);
    }
    // setters
    private String setCustomerID(){
        LocalDate d = LocalDate.now();
        char f = this.userName.charAt(0);
        StringBuilder username = new StringBuilder();
        username.append(d);
        username.append("-");
        username.append(f);
        username.append("-");
        username.append(CustomerProfile.totalCustomerProfiles);
        return username.toString();
    }
    // methods
    public void customerProfileCreated(){
        CustomerProfile.totalCustomerProfiles += 1;
    }
    public void linkAccount(BankAccount account){
        this.accounts.add(account);
    }
}