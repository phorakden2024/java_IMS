
package ModulComponent.subComponent.Supplier.Sale;

import Datebase.DatabaseManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.print.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class InvoicePanel extends JPanel {
    
 
    private static final long serialVersionUID = 1L;
    private final Invoice invoice;
    private JTextArea invoiceTextArea; // Declare JTextArea as a class member
    private final JButton btnGenerateInvoice;
    private JButton btnPrintInvoice;
    private DefaultTableModel saleListTableModel;
    private JTable saleListTable;
    
    private DatabaseManager dbManager = new DatabaseManager(); // Create an instance


    public InvoicePanel() throws SQLException {
        this.invoice = Invoice.getInstance();
        setLayout(new BorderLayout());

        // Initialize JTextArea
        invoiceTextArea = new JTextArea(25, 25); // 20 rows, 50 columns - adjust as needed
        invoiceTextArea.setEditable(false); // Make it read-only
        invoiceTextArea.setFont(new Font("Century Gothic", Font.PLAIN, 12));

        // Add JScrollPane, and add invoiceTextArea to it
        JScrollPane scrollPane = new JScrollPane(invoiceTextArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(); // Panel to hold buttons
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Align buttons to the right
        btnGenerateInvoice = new JButton("Generate Invoice");
        btnGenerateInvoice.addActionListener(e -> {
            if (invoice.isEmpty()) {
                invoiceTextArea.setText("No items in the invoice.  Please add products.");
            } else {
                String generatedInvoice = invoice.generateInvoice();
                invoiceTextArea.setText(generatedInvoice);
                try {
                    invoice.saveToFile("invoice.txt");
                     JOptionPane.showMessageDialog(this,
                        "Generated Invoice Success",
                        "Invoice Saved", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        dbManager.saveInvoice(invoice);
                        System.out.println("Invoice saved to database successfully!");
//                        JOptionPane.showMessageDialog(this,
//                                "Invoice saved to database successfully!",
//                                "Database Save Success", JOptionPane.INFORMATION_MESSAGE);
                        // Clear the invoice after successful save and generation
//                        invoice.clearItems();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this,
                                "Error saving invoice to database: " + ex.getMessage(),
                                "Database Save Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace(); // Print stack trace for debugging
                    }
    
                     
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this,
                        "Error saving invoice: " + ex.getMessage(),
                        "Save Error", JOptionPane.ERROR_MESSAGE);
                }
                
                
                updateSaleListTable(); // Call method to update the table
                
                
            }
        });
        buttonPanel.add(btnGenerateInvoice);
        btnPrintInvoice = new JButton("Print Invoice"); // Initialize the print button
        btnPrintInvoice.addActionListener(e -> printInvoice()); // Call printInvoice() on click
        buttonPanel.add(btnPrintInvoice); // Add print button to the button panel

        add(buttonPanel, BorderLayout.SOUTH); // Add the button panel to the main panel
      
        // Initialize the sale list table
        saleListTableModel = new DefaultTableModel(new Object[]{"Product", "Price", "Quantity", "Total"}, 0);
        saleListTable = new JTable(saleListTableModel);
        saleListTable.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        JScrollPane saleListScrollPane = new JScrollPane(saleListTable);
        saleListScrollPane.setPreferredSize(new Dimension(500, 200));
        add(saleListScrollPane, BorderLayout.EAST);
        
       
    }
    //add data info tale
    private void updateSaleListTable() {
        // Clear the existing data in the table
        saleListTableModel.setRowCount(0);

        // Get the invoice items from the Invoice instance
        List<Invoice.InvoiceItem> items = invoice.getItems();
        

        // Add each item to the table
        double grandTotal = 0.0;
        if (items != null) { // Check if items is not null
            for (Invoice.InvoiceItem item : items) {
                double total = item.price * item.quantity;
                grandTotal += total;
                saleListTableModel.addRow(new Object[]{item.name, "$"+item.price , item.quantity,"$"+total});
            }
        }
        saleListTableModel.addRow(new Object[]{"", "", "Grand Total:", "$"+grandTotal});

    } 
    //Print
    private void printInvoice() {
        String textToPrint = invoiceTextArea.getText();
        if (textToPrint.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No invoice to print.", "Print Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a PrinterJob
        PrinterJob printerJob = PrinterJob.getPrinterJob();

        // Set the Printable object
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents




    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
