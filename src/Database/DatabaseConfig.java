/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 *
 * @author Da Phadenphorakden
 */
public class DatabaseConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/Inventory"; // Replace with your DB details
    private static final String USER = "postgres"; // Replace with your DB username
    private static final String PASSWORD = "dan@12345"; // Replace with your DB password
    
    // Method to get a database connectionj
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    

//public class TestJavaPostgresql {
//    public static void main(String[] args) throws ClassNotFoundException {
//        Connection conn1 = null,conn2=null,conn3=null;
//        try {
//            //With JDBC 3.0 (JDK 5.0 and before) we need to register the driver as follows:
//            //However, since JDBC 4.0 (JDK 6.0 and later), the registration is not required.
//            Class.forName("org.postgresql.Driver");
//            //way1 : to create connection with timeout 30seconds
//            String url = "jdbc:postgresql://localhost:5432/Inventory"; // Replace with your DB details
//            String user = "postgres"; // Replace with your DB username
//            String password = "dan@12345"; // Replace with your DB password
//            conn1 = DriverManager.getConnection(url, user, password);
//            System.out.println("Conn1 : Connected to the PostgreSQL server successfully.");
//            conn1.close();
//            
////            way2 : to create connection
//            conn2 = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres?user=postgres&password=dan@12345");
//            System.out.println("Conn2 : Connected to the PostgreSQL server successfully.");
//            conn2.close();
//            
//            //way3 : to create connection
//            String dbURL = "jdbc:postgresql://localhost:5433/postgres";
//            Properties parameters = new Properties();
//            parameters.put("user", "postgres");
//            parameters.put("password", "dan@12345");
//	    parameters.put("connectTimeout", "30");
//            conn3 = DriverManager.getConnection(dbURL, parameters);
//            System.out.println("Conn3 : Connected to the PostgreSQL server successfully.");
//            conn3.close();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            }
//        }
//    }
}
