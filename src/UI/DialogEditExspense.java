/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/OkCancelDialog.java to edit this template
 */
package UI;

import DAO.ExspenseDao;
import DTO.ExspenseDto;
import DTO.PermissionDto;
import Database.DatabaseConfig;
import Product_Component.importStock_Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Da Phadenphorakden
 */
public final class DialogEditExspense extends javax.swing.JDialog {

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    /**
     * Creates new form DialogCreateExspense
     *
     * @param parent
     * @param exspenses_id
     */
    public DialogEditExspense(java.awt.Frame parent, int exspenses_id) throws SQLException {
        super(parent, "DailogEdit", true);
        initComponents();

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });

        List<ExspenseDto> data = getdata(exspenses_id); // expenseId is the selected row ID
        if (!data.isEmpty()) {
            ExspenseDto dto = data.get(0);
            lable_id.setText(String.valueOf(dto.getExspense_id()));
            exspense_purpose.setText(dto.getExspense_purpose());
            exspense_description.setText(dto.getExspense_description());
            exspense_qty.setText(String.valueOf(dto.getQuantity()));
            exspense_price.setText(String.valueOf(dto.getExspense_price()));
            total.setText(String.valueOf(dto.getTotal()));

            // For date spinner (if using JSpinner with Date model)
            exspense_date.setValue(dto.getExspense_date());
        }
    }

    public List<ExspenseDto> getdata(int exspenses_id) throws SQLException {
        List<ExspenseDto> resp = new ArrayList<>();
        String sql = "SELECT id, expense_date, purpose, description, quantity, price, total "
                + "FROM public.tbl_exspense WHERE id = ?";
        PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
        pstmt.setInt(1, exspenses_id);

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            ExspenseDto dto = new ExspenseDto();
            dto.setExspense_id(rs.getInt("id"));
            dto.setExspense_date(rs.getDate("expense_date"));
            dto.setExspense_purpose(rs.getString("purpose"));
            dto.setExspense_description(rs.getString("description"));
            dto.setQuantity(rs.getInt("quantity"));
            dto.setExspense_price(rs.getDouble("price"));
            dto.setTotal(rs.getDouble("total"));
            resp.add(dto);
        }
        rs.close();
        return resp;

    }

    public void updateExpense(int exspense_id) {
        try {
            String sql = "UPDATE public.tbl_exspense SET "
                    + "expense_date = ?, "
                    + "purpose = ?, "
                    + "description = ?, "
                    + "quantity = ?, "
                    + "price = ? "
                    + "WHERE id = ?";

            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);

            // Get values from form fields
            java.util.Date utilDate = (java.util.Date) exspense_date.getValue();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            int qty = Integer.parseInt(exspense_qty.getText());
            double price = Double.parseDouble(exspense_price.getText());
            

            // Set values to SQL parameters
            pstmt.setDate(1, sqlDate);
            pstmt.setString(2, exspense_purpose.getText());
            pstmt.setString(3, exspense_description.getText());
            pstmt.setInt(4, qty);
            pstmt.setDouble(5, price);
            pstmt.setInt(6, exspense_id);

            // Execute update
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Expense updated successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "No record updated.");
            }

            pstmt.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error updating expense: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private DialogEditExspense(JFrame jFrame) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel_createExspense = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        exspense_date = new javax.swing.JSpinner();
        exspense_purpose = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        exspense_description = new javax.swing.JTextArea();
        total = new javax.swing.JTextField();
        exspense_qty = new javax.swing.JTextField();
        exspense_price = new javax.swing.JTextField();
        lable_id = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setText("Update");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Geist Mono", 0, 36)); // NOI18N
        jLabel1.setText("Edit Exspense ID:");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel5.setText("Price:");

        jLabel6.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel6.setText("Quantity:");

        jLabel4.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel4.setText("Description:");

        jLabel3.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel3.setText("Porpose:");

        jLabel2.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel2.setText("Date:");

        jLabel7.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel7.setText("Total:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addGap(15, 15, 15))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        exspense_date.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        exspense_date.setModel(new javax.swing.SpinnerDateModel());
        exspense_date.setEditor(new javax.swing.JSpinner.DateEditor(exspense_date, "d-MM-YYYY"));

        exspense_purpose.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N

        exspense_description.setColumns(20);
        exspense_description.setFont(new java.awt.Font("Geist Mono", 0, 14)); // NOI18N
        exspense_description.setRows(5);
        jScrollPane1.setViewportView(exspense_description);

        total.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N

        exspense_qty.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N

        exspense_price.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        exspense_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exspense_priceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(exspense_purpose, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exspense_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                    .addComponent(total, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                    .addComponent(exspense_price, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exspense_qty, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(exspense_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(exspense_purpose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(exspense_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exspense_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel_createExspenseLayout = new javax.swing.GroupLayout(jPanel_createExspense);
        jPanel_createExspense.setLayout(jPanel_createExspenseLayout);
        jPanel_createExspenseLayout.setHorizontalGroup(
            jPanel_createExspenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_createExspenseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_createExspenseLayout.setVerticalGroup(
            jPanel_createExspenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_createExspenseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_createExspenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        lable_id.setFont(new java.awt.Font("Geist Mono", 0, 36)); // NOI18N
        lable_id.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_createExspense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lable_id)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lable_id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_createExspense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        doClose(RET_OK);
        int expid = Integer.parseInt(this.lable_id.getText());
        updateExpense(expid);
        
        
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void exspense_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exspense_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exspense_priceActionPerformed

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

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
            java.util.logging.Logger.getLogger(DialogEditExspense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogEditExspense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogEditExspense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogEditExspense.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogEditExspense dialog = new DialogEditExspense(new javax.swing.JFrame());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JSpinner exspense_date;
    private javax.swing.JTextArea exspense_description;
    private javax.swing.JTextField exspense_price;
    private javax.swing.JTextField exspense_purpose;
    private javax.swing.JTextField exspense_qty;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_createExspense;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lable_id;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
}
