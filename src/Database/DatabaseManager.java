package Database;

import ModulComponent.subComponent.Supplier.Sale.Invoice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.time.LocalDateTime; // To store the invoice date/time

public class DatabaseManager {

    private static final String URL = "jdbc:postgresql://localhost:5432/Inventory"; // Replace with your DB details
    private static final String USER = "postgres"; // Replace with your DB username
    private static final String PASSWORD = "dan@12345"; // Replace with your DB password

    // Method to get a database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Method to save an invoice to the database
    public void saveInvoice(Invoice invoice) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmtInvoice = null;
        PreparedStatement pstmtItem = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false); // Start transaction

            // 1. Insert into the invoices table
            String invoiceSql = "INSERT INTO invoices (invoice_date, total_amount) VALUES (?, ?) RETURNING invoice_id";
            pstmtInvoice = conn.prepareStatement(invoiceSql, Statement.RETURN_GENERATED_KEYS);
            pstmtInvoice.setObject(1, LocalDateTime.now()); // Use current timestamp for invoice_date
            pstmtInvoice.setDouble(2, invoice.getGrandTotal());
            pstmtInvoice.executeUpdate();

            rs = pstmtInvoice.getGeneratedKeys();
            int invoiceId = -1;
            if (rs.next()) {
                invoiceId = rs.getInt(1);
            } else {
                throw new SQLException("Failed to get generated invoice ID.");
            }

            // 2. Insert into the invoice_items table for each item
            String itemSql = "INSERT INTO public.invoice_items(\n"
                    + "	 invoice_id, product_name, price, quantity, subtotal, product_id)\n"
                    + "	VALUES ( ?, ?, ?, ?, ?, ?);";
            pstmtItem = conn.prepareStatement(itemSql);

            for (Invoice.InvoiceItem item : invoice.getItems()) {
                pstmtItem.setInt(1, invoiceId);
                pstmtItem.setString(2, item.name);
                pstmtItem.setDouble(3, item.price);
                pstmtItem.setInt(4, item.quantity);
                pstmtItem.setDouble(5, item.price * item.quantity);
                pstmtItem.setInt(6, item.product_id);
                pstmtItem.addBatch(); // Add to batch for efficient insertion
            }
            pstmtItem.executeBatch(); // Execute all batched inserts

            conn.commit(); // Commit transaction
            System.out.println("Invoice saved to database successfully with ID: " + invoiceId);

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback(); // Rollback transaction on error
                    System.err.println("Transaction rolled back.");
                } catch (SQLException ex) {
                    System.err.println("Error rolling back transaction: " + ex.getMessage());
                }
            }
            throw e; // Re-throw the exception for the caller to handle
        } finally {
            // Close resources in reverse order of creation
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.err.println("Error closing ResultSet: " + e.getMessage());
                }
            }
            if (pstmtInvoice != null) {
                try {
                    pstmtInvoice.close();
                } catch (SQLException e) {
                    System.err.println("Error closing PreparedStatement (invoice): " + e.getMessage());
                }
            }
            if (pstmtItem != null) {
                try {
                    pstmtItem.close();
                } catch (SQLException e) {
                    System.err.println("Error closing PreparedStatement (item): " + e.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }

}
