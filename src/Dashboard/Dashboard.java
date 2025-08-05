package Dashboard;

import ModulComponent.CurrentStockModul;
import ModulComponent.HomeModul;
import ModulComponent.Navbar_Home;
import ModulComponent.Navbar_product;
import ModulComponent.UserRole;
import Product_Component.ProductModul;
import ModulComponent.SaleModul;
import ModulComponent.SupplierModul;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dashboard extends javax.swing.JFrame {

    HomeModul hm = new HomeModul();
    ProductModul propm = new ProductModul();
    CurrentStockModul csm = new CurrentStockModul();
    SaleModul sale;
    SupplierModul suppm = new SupplierModul();
    Navbar_product nvp = new Navbar_product();
    UserRole userRole;
    Navbar_Home  navHome = new Navbar_Home();

    public Dashboard() throws SQLException, Exception {
        this.sale = new SaleModul();
        this.sale = new SaleModul();
        this.userRole = new UserRole();
        initComponents();
        
        mainContent.add("DashBoard", navHome);
        mainContent.add("Produsts", propm);
        mainContent.add("Blank", csm);
        mainContent.add("Supplier", suppm);
        mainContent.add("Sales", sale);
        mainContent.add("Product", nvp);
        mainContent.add("User & Role", userRole);
        

        hm.setVisible(false);
        propm.setVisible(false);
        csm.setVisible(false);
        sale.setVisible(false);
        suppm.setVisible(false);
        nvp.setVisible(false);
        userRole.setVisible(false);
        navHome.setVisible(false);
        titel_header.setText("Dashboard");
        
//        btn_currentStock.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        titel_header = new javax.swing.JLabel();
        titel_header1 = new javax.swing.JLabel();
        navbar = new javax.swing.JPanel();
        btn_home = new javax.swing.JButton();
        btn_product = new javax.swing.JButton();
        btn_Suppliers = new javax.swing.JButton();
        btn_currentStock = new javax.swing.JButton();
        btn_sales = new javax.swing.JButton();
        btn_userRole = new javax.swing.JButton();
        mainContent = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory System Management");
        setExtendedState(MAXIMIZED_BOTH);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        header.setBackground(new java.awt.Color(102, 255, 153));
        header.setName(""); // NOI18N

        titel_header.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        titel_header.setText("Dashboard");
        titel_header.setToolTipText("");

        titel_header1.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        titel_header1.setText("Inventory System Management");
        titel_header1.setToolTipText("");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titel_header, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titel_header1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titel_header, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titel_header1))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        navbar.setBackground(new java.awt.Color(153, 153, 153));
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
        btn_currentStock.setText("Blank");
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

        btn_userRole.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_userRole.setText("User & Role");
        btn_userRole.setToolTipText("");
        btn_userRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_userRoleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navbarLayout = new javax.swing.GroupLayout(navbar);
        navbar.setLayout(navbarLayout);
        navbarLayout.setHorizontalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbarLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_currentStock, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_product, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Suppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_userRole, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        navbarLayout.setVerticalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_currentStock, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_product, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_Suppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_userRole, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(578, Short.MAX_VALUE))
        );

        getContentPane().add(navbar, java.awt.BorderLayout.LINE_START);

        mainContent.setMaximumSize(new java.awt.Dimension(1024, 768));
        mainContent.setMinimumSize(new java.awt.Dimension(1024, 768));
        mainContent.setName(""); // NOI18N
        mainContent.setPreferredSize(new java.awt.Dimension(1500, 1024));
        mainContent.setRequestFocusEnabled(false);
        mainContent.setVerifyInputWhenFocusTarget(false);
        mainContent.setLayout(new java.awt.CardLayout());
        getContentPane().add(mainContent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
//        hm.showInvoiceDBInTabel();
//        hm.showProductInTabel();
//        hm.showpruchseInTabel();
//        hm.showsubtotalInTabel();
//        hm.setVisible(true);
        propm.setVisible(false);
        csm.setVisible(false);
        sale.setVisible(false);
        suppm.setVisible(false);
        nvp.setVisible(false);
        userRole.setVisible(false);
        navHome.setVisible(true);
        titel_header.setText("Dashboard");
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_productActionPerformed
        hm.setVisible(false);
        csm.setVisible(false);
        sale.setVisible(false);
        suppm.setVisible(false);
        nvp.setVisible(true);
        userRole.setVisible(false);
        navHome.setVisible(false);
        titel_header.setText("Product");
    }//GEN-LAST:event_btn_productActionPerformed

    private void btn_SuppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuppliersActionPerformed
        hm.setVisible(false);
        csm.setVisible(false);
        sale.setVisible(false);
        nvp.setVisible(false);
        suppm.setVisible(true);
        userRole.setVisible(false);
        navHome.setVisible(false);
//        propm.setVisible(false);
        titel_header.setText("Suppliers");
    }//GEN-LAST:event_btn_SuppliersActionPerformed

    private void btn_currentStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_currentStockActionPerformed
        csm.showProductInTabel();
        hm.setVisible(false);
        csm.setVisible(true);
        sale.setVisible(false);
        suppm.setVisible(false);
        propm.setVisible(false);
        userRole.setVisible(false);
        navHome.setVisible(false);
        titel_header.setText("Blank");
    }//GEN-LAST:event_btn_currentStockActionPerformed

    private void btn_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salesActionPerformed

        hm.setVisible(false);
        csm.setVisible(false);
        sale.setVisible(true);
        suppm.setVisible(false);
        propm.setVisible(false);
        nvp.setVisible(false);
        userRole.setVisible(false);
        navHome.setVisible(false);
        titel_header.setText("Sales");


    }//GEN-LAST:event_btn_salesActionPerformed

    private void btn_userRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_userRoleActionPerformed
        // TODO add your handling code here:
        hm.setVisible(false);
        csm.setVisible(false);
        sale.setVisible(false);
        suppm.setVisible(false);
        propm.setVisible(false);
        nvp.setVisible(false);
        userRole.setVisible(true);
        navHome.setVisible(false);
        titel_header.setText("User and Role");
    }//GEN-LAST:event_btn_userRoleActionPerformed

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
                } catch (Exception ex) {
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
    private javax.swing.JButton btn_userRole;
    private javax.swing.JPanel header;
    private javax.swing.JLayeredPane mainContent;
    private javax.swing.JPanel navbar;
    private javax.swing.JLabel titel_header;
    private javax.swing.JLabel titel_header1;
    // End of variables declaration//GEN-END:variables

}
