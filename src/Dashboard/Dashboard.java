
package Dashboard;
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import ModulComponent.CurrentStockModul;
import ModulComponent.HomeModul;
import ModulComponent.ProductModul;
import ModulComponent.SaleModul;
import ModulComponent.SupplierModul;
import ModulComponent.subComponent.Supplier.Sale.MenuProduct;
import ModulComponent.subComponent.Supplier.Sale.productCard;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Dashboard extends javax.swing.JFrame {

    HomeModul hm = new HomeModul();
    ProductModul propm = new ProductModul();
    CurrentStockModul csm  = new CurrentStockModul();
    SaleModul sale;
    SupplierModul suppm = new SupplierModul();
    MenuProduct menpro = new MenuProduct();
    productCard pcard = new productCard();
    public Dashboard() throws SQLException {
        this.sale = new SaleModul();
        initComponents();
        mainContent.add("DashBoard",hm);
        mainContent.add("Produsts",propm);
        mainContent.add("CurrentStock",csm);
        mainContent.add("Supplier",suppm);
        mainContent.add("Sales", sale);
    
        
        hm.setVisible(false);
        propm.setVisible(false);
        csm.setVisible(false);
        sale.setVisible(false);
        suppm.setVisible(false);
        titel_header.setText("Dashboard");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        titel_header = new javax.swing.JLabel();
        navbar = new javax.swing.JPanel();
        btn_home = new javax.swing.JButton();
        btn_product = new javax.swing.JButton();
        btn_Suppliers = new javax.swing.JButton();
        btn_currentStock = new javax.swing.JButton();
        btn_sales = new javax.swing.JButton();
        mainContent = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        header.setBackground(new java.awt.Color(255, 255, 204));
        header.setName(""); // NOI18N

        titel_header.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        titel_header.setText("Dashboard");
        titel_header.setToolTipText("");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titel_header, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(750, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(titel_header, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        navbar.setBackground(new java.awt.Color(204, 204, 204));
        navbar.setPreferredSize(new java.awt.Dimension(200, 707));

        btn_home.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_home.setText("Home");
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        btn_product.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_product.setText("Products");
        btn_product.setToolTipText("");
        btn_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_productActionPerformed(evt);
            }
        });

        btn_Suppliers.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_Suppliers.setText("Suppliers");
        btn_Suppliers.setToolTipText("");
        btn_Suppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuppliersActionPerformed(evt);
            }
        });

        btn_currentStock.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_currentStock.setText("Current Stock");
        btn_currentStock.setToolTipText("");
        btn_currentStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_currentStockActionPerformed(evt);
            }
        });

        btn_sales.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_sales.setText("Sales");
        btn_sales.setToolTipText("");
        btn_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navbarLayout = new javax.swing.GroupLayout(navbar);
        navbar.setLayout(navbarLayout);
        navbarLayout.setHorizontalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_currentStock, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Suppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_product, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        navbarLayout.setVerticalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_currentStock, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_product, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Suppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(432, Short.MAX_VALUE))
        );

        getContentPane().add(navbar, java.awt.BorderLayout.LINE_START);

        mainContent.setLayout(new java.awt.CardLayout());
        getContentPane().add(mainContent, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        hm.showInvoiceDBInTabel();
        hm.showProductInTabel();
        hm.showpruchseInTabel();
        hm.showsubtotalInTabel();
        hm.setVisible(true);
        propm.setVisible(false);
        csm.setVisible(false);
        sale.setVisible(false);
        suppm.setVisible(false);
        titel_header.setText("Dashboard");
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_productActionPerformed
        hm.setVisible(false);
        csm.setVisible(false);
        sale.setVisible(false);
        suppm.setVisible(false);
        propm.setVisible(true);
        titel_header.setText("Product");
    }//GEN-LAST:event_btn_productActionPerformed

    private void btn_SuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuppliersActionPerformed
        hm.setVisible(false);
        csm.setVisible(false);
        sale.setVisible(false);
        suppm.setVisible(true);
        propm.setVisible(false);
        titel_header.setText("Suppliers");
    }//GEN-LAST:event_btn_SuppliersActionPerformed

    private void btn_currentStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_currentStockActionPerformed
        csm.showProductInTabel();
        hm.setVisible(false);
        csm.setVisible(true);
        sale.setVisible(false);
        suppm.setVisible(false);
        propm.setVisible(false);
        titel_header.setText("CurrentStock");
    }//GEN-LAST:event_btn_currentStockActionPerformed

    private void btn_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salesActionPerformed

        hm.setVisible(false);
        csm.setVisible(false);
        sale.setVisible(true);
        suppm.setVisible(false);
        propm.setVisible(false);
        titel_header.setText("Sales");
 
        
    }//GEN-LAST:event_btn_salesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Dashboard().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Suppliers;
    private javax.swing.JButton btn_currentStock;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_product;
    private javax.swing.JButton btn_sales;
    private javax.swing.JPanel header;
    private javax.swing.JLayeredPane mainContent;
    private javax.swing.JPanel navbar;
    private javax.swing.JLabel titel_header;
    // End of variables declaration//GEN-END:variables

   
}
