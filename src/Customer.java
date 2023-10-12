/**
 * @Author : Sharath V
 */


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Customer {
    int Account_Number;
    static String AccHolder_Name;
    static String Account_Type;
    static String ID_Proof;
    double Balance = 0;
    double Balance_Savings = 0;
    //double Balance_FD = 0;
    /**
     * In this hashMap Key   : Account_Number of type int
     *                 Value : List of Transcations of type String
     */
    static Map<Integer, List<String>> AccountHistory = new HashMap<>();



    public Customer(String accHolder_Name, String account_Type, String ID_Proof) {
        Account_Number = this.hashCode();
        AccHolder_Name = accHolder_Name;
        Account_Type = account_Type;
        this.ID_Proof = ID_Proof;
        AccountHistory.put(Account_Number, new ArrayList<>());


    }

    /**
     * This method is used to withdraw the amount from the savings account
     * @param Amount
     */
    public void WithdrawSavings_Account(double Amount) {
        Date date = new Date();
        if (Balance_Savings <= 0 || Balance_Savings < Amount) {
            System.out.println("Insufficient Funds");
        } else {
            Balance_Savings -= Balance_Savings;
            Balance = Balance - Amount;
            System.out.println(Amount + " rs Withdraw Successful");
            /**
             * Here this hashmap gets the Lists for Account Number and adds a new entry to the List with date
             */
            //AccountHistory.get(Account_Number).add("Withdraw: " + Amount);
            AccountHistory.get(Account_Number).add(date.toString() + " | Withdraw: " + Amount);



        }
    }

    /**
     * This method is to deposit the amount in to savings account
     * @param Amount
     */
    public void DepositSavings_Account(double Amount) {
        Date date = new Date();
        Balance = Balance + Amount;
        Balance_Savings += Amount;
        System.out.println(Amount + " rs Deposited Successful");
        //AccountHistory.get(Account_Number).add("Deposit: " + Amount);
        AccountHistory.get(Account_Number).add(date.toString() + " | Deposit: " + Amount);
    }

    /**
     * This method is used to transfer funds between two savings accounts.
     * Currently, it's used to transfer funds between two savings accounts later it can be developed further can be transfered to FD accoounts.
     * @param Dest_Account
     * @param Amount
     */
    public void TransferSavings_funds(Customer Dest_Account, double Amount) {
        Date date = new Date();
        if (this.Balance_Savings < Amount) {
            System.out.println("Insuffiecient funds to transfer");
        } else {
            this.Balance -= Amount;
            this.Balance_Savings -= Amount;
            Dest_Account.Balance += Amount;
            Dest_Account.Balance_Savings += Amount;
            System.out.println("Transcation successful");

            //AccountHistory.get(Account_Number).add("Transfer to Account " + Dest_Account.Account_Number + ": " + Amount);

            //AccountHistory.get(Dest_Account.Account_Number).add("Received from Account " + this.Account_Number + ": " + Amount);

            AccountHistory.get(Account_Number).add(date.toString() + " | Transfer to Account " + Dest_Account.Account_Number + ": " + Amount);
            AccountHistory.get(Dest_Account.Account_Number).add(date.toString() + " | Received from Account " + this.Account_Number + ": " + Amount);
        }
    }

    /**
     * This Method displays all the savings account transcantions (Deposited,Transfered,Withdrawn and Recived)
     * @param accountNumber
     */

    static void DisplaySavings_AccountHistory(int accountNumber) {
        if (AccountHistory.containsKey(accountNumber)) {
            System.out.println("Transaction History for Account " + accountNumber + ":");
            List<String> history = AccountHistory.get(accountNumber);
            for (String transaction : history) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("Account with Account Number " + accountNumber + " not found.");
        }
    }

    /**
     * This dis[lays the account statement for Savings Account
     */
    public void get_SavingsAccountStatement() {
        DisplaySavings_AccountHistory(this.Account_Number);
    }

    public void test_HashMap(){
        System.out.println(AccountHistory.get(Account_Number));
    }


}


