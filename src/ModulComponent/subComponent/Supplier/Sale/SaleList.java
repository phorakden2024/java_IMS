
package ModulComponent.subComponent.Supplier.Sale;

import Logic.InvoiceDB;
import ModulComponent.SupplierModul;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.JTableHeader;


public class SaleList extends JPanel 
{
    private static final long serialVersionUID = 1L;
    private static final String url = "jdbc:postgresql://localhost:5432/Inventory";
    private static final String user = "postgres";
    private static final String password = "dan@12345";
    private JTextArea invoiceTextArea; 

    public static Connection getConnection() throws SQLException, java.sql.SQLException {
        return (Connection) DriverManager.getConnection(url, user, password);
    }


    public SaleList() { 
        initComponents();
       
        JTableHeader header = jTable_saleList.getTableHeader();

        // Create the desired font for the header
        Font headerFont = new Font("Century Gothic", Font.BOLD, 18); // Example: Bold, Size 14
        header.setFont(headerFont);
    }
   
    // function show product in table
    public ArrayList<InvoiceDB> getInvoiceList()
    {
        ArrayList<InvoiceDB> invoice_list  = new ArrayList<>();
        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT * FROM invoice_items ORDER BY invoice_id ASC;";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {               
                    Integer item_id = rs.getInt("item_id");
                    Integer invoice_id = rs.getInt("invoice_id");
                    String product_name = rs.getString("product_name");
                    Double price = rs.getDouble("price");
                    Integer quantity = rs.getInt("quantity");
                    Double subtotal = rs.getDouble("subtotal");
                    invoice_list.add(new InvoiceDB(item_id,invoice_id,product_name,price,quantity,subtotal));
            }
        } catch (Exception e) {
            Logger.getLogger(SupplierModul.class.getName()).log(Level.SEVERE, null, e);
        }
        return invoice_list;
    }
    public void showInvoiceDBInTabel()
    {
        ArrayList<InvoiceDB> InvoiceDBInTabel = getInvoiceList();
        DefaultTableModel model = (DefaultTableModel) jTable_saleList.getModel();
        model.setRowCount(0);
        Object[] row = new Object[6];
        
        for( int i = 0;i < InvoiceDBInTabel.size();i++)
        {
            row[0] = "PID0"+InvoiceDBInTabel.get(i).getItem_id();
            row[1] = "IN0"+InvoiceDBInTabel.get(i).getInvoice_id();
            row[2] = InvoiceDBInTabel.get(i).getProduct_name();
            row[3] = InvoiceDBInTabel.get(i).getQuantity();
            row[4] = "$"+InvoiceDBInTabel.get(i).getPrice();
            row[5] = "$"+ InvoiceDBInTabel.get(i).getSubtotal();
            
            model.addRow(row);
            
        }
    }
    public void printSaleList()
    {
         
         String textToPrint = jTable_saleList.getColumnName(0);
        if (textToPrint.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No invoice to print.", "Print Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Create a PrinterJob
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE; // End of print
                }

                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                // Use a monospaced font for better alignment
                g2d.setFont(new Font("Monospaced", Font.PLAIN, 10));
                // Get the text lines
                String[] lines = textToPrint.split("\n");
                int y = 0; // Starting Y position
                int lineHeight = 12; // Approximate line height

                for (String line : lines) {
                    g2d.drawString(line, 0, y);
                    y += lineHeight;
                }

                return Printable.PAGE_EXISTS;
            }
        });
         // Show print dialog
        if (printerJob.printDialog()) {
            try {
                printerJob.print();
                JOptionPane.showMessageDialog(this, "Invoice printed successfully.", "Print Successful", JOptionPane.INFORMATION_MESSAGE);
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(this, "Error printing invoice: " + ex.getMessage(), "Print Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Print job cancelled.", "Print Cancelled", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
            
        
    
   
  
  
    
  
    

    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_saleList = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jTable_saleList.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jTable_saleList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Invoice ID", "Product Name", "Quantity", "Price", "Total Amount"
            }
        ));
        jTable_saleList.setRowHeight(25);
        jScrollPane1.setViewportView(jTable_saleList);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_saleList;
    // End of variables declaration//GEN-END:variables

    
}
