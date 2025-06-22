
package ModulComponent;

import Logic.InvoiceDB;
import Logic.SumProduct;
import Logic.product;
import Logic.pruchse;
import Logic.subtotal;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class HomeModul extends javax.swing.JPanel {
    private static final String url = "jdbc:postgresql://localhost:5432/Inventory";
    private static final String user = "postgres";
    private static final String password = "dan@12345";

    public static Connection getConnection() throws SQLException, java.sql.SQLException {
        return (Connection) DriverManager.getConnection(url, user, password);
    }


    public HomeModul() {
        initComponents();
        showInvoiceDBInTabel();
        showProductInTabel();
        showpruchseInTabel();
        showsubtotalInTabel();
        
        JTableHeader header = jTable_dashbard.getTableHeader();

        // Create the desired font for the header
        Font headerFont = new Font("Century Gothic", Font.BOLD, 18); // Example: Bold, Size 14
        header.setFont(headerFont);
    }
     // function show product in table
    public ArrayList<InvoiceDB> getInvoiceList()
    {
        ArrayList<InvoiceDB> invoice_list  = new ArrayList<>();
        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT * FROM invoice_items ORDER BY invoice_id DESC;";
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
    //Show Inoive and item in table
    public void showInvoiceDBInTabel()
    {
        ArrayList<InvoiceDB> InvoiceDBInTabel = getInvoiceList();
        DefaultTableModel model = (DefaultTableModel) jTable_dashbard.getModel();
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
    // Get Tatal Proudct
    public ArrayList<SumProduct> getProductsList()
    {
        ArrayList<SumProduct> sumpro = new ArrayList<>();
        try(java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT SUM(quantity) as total_quantity FROM products;";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {                
               Integer total_quantity =  rs.getInt("total_quantity");             
               sumpro.add( new SumProduct  (total_quantity));
            }
            
        } catch (Exception e) {
            Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
        }
        return sumpro;
    }
     public void showProductInTabel()
    {
        ArrayList<SumProduct> sumpro = getProductsList();
       
        jLabel_sumproduct.setText(String.valueOf(sumpro.get(0).getTotal_quantity()));
       
    }
     // get purchse
    public ArrayList<pruchse> getpruchse()
    {
        ArrayList<pruchse> purPro = new ArrayList<>();
        try(java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT SUM(quantity) AS qtyOfsale FROM invoice_items  ;";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {                
               Integer total_quantity =  rs.getInt("qtyOfsale");             
               purPro.add( new pruchse  (total_quantity));
            }
            
        } catch (Exception e) {
            Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
        }
        return purPro;
    }
     public void showpruchseInTabel()
    {
        ArrayList<pruchse> purPro = getpruchse();
       
        jLabel_pruchse.setText(String.valueOf(purPro.get(0).getCount_sale()));
       
    }
      // get subtotal
    public ArrayList<subtotal> getsubtotal()
    {
        ArrayList<subtotal> subtotal = new ArrayList<>();
        try(java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT SUM(subtotal) as subtotal FROM invoice_items;";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {                
               Double subtotal1 =  rs.getDouble("subtotal");             
               subtotal.add( new subtotal  (subtotal1));
            }
            
        } catch (Exception e) {
            Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
        }
        return subtotal;
    }
     public void showsubtotalInTabel()
    {
        ArrayList<subtotal> subtotal = getsubtotal();
       
        jLabel_subtotal.setText("$"+String.valueOf(subtotal.get(0).getSub_sale()));
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_sumproduct = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel_pruchse = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel_subtotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_dashbard = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(244, 67, 54));

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Products");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Product availaible in store ");

        jLabel_sumproduct.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_sumproduct.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel_sumproduct.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_sumproduct.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_sumproduct.setText("n");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_sumproduct)
                .addGap(127, 127, 127))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel_sumproduct)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(30, 30, 30))
        );

        jPanel6.setBackground(new java.awt.Color(76, 175, 80));
        jPanel6.setPreferredSize(new java.awt.Dimension(335, 226));
        jPanel6.setRequestFocusEnabled(false);

        jPanel7.setBackground(new java.awt.Color(102, 255, 102));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Porchase");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Purchase name the last 30 days ");

        jLabel_pruchse.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_pruchse.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel_pruchse.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_pruchse.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_pruchse.setText("1");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel_pruchse, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_pruchse)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(30, 30, 30))
        );

        jPanel8.setBackground(new java.awt.Color(176, 39, 56));
        jPanel8.setPreferredSize(new java.awt.Dimension(335, 226));

        jPanel9.setBackground(new java.awt.Color(255, 51, 51));

        jLabel7.setBackground(new java.awt.Color(255, 0, 51));
        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Revenue");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Revenue  for the last 30day ");

        jLabel_subtotal.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_subtotal.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel_subtotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_subtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_subtotal.setText("Number");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel8))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_subtotal)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(30, 30, 30))
        );

        jTable_dashbard.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jTable_dashbard.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_dashbard.setRowHeight(25);
        jScrollPane1.setViewportView(jTable_dashbard);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_pruchse;
    private javax.swing.JLabel jLabel_subtotal;
    private javax.swing.JLabel jLabel_sumproduct;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable_dashbard;
    // End of variables declaration//GEN-END:variables
}
