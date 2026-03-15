package atm_project;

import java.util.Scanner;
import java.util.InputMismatchException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OptionMenu extends Account {

    Scanner scanner = new Scanner(System.in);

    // ================= ADMIN LOGIN =================

    void adminLogin()
    {
        System.out.println("\n===== ADMIN LOGIN =====");

        System.out.print("Enter Admin ID: ");
        String id = scanner.next();

        System.out.print("Enter Password: ");
        String pass = scanner.next();

        if(id.equals("admin") && pass.equals("admin123"))
        {
            adminMenu();
        }
        else
        {
            System.out.println("Invalid Admin Credentials");
        }
    }

    // ================= ADMIN PANEL =================

    void adminMenu()
    {
        try
        {
            System.out.println("\n===== ADMIN PANEL =====");
            System.out.println("1. View All Accounts");
            System.out.println("2. View All Transactions");
            System.out.println("3. Exit");

            System.out.print("Choice: ");
            int ch = scanner.nextInt();

            switch(ch)
            {
                case 1:
                    viewAllAccounts();
                    break;

                case 2:
                    viewAllTransactions();
                    break;

                case 3:
                    System.out.println("Exiting Admin Panel");
                    break;

                default:
                    System.out.println("Invalid Choice");
                    adminMenu();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    // ================= VIEW ALL ACCOUNTS =================

    void viewAllAccounts()
    {
        try
        {
            Connection con = DatabaseConnection.connect();

            String query = "SELECT * FROM accounts";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n---- ALL ACCOUNTS ----");

            while(rs.next())
            {
                System.out.println(
                        rs.getInt("customer_number") + " | " +
                        rs.getDouble("current_balance") + " | " +
                        rs.getDouble("saving_balance")
                );
            }

            adminMenu();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    // ================= VIEW ALL TRANSACTIONS =================

    void viewAllTransactions()
    {
        try
        {
            Connection con = DatabaseConnection.connect();

            String query = "SELECT * FROM transactions";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n---- TRANSACTION HISTORY ----");

            while(rs.next())
            {
                System.out.println(
                        rs.getInt("customer_number") + " | " +
                        rs.getString("account_type") + " | " +
                        rs.getString("transaction_type") + " | " +
                        rs.getDouble("amount") + " | " +
                        rs.getTimestamp("transaction_time")
                );
            }

            adminMenu();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    // ================= CUSTOMER LOGIN =================

    public void login() {

        try {

            System.out.println("===== Welcome to ATM =====");

            System.out.print("Enter Customer Number: ");
            setCustomerNumber(scanner.nextInt());

            System.out.print("Enter PIN: ");
            setPinNumber(scanner.nextInt());

            Connection con = DatabaseConnection.connect();

            String query = "SELECT * FROM accounts WHERE customer_number=? AND pin=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, getCustomerNumber());
            ps.setInt(2, getPinNumber());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                currentBalance = rs.getDouble("current_balance");
                savingBalance = rs.getDouble("saving_balance");

                showAccountType();

            } else {

                System.out.println("Invalid Customer Number or PIN");
                login();

            }

        } catch (InputMismatchException e) {

            System.out.println("Numbers only allowed");
            scanner.next();
            login();

        } catch (Exception e) {

            System.out.println("Login Error");
            e.printStackTrace();

        }
    }

    // ================= ACCOUNT TYPE =================

    public void showAccountType() {

        System.out.println("\nSelect Account Type:");
        System.out.println("1. Current Account");
        System.out.println("2. Saving Account");
        System.out.println("3. Exit");

        System.out.print("Choice: ");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                currentAccountMenu();
                break;

            case 2:
                savingAccountMenu();
                break;

            case 3:
                System.out.println("Thank you for visiting.");
                break;

            default:
                System.out.println("Invalid Choice.");
                showAccountType();
        }
    }

    // ================= CURRENT ACCOUNT =================

    public void currentAccountMenu() {

        System.out.println("\nCURRENT ACCOUNT");
        System.out.println("1. Balance Enquiry");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Back");

        System.out.print("Choice: ");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                getCurrentBalance();
                break;

            case 2:
                withdrawCurrent();
                break;

            case 3:
                depositCurrent();
                break;

            case 4:
                showAccountType();
                return;

            default:
                System.out.println("Invalid Choice.");
        }

        currentAccountMenu();
    }

    // ================= SAVING ACCOUNT =================

    public void savingAccountMenu() {

        System.out.println("\nSAVING ACCOUNT");
        System.out.println("1. Balance Enquiry");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Back");

        System.out.print("Choice: ");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                getSavingBalance();
                break;

            case 2:
                withdrawSaving();
                break;

            case 3:
                depositSaving();
                break;

            case 4:
                showAccountType();
                return;

            default:
                System.out.println("Invalid Choice.");
        }

        savingAccountMenu();
    }
}