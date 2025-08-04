/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ModulComponent.subComponent.Supplier;

import DAO.OrderDao;
import DAO.StockDetailTableDao;
import DTO.IncomeDto;
import DTO.OrderDto;
import DTO.StockDetailTableDto;
import DTO.UserDto;
import Database.DatabaseConfig;
import UI.DialogSetRole;
import static UI.DialogSetRole.RET_OK;
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Da Phadenphorakden
 */
public class Order extends javax.swing.JPanel {

    /**
     * Creates new form Order
     */
    OrderDao dao = new OrderDao();
    StockDetailTableDao dataStockDetailTable = new StockDetailTableDao();

    public Order() throws Exception {
        initComponents();
        getOrderTable();
        setStockDetailTable();
        setComboboxProduct();
        setComboboxVendor();
        setComboboxStatus();

        // Create the desired font for the header
        JTableHeader header1 = tbl_order.getTableHeader();
        Font headerFont1 = new Font("Century Gothic", Font.BOLD, 14); // Example: Bold, Size 14
        header1.setFont(headerFont1);
        JTableHeader header2 = tbl_prodcutDetail.getTableHeader();
        Font headerFont2 = new Font("Century Gothic", Font.BOLD, 14); // Example: Bold, Size 14
        header2.setFont(headerFont2);
    }

    public void getOrderTable() throws Exception {
        List<OrderDto> getDataOrderTable = dao.getOrdertable();
        DefaultTableModel tbl = (DefaultTableModel) this.tbl_order.getModel();
        tbl.setRowCount(0);//clear
        for (OrderDto orderDto : getDataOrderTable) {
            tbl.addRow(new Object[]{
                "OID" + orderDto.getOrder_id(),
                orderDto.getOrder_date(),
                orderDto.getOrder_porpose(),
                orderDto.getProduct_name(),
                orderDto.getQuantity(),
                orderDto.getVendor_name(),
                orderDto.getStatus()});
            if (tbl.getRowCount() > 0) {
                this.tbl_order.setRowSelectionInterval(0, 0);
            }
        }
    }

    public void setStockDetailTable() throws Exception {
        List<StockDetailTableDto> datatable = dataStockDetailTable.stockDetailTable();
        DefaultTableModel model = (DefaultTableModel) tbl_prodcutDetail.getModel();
        model.setRowCount(0);
        Object[] row = new Object[6];

        for (int i = 0; i < datatable.size(); i++) {
            row[0] = "PID" + datatable.get(i).getProduct_id();
            row[1] = datatable.get(i).getProduct_name();
            row[2] = datatable.get(i).getProduct_cate();
            row[3] = datatable.get(i).getStockin();
            row[4] = datatable.get(i).getStockout();
            row[5] = datatable.get(i).getStockavaible();

            model.addRow(row);

        }
    }

    public void setComboboxProduct() {
        try {
            String sql = "SELECT id, name\n"
                    + "	FROM public.product;";
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Integer proid = rs.getInt("id");
                String proname = rs.getString("name");
                jCombo_proName.addItem(proid + " - " + proname);

            }
            rs.close();

        } catch (Exception e) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void setComboboxVendor() {
        try {
            String sql = "SELECT id, name\n"
                    + "	FROM public.suppliers;";
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Integer venid = rs.getInt("id");
                String venname = rs.getString("name");
                jComboBox_VenName.addItem(venid + " - " + venname);

            }
            rs.close();

        } catch (Exception e) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void setComboboxStatus() {
        try {
            String sql = "SELECT id, status\n"
                    + "	FROM public.tbl_status;";
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Integer statusid = rs.getInt("id");
                String statusname = rs.getString("status");
                jComboBox_Status.addItem(statusid + " - " + statusname);

            }
            rs.close();

        } catch (Exception e) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void refresh() throws Exception {
        jTextArea_porpose.setText("");
        jTextField_Qty.setText("");
        getOrderTable();

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSpinnerDate = new javax.swing.JSpinner();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea_porpose = new javax.swing.JTextArea();
        jTextField_Qty = new javax.swing.JTextField();
        jComboBox_Status = new javax.swing.JComboBox<>();
        jComboBox_VenName = new javax.swing.JComboBox<>();
        jCombo_proName = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_order = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_prodcutDetail = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        tbnAdd = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnEdit = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnDelete = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnRefrsh = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Geist Mono", 0, 14)); // NOI18N
        jLabel1.setText("Order Date");

        jLabel2.setFont(new java.awt.Font("Geist Mono", 0, 14)); // NOI18N
        jLabel2.setText("Porpose");

        jLabel3.setFont(new java.awt.Font("Geist Mono", 0, 14)); // NOI18N
        jLabel3.setText("Status");

        jLabel4.setFont(new java.awt.Font("Geist Mono", 0, 14)); // NOI18N
        jLabel4.setText("Product Name");

        jLabel5.setFont(new java.awt.Font("Geist Mono", 0, 14)); // NOI18N
        jLabel5.setText("Quantity");

        jLabel6.setFont(new java.awt.Font("Geist Mono", 0, 14)); // NOI18N
        jLabel6.setText("Vendor Name");

        jSpinnerDate.setFont(new java.awt.Font("Geist Mono", 0, 12)); // NOI18N
        jSpinnerDate.setModel(new javax.swing.SpinnerDateModel());
        jSpinnerDate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSpinnerDate.setEditor(new javax.swing.JSpinner.DateEditor(jSpinnerDate, "d-MM-YYYY"));

        jTextArea_porpose.setColumns(20);
        jTextArea_porpose.setFont(new java.awt.Font("Geist Mono", 0, 12)); // NOI18N
        jTextArea_porpose.setRows(5);
        jScrollPane3.setViewportView(jTextArea_porpose);

        jTextField_Qty.setFont(new java.awt.Font("Geist Mono", 0, 12)); // NOI18N

        jComboBox_Status.setFont(new java.awt.Font("Geist Mono", 0, 12)); // NOI18N

        jComboBox_VenName.setFont(new java.awt.Font("Geist Mono", 0, 12)); // NOI18N
        jComboBox_VenName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_VenNameActionPerformed(evt);
            }
        });

        jCombo_proName.setFont(new java.awt.Font("Geist Mono", 0, 12)); // NOI18N
        jCombo_proName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCombo_proNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinnerDate, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_Qty, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jComboBox_VenName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox_Status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCombo_proName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinnerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jCombo_proName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_Qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox_VenName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_order.setFont(new java.awt.Font("Geist Mono", 0, 12)); // NOI18N
        tbl_order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Order Date", "Porpose", "Product Name", "Quantity", "Vendor", "Status"
            }
        ));
        tbl_order.setRowHeight(20);
        jScrollPane2.setViewportView(tbl_order);
        if (tbl_order.getColumnModel().getColumnCount() > 0) {
            tbl_order.getColumnModel().getColumn(0).setMinWidth(80);
            tbl_order.getColumnModel().getColumn(0).setMaxWidth(80);
            tbl_order.getColumnModel().getColumn(1).setMinWidth(100);
            tbl_order.getColumnModel().getColumn(1).setMaxWidth(100);
            tbl_order.getColumnModel().getColumn(3).setMinWidth(120);
            tbl_order.getColumnModel().getColumn(3).setMaxWidth(120);
            tbl_order.getColumnModel().getColumn(4).setMaxWidth(80);
            tbl_order.getColumnModel().getColumn(5).setMinWidth(100);
            tbl_order.getColumnModel().getColumn(5).setMaxWidth(100);
            tbl_order.getColumnModel().getColumn(6).setMinWidth(120);
            tbl_order.getColumnModel().getColumn(6).setMaxWidth(120);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tbl_prodcutDetail.setFont(new java.awt.Font("Geist Mono", 0, 12)); // NOI18N
        tbl_prodcutDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Category", "Stock IN", "Stock Out", "Available"
            }
        ));
        tbl_prodcutDetail.setRowHeight(20);
        jScrollPane1.setViewportView(tbl_prodcutDetail);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        tbnAdd.setFont(new java.awt.Font("Geist Mono", 0, 14)); // NOI18N
        tbnAdd.setText("Add");
        tbnAdd.setFocusable(false);
        tbnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbnAdd.setPreferredSize(new java.awt.Dimension(75, 32));
        tbnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnAddActionPerformed(evt);
            }
        });
        jToolBar1.add(tbnAdd);
        jToolBar1.add(jSeparator2);

        btnEdit.setFont(new java.awt.Font("Geist Mono", 0, 14)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setFocusable(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setPreferredSize(new java.awt.Dimension(75, 32));
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEdit);
        jToolBar1.add(jSeparator3);

        btnDelete.setFont(new java.awt.Font("Geist Mono", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setFocusable(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setPreferredSize(new java.awt.Dimension(75, 32));
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDelete);
        jToolBar1.add(jSeparator4);

        btnRefrsh.setFont(new java.awt.Font("Geist Mono", 0, 14)); // NOI18N
        btnRefrsh.setText("Refresh");
        btnRefrsh.setFocusable(false);
        btnRefrsh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRefrsh.setPreferredSize(new java.awt.Dimension(75, 32));
        btnRefrsh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnRefrsh);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_VenNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_VenNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_VenNameActionPerformed

    private void jCombo_proNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCombo_proNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCombo_proNameActionPerformed

    @SuppressWarnings("empty-statement")
    private void tbnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnAddActionPerformed
        // add
        try {
            Date utilDate = (Date) this.jSpinnerDate.getValue();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            String porpose = jTextArea_porpose.getText();

            String productName = (String) jCombo_proName.getModel().getSelectedItem();
            String getProName = productName.split(" - ")[0];
            Integer getProId = Integer.valueOf(getProName);;

            Integer qty = Integer.valueOf(jTextField_Qty.getText());

            String vendorName = (String) jComboBox_VenName.getModel().getSelectedItem();
            String getVendorName = vendorName.split(" - ")[0];
            Integer getVendorId = Integer.valueOf(getVendorName);

            String statusName = (String) jComboBox_Status.getModel().getSelectedItem();
            String getStatusName = statusName.split(" - ")[0];
            Integer getStatusId = Integer.valueOf(getStatusName);

            String sql = "INSERT INTO public.tbl_order(\n"
                    + "	order_date, purpose, product_id, quantity, vendor_id, status)\n"
                    + "	VALUES ( ?, ?, ?, ?, ?, ?);";
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            pstmt.setDate(1, sqlDate);
            pstmt.setString(2, porpose);
            pstmt.setInt(3, getProId);
            pstmt.setInt(4, qty);
            pstmt.setInt(5, getVendorId);
            pstmt.setInt(6, getStatusId);
            if (pstmt.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Order Created Successfully");
                refresh();
            } else {
                System.out.println("Failed to Set Role");
                JOptionPane.showMessageDialog(null, "Failed to Create Order");
            }
//            System.out.println(utilDate);
//            System.out.println(porpose);
//            System.out.println(getProId);
//            System.out.println(qty);
//            System.out.println(getVendorId);
//            System.out.println(getStatusId);
        } catch (NumberFormatException | SQLException e) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, e.getMessage());

        } catch (Exception ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_tbnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Edit
        try {
            DefaultTableModel tbl = (DefaultTableModel) this.tbl_order.getModel();
            if (tbl.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No record selected!");
                return;
            }
            int idx = this.tbl_order.getSelectedRow();

            if (btnEdit.getText().equals("Edit")) {
                jSpinnerDate.setValue(tbl.getValueAt(idx, 1));
                jTextArea_porpose.setText(tbl.getValueAt(idx, 2).toString());

                this.jCombo_proName.removeAllItems();
                jCombo_proName.addItem((String) tbl.getValueAt(idx, 3));

                jTextField_Qty.setText(tbl.getValueAt(idx, 4).toString());
                this.jComboBox_VenName.removeAllItems();
                jComboBox_VenName.addItem((String) tbl.getValueAt(idx, 5));

                this.jComboBox_Status.removeAllItems();
                jComboBox_Status.addItem((String) tbl.getValueAt(idx, 6));
                this.btnEdit.setText("Update");
                this.btnEdit.setEnabled(true);
            } else {

                Date utilDate = (Date) this.jSpinnerDate.getValue();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                String porpose = this.jTextArea_porpose.getText();
                int qty = Integer.parseInt(this.jTextField_Qty.getText());
//                int order_id = Integer.parseInt(tbl.getValueAt(idx, 0).toString());

                String rawId = tbl.getValueAt(idx, 0).toString();
                String numericPart = rawId.replaceAll("[^\\d]", ""); // remove all non-digit characters
                int order_id = Integer.parseInt(numericPart);

                String sql = "UPDATE public.tbl_order\n"
                        + "	SET  order_date=?, purpose=?, quantity=?\n"
                        + "	WHERE id = ?;";
                try (PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql) // Set values to SQL parameters
                        ) {
                    pstmt.setDate(1, sqlDate);
                    pstmt.setString(2, porpose);
                    pstmt.setInt(3, qty);
                    pstmt.setInt(4, order_id);
                    if (pstmt.executeUpdate() > 0) {
                        JOptionPane.showMessageDialog(null, "Order Created Successfully");
                        refresh();
                        this.btnEdit.setText("Edit");
                        this.btnEdit.setVisible(true);
                    } else {
                        System.out.println("Failed to Set Role");
                        JOptionPane.showMessageDialog(null, "Failed to Create Order");
                    }
                }
            }
        } catch (HeadlessException | NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // Delete
        try {
            
            if (this.tbl_order.getSelectedRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No record selected!");
                return;
            }
            
            int opt = JOptionPane.showConfirmDialog(this, "Are you sure to delete this record?", "Delete", JOptionPane.YES_NO_OPTION);
            if (opt == 0) {
                DefaultTableModel tbl = (DefaultTableModel) this.tbl_order.getModel();
              
                int idx = this.tbl_order.getSelectedRow();
                String rawId = tbl.getValueAt(idx, 0).toString();
                String numericPart = rawId.replaceAll("[^\\d]", ""); // remove all non-digit characters
                int order_id = Integer.parseInt(numericPart);
                long uid = order_id;
                if (dao.delete(uid) == true) {
                    tbl.removeRow(idx);
                    refresh();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRefrsh;
    private javax.swing.JComboBox<String> jComboBox_Status;
    private javax.swing.JComboBox<String> jComboBox_VenName;
    private javax.swing.JComboBox<String> jCombo_proName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JSpinner jSpinnerDate;
    private javax.swing.JTextArea jTextArea_porpose;
    private javax.swing.JTextField jTextField_Qty;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tbl_order;
    private javax.swing.JTable tbl_prodcutDetail;
    private javax.swing.JButton tbnAdd;
    // End of variables declaration//GEN-END:variables
}
