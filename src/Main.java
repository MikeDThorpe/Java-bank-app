// banking command line application
    // create account x
    // deposit money
    // withdraw money
    // view balance
    // view account history (deposits/withdraws)
    // view account details (customerID - name) x
    // show menu of options x
    // exit application x

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	// write your code here
        showStartMenu();
    }
    private static void showStartMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome...");
        System.out.println("Type 'create' to sign up for an account or type 'quit' to close this app.");
        String userInput = scanner.nextLine();

        while(!userInput.equals("create") && !userInput.equals("quit")){
            System.out.println("Invalid. Enter 'create' to continue or 'quit' to close the app.");
            userInput = scanner.nextLine();
        }
        if(userInput.equals("create")){
            createAccount();
        } else {
            quitApp();
        }
    }
    private static void createAccount(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Create Username: ");
        String username = scanner.nextLine();
        CustomerProfile customerProfile = new CustomerProfile(username);
        System.out.println();
        System.out.println("*************************");
        System.out.println("Your account details:");
        System.out.println("Username: " + customerProfile.getUserName());
        System.out.println("CustomerID: " + customerProfile.getCustomerID());
        System.out.println("Accounts: 0");
        System.out.println("*************************");
        System.out.println();
        showAccountMenu(customerProfile);
    }
    private static void showAccountMenu(CustomerProfile customerProfile){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Account Menu");
        System.out.println("A: Create a new bank account");
        System.out.println("B: View your bank accounts");
        System.out.println("C: Change username");
        System.out.println("D: quit");
        System.out.println();
        System.out.print("What would you like to do? ");
        String userInput = scanner.nextLine();
        while(!userInput.equals("a") && !userInput.equals("b") && !userInput.equals("c") && !userInput.equals("d")){
            System.out.println("Invalid. Please select a,b,c,d to continue.");
            userInput = scanner.nextLine();
        }
        if(userInput.equals("d")) {
            quitApp();
        } else handleMenuInput(userInput, customerProfile);
    }
    private static void handleMenuInput(String input, CustomerProfile customerProfile) {
        switch (input) {
            case ("a") -> createNewBankAccount(customerProfile);
            case ("b") -> viewBankAccounts(customerProfile);
        }
    }
    private static void createNewBankAccount(CustomerProfile customerProfile){
        BankAccount newAccount = new BankAccount(customerProfile);
        customerProfile.linkAccount(newAccount);
        System.out.println();
        System.out.println("Account created...");
        System.out.println();
        System.out.println("Account ID: " + newAccount.getAccountID());
        System.out.println("Account Owner: " + newAccount.getOwnerUsername());
        System.out.println("Balance £" + newAccount.getBalance());
        System.out.println("Date created: " + newAccount.getDateCreated());
        System.out.println("*************************");
        System.out.println();
        showAccountMenu(customerProfile);
    }
    private static void viewBankAccounts(CustomerProfile customerProfile) {
        Scanner scanner = new Scanner(System.in);
        // list bank accounts linked with the customerProfile
        System.out.println("Showing accounts for: " + customerProfile.getUserName());
        System.out.println("");
        for(BankAccount account : customerProfile.getAccounts()){
            System.out.println("*************************");
            System.out.println();
            System.out.println("Account ID: " + account.getAccountID());
            System.out.println("Account balance: £" + account.getBalance());
            System.out.println("Date created:" + account.getDateCreated());
            System.out.println();
            System.out.println("*************************");
        }
        String userInput = "";
        while(!userInput.equals("y") && !userInput.equals("n")){
            System.out.println("Would you like to manage an account? (y/n)");
            userInput = scanner.nextLine();
        }
        if(userInput.equals("y")){

            // take user input - a number
            System.out.println("Select an account to manage using the end number of the account ID (e.g 1).");
            String id = scanner.nextLine();

            // create array of possible values to check against
            ArrayList<String> vals = new ArrayList<String>();
            for(BankAccount account : customerProfile.getAccounts()){
                String s = String.valueOf(account.getAccountID().charAt(account.getAccountID().length() -1));
                vals.add(s);
            }
            while(!vals.contains(id)){
                System.out.println("No match found. Please enter another id or press 'n' to return to menu");
                id = scanner.nextLine();
                if(id.equals("n")){
                    showAccountMenu(customerProfile);
                }
            }
            for(BankAccount account : customerProfile.getAccounts()){
                if(account.getAccountID().charAt(account.getAccountID().length() -1) == id.charAt(0)){
                    manageAccount(customerProfile, account);
                }
            }
            // if user enters "n" - return to the main account menu
        } else {
            showAccountMenu(customerProfile);
        }
    }
    private static void manageAccount(CustomerProfile customerProfile, BankAccount account) {
        System.out.println(account.getAccountID());
    }
    private static void quitApp(){
        System.out.println("Goodbye, your account will be deleted.");
        System.exit(0);
    }
}