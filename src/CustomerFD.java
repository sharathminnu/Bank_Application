/**
 * @Author : Sharath V
 */



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerFD extends Customer{
    double BalanceFD = 0;
    //double Amount_FD = 0;
    static Map<Integer, List<String>> AccountHistory_FD = new HashMap<>();

    public CustomerFD(String accHolder_Name, String account_Type, String ID_Proof, double balanceFD) {
        super(accHolder_Name, account_Type, ID_Proof);
        BalanceFD = balanceFD;
        AccountHistory_FD.put(Account_Number,new ArrayList<>());
    }

    /**
     * This Method deposits funds in FD accounts
     * @param Amount
     */
    public void FD_Deposit(double Amount) {

            this.BalanceFD += Amount;
            this.Balance += Amount;
            AccountHistory_FD.get(Account_Number).add("Deposited"+ Amount);
        }

    /**
     * This Method Withdraw money from FD accounts
     * @param Amount
     */

    public void FD_Withdraw(double Amount) {

            this.BalanceFD -= Amount;
            this.Balance -= Amount;
        AccountHistory_FD.get(Account_Number).add("Withdrawn"+ Amount);
        }

    /**
     * This FD account Balance
     */
    public void DisplayFD_Balance() {

            System.out.println(this.BalanceFD);
        }


    /**
     * This Methos displays FD account History
     * @param accountNumber
     */
    public static void DisplayFD_AccountHistory(int accountNumber) {
        if (AccountHistory.containsKey(accountNumber)) {
            System.out.println("Transaction History for Account " + accountNumber + ":");
            List<String> history = AccountHistory_FD.get(accountNumber);
            for (String transaction : history) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("Account with Account Number " + accountNumber + " not found.");
        }
    }

}
