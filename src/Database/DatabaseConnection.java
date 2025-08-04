
package Database;


import ModulComponent.subComponent.Supplier.Sale.productCard;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
        
        public static void main(String[] args) {
           
            // Database connection details
            String url = "jdbc:postgresql://localhost:5432/Inventory"; // Replace with your DB details
            String user = "postgres"; // Replace with your DB username
            String password = "dan@12345"; // Replace with your DB password
  
       
    


            try {
                // Load the PostgreSQL JDBC driver (not required for JDBC 4.0+)
                Class.forName("org.postgresql.Driver");

                try ( // Establish connection
                        Connection connection = DriverManager.getConnection(url, user, password)) {
                  
                    System.out.println("Connected to PostgreSQL database!");
                    // Create a statement
                    Statement statement = connection.createStatement();
                    // Execute a query
                    //            String query = "SELECT * FROM products"; // Replace with your table
                    //            ResultSet resultSet = statement.executeQuery(query);
                    // Process the results
                    //            while (resultSet.next()) {
                    //                System.out.println("product_name: " + resultSet.getString("product_name")); // Replace with your column
                    //            }
                    // Close resources
                    //            resultSet.close();
                    //            statement.close();
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    
        
}
