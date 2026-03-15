package atm_project;

import java.util.Scanner;

public class ATMSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OptionMenu menu = new OptionMenu();

        while(true)
        {
            System.out.println("\n===== ATM SYSTEM =====");
            System.out.println("1 Customer Login");
            System.out.println("2 Admin Login");
            System.out.println("3 Exit");

            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    menu.login();
                    break;

                case 2:
                    menu.adminLogin();
                    break;

                case 3:
                    System.out.println("Thank you for using ATM.");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}