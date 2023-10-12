import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    CustomerFD account1 = new CustomerFD("Sharath","FD","PAN",10000);
    Customer acc1 = new Customer("Sharath","Savings","PAN");
    Customer acc2 = new Customer("Minnu","Savings","PAN");
    acc1.DepositSavings_Account(50000);
    acc1.TransferSavings_funds(acc2,10000);
    acc1.WithdrawSavings_Account(1500);
    acc2.DepositSavings_Account(1000);
    acc2.TransferSavings_funds(acc1,2500);
    //acc1.get_SavingsAccountStatement();
    acc2.get_SavingsAccountStatement();


    acc1.test_HashMap();



    }
}