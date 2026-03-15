package atm_project;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Account {

    DecimalFormat rupeeFormat = new DecimalFormat("##,##0.00 'Rupees'");
    DecimalFormat dollarFormat = new DecimalFormat("##,##0.00 'Dollars'");

    Scanner input = new Scanner(System.in);

    private int customerNumber;
    private int pinNumber;

    double currentBalance;
    double savingBalance;

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void getCurrentBalance() {
        System.out.println("Current Account Balance: " + rupeeFormat.format(currentBalance));
    }

    public void getSavingBalance() {
        System.out.println("Saving Account Balance: " + dollarFormat.format(savingBalance));
    }
    
  //---------------------------------------------------------------    

    void withdrawCurrent()
    {
        try
        {
            System.out.print("Enter amount to withdraw: ");
            double amount = input.nextDouble();

            if((currentBalance - amount) >= 0)
            {
                currentBalance -= amount;
                saveTransaction("CURRENT","WITHDRAW",amount);

                Connection con = DatabaseConnection.connect();

                String query = "UPDATE accounts SET current_balance=? WHERE customer_number=?";

                PreparedStatement ps = con.prepareStatement(query);

                ps.setDouble(1, currentBalance);
                ps.setInt(2, getCustomerNumber());

                ps.executeUpdate();

                System.out.println("Transaction Successful");
                getCurrentBalance();
            }
            else
            {
                System.out.println("Insufficient Balance");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
//---------------------------------------------------------------

    void withdrawSaving()
    {
        try
        {
            System.out.print("Enter amount to withdraw: ");
            double amount = input.nextDouble();

            if((savingBalance - amount) >= 0)
            {
                savingBalance -= amount;
                saveTransaction("SAVING","WITHDRAW",amount);

                Connection con = DatabaseConnection.connect();

                String query = "UPDATE accounts SET saving_balance=? WHERE customer_number=?";

                PreparedStatement ps = con.prepareStatement(query);

                ps.setDouble(1, savingBalance);
                ps.setInt(2, getCustomerNumber());

                ps.executeUpdate();

                System.out.println("Transaction Successful");
                getSavingBalance();
            }
            else
            {
                System.out.println("Insufficient Balance");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

  //---------------------------------------------------------------
    
    void depositCurrent()
    {
        try
        {
            System.out.print("Enter amount to deposit: ");
            double amount = input.nextDouble();

            currentBalance += amount;
            saveTransaction("CURRENT","DEPOSIT",amount);

            Connection con = DatabaseConnection.connect();

            String query = "UPDATE accounts SET current_balance=? WHERE customer_number=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, currentBalance);
            ps.setInt(2, getCustomerNumber());

            ps.executeUpdate();

            System.out.println("Deposit Successful");
            getCurrentBalance();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
 //---------------------------------------------------------------
    
    void depositSaving()
    {
        try
        {
            System.out.print("Enter amount to deposit: ");
            double amount = input.nextDouble();

            savingBalance += amount;
            saveTransaction("SAVING","DEPOSIT",amount);

            Connection con = DatabaseConnection.connect();

            String query = "UPDATE accounts SET saving_balance=? WHERE customer_number=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, savingBalance);
            ps.setInt(2, getCustomerNumber());

            ps.executeUpdate();

            System.out.println("Deposit Successful");
            getSavingBalance();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
  //---------------------------------------------------------------
    
    void saveTransaction(String accountType, String type, double amount)
    {
        try
        {
            Connection con = DatabaseConnection.connect();

            String query =
            "INSERT INTO transactions(customer_number,account_type,transaction_type,amount) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, getCustomerNumber());
            ps.setString(2, accountType);
            ps.setString(3, type);
            ps.setDouble(4, amount);

            ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
