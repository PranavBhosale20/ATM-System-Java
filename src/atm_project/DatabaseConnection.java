package atm_project;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection connect() {

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/atm_system",
                    "root",
                    "root"
            );

            return con;

        } catch (Exception e) {

            System.out.println("Database connection failed");
            return null;

        }
    }
}