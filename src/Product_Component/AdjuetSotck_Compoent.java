/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Product_Component;

import DTO.AdjustProductDto;
import DTO.importProductDto;
import Database.DatabaseConfig;
import common.CommonUtil;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
public class AdjuetSotck_Compoent extends javax.swing.JInternalFrame {

    /**
     * Creates new form AdjuetSotck
     */
    int position = 0;
    public AdjuetSotck_Compoent() {
        initComponents();
        showInTabel();
        
        
        btn_update.setVisible(false);
        
        //Set name Combobox
        this.loadBoxItemFields(new String[]{"Adjust Qaunity","Adjust Price","Adjust Cost"});
        
        // Create the desired font for the header
        JTableHeader header = jTable_AdjustSotck.getTableHeader();
        Font headerFont = new Font("Century Gothic", Font.BOLD, 18); // Example: Bold, Size 14
        header.setFont(headerFont);
        
        
        
    }
    //getData from database
    public List<AdjustProductDto> getDataAdjustProductDto() 
    {
        List<AdjustProductDto> list = new ArrayList<AdjustProductDto>();
        try{
            String sql = "SELECT id, prodcut_id, name, category, adjust_to, adjust_amount, adjust_for, adjust_date, image FROM public.view_adjust_stock ORDER BY id DESC;";
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            AdjustProductDto getdata;
            while (rs.next()) {                
                getdata = new AdjustProductDto(
                        rs.getInt("id"),
                        rs.getInt("prodcut_id"),
                        rs.getString("name"), 
                        rs.getString("category"),
                        rs.getString("adjust_to"),
                        rs.getDouble("adjust_amount"),
                        rs.getString("adjust_for"),
                        rs.getDate("adjust_date"),
                        rs.getString("image"));
                list.add(getdata);
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
     //show data to table
    public void showInTabel()
    {
        List<AdjustProductDto> productsList = getDataAdjustProductDto();
        DefaultTableModel model = (DefaultTableModel) jTable_AdjustSotck.getModel();
        model.setRowCount(0);
        Object[] row = new Object[8];
        
        for( int i = 0;i < productsList.size();i++)
        {
            row[0] = productsList.get(i).getId();
            row[1] = productsList.get(i).getProduct_id();
            row[2] = productsList.get(i).getName();
            row[3] = productsList.get(i).getCategory();
            row[4] = productsList.get(i).getAdjust_to();
            row[5] = productsList.get(i).getAdjust_amount();
            row[6] = productsList.get(i).getAdjust_for();
            row[7] = productsList.get(i).getDate();
            
            model.addRow(row);
            
        }
    }
    public void loadBoxItemFields(String[] fields)
    {
        this.ComBox_adjustTo.removeAllItems();
        this.ComBox_adjustTo.addItem("Choose Adjust for");
        for(String f:fields)
        {
            this.ComBox_adjustTo.addItem(f);
        }
    }public void resetForm(){
        txt_amount.setText("");
        txt_prodect_id.setText("");
        txt_product_name.setText("");
        txt_prodect_cate.setText("");
        this.loadBoxItemFields(new String[]{"Adjust Qaunity","Adjust Price","Adjust Cost"});
        this.cbox_stockin.setSelected(false);
        this.cbox_stockout.setSelected(false);
        cbox_stockin.setEnabled(true);
        cbox_stockout.setEnabled(true);
   
    }
    // Select data on Table
    public void selectOnTable(int index){
       
        txt_prodect_id.setText(String.valueOf(getDataAdjustProductDto().get(index).getProduct_id()));
        txt_product_name.setText(String.valueOf(getDataAdjustProductDto().get(index).getName()));
        txt_prodect_cate.setText(String.valueOf(getDataAdjustProductDto().get(index).getCategory()));
        txt_amount.setText(String.valueOf(getDataAdjustProductDto().get(index).getAdjust_amount()));
        var dataAdjust_for=String.valueOf(getDataAdjustProductDto().get(index).getAdjust_for());
        if ("Stock IN".equals(dataAdjust_for)) {
            cbox_stockin.setSelected(true);
            cbox_stockout.setSelected(false);
            cbox_stockout.setEnabled(isIcon);
        } 
        if ("Stock Out".equals(dataAdjust_for)){
            cbox_stockout.setSelected(true);
            cbox_stockin.setSelected(false);
            cbox_stockin.setEnabled(isIcon);
        }
        ComBox_adjustTo.setSelectedItem(String.valueOf(getDataAdjustProductDto().get(index).getAdjust_to()));
        System.out.println(dataAdjust_for);
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar_stcokdetail = new javax.swing.JToolBar();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btn_store = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_edit = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btn_delete = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btn_search = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btn_reset = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        btn_first = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btn_prev = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btn_next = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btn_last = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        btn_last1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_prodect_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_product_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_prodect_cate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbox_stockin = new javax.swing.JCheckBox();
        cbox_stockout = new javax.swing.JCheckBox();
        ComBox_adjustTo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txt_amount = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_AdjustSotck = new javax.swing.JTable();

        jToolBar_stcokdetail.setFloatable(false);
        jToolBar_stcokdetail.setRollover(true);
        jToolBar_stcokdetail.setInheritsPopupMenu(true);

        jLabel5.setFont(new java.awt.Font("Geist Mono", 1, 24)); // NOI18N
        jLabel5.setText("Adjust Stock");
        jToolBar_stcokdetail.add(jLabel5);

        jSeparator3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jSeparator3.setEnabled(false);
        jSeparator3.setSeparatorSize(new java.awt.Dimension(40, 10));
        jToolBar_stcokdetail.add(jSeparator3);

        btn_store.setFont(new java.awt.Font("Geist Mono", 1, 14)); // NOI18N
        btn_store.setText("Add");
        btn_store.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_store.setFocusable(false);
        btn_store.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_store.setPreferredSize(new java.awt.Dimension(70, 28));
        btn_store.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_store.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_storeActionPerformed(evt);
            }
        });
        jToolBar_stcokdetail.add(btn_store);
        jToolBar_stcokdetail.add(jSeparator1);

        btn_edit.setFont(new java.awt.Font("Geist Mono", 1, 14)); // NOI18N
        btn_edit.setText("Edit");
        btn_edit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_edit.setFocusable(false);
        btn_edit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_edit.setPreferredSize(new java.awt.Dimension(70, 28));
        btn_edit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        jToolBar_stcokdetail.add(btn_edit);

        btn_update.setFont(new java.awt.Font("Geist Mono", 1, 14)); // NOI18N
        btn_update.setText("Update");
        btn_update.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_update.setFocusable(false);
        btn_update.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_update.setPreferredSize(new java.awt.Dimension(70, 28));
        btn_update.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jToolBar_stcokdetail.add(btn_update);
        jToolBar_stcokdetail.add(jSeparator2);

        btn_delete.setFont(new java.awt.Font("Geist Mono", 1, 14)); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_delete.setFocusable(false);
        btn_delete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_delete.setPreferredSize(new java.awt.Dimension(70, 28));
        btn_delete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jToolBar_stcokdetail.add(btn_delete);
        jToolBar_stcokdetail.add(jSeparator4);

        btn_search.setFont(new java.awt.Font("Geist Mono", 1, 14)); // NOI18N
        btn_search.setText("Search");
        btn_search.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_search.setFocusable(false);
        btn_search.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_search.setPreferredSize(new java.awt.Dimension(70, 28));
        btn_search.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        jToolBar_stcokdetail.add(btn_search);

        jSeparator5.setEnabled(false);
        jSeparator5.setSeparatorSize(new java.awt.Dimension(100, 10));
        jToolBar_stcokdetail.add(jSeparator5);

        btn_reset.setFont(new java.awt.Font("Geist Mono", 1, 14)); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_reset.setFocusable(false);
        btn_reset.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_reset.setPreferredSize(new java.awt.Dimension(70, 28));
        btn_reset.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        jToolBar_stcokdetail.add(btn_reset);

        jSeparator9.setEnabled(false);
        jSeparator9.setSeparatorSize(new java.awt.Dimension(200, 10));
        jToolBar_stcokdetail.add(jSeparator9);

        btn_first.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_first.setText("First");
        btn_first.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_first.setFocusable(false);
        btn_first.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_first.setPreferredSize(new java.awt.Dimension(70, 28));
        btn_first.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });
        jToolBar_stcokdetail.add(btn_first);
        jToolBar_stcokdetail.add(jSeparator8);

        btn_prev.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_prev.setText("Prev");
        btn_prev.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_prev.setFocusable(false);
        btn_prev.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_prev.setPreferredSize(new java.awt.Dimension(70, 28));
        btn_prev.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_prev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_prevMouseClicked(evt);
            }
        });
        btn_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevActionPerformed(evt);
            }
        });
        jToolBar_stcokdetail.add(btn_prev);
        jToolBar_stcokdetail.add(jSeparator6);

        btn_next.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_next.setText("Next");
        btn_next.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_next.setFocusable(false);
        btn_next.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_next.setMinimumSize(new java.awt.Dimension(56, 31));
        btn_next.setPreferredSize(new java.awt.Dimension(70, 28));
        btn_next.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nextMouseClicked(evt);
            }
        });
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });
        jToolBar_stcokdetail.add(btn_next);
        jToolBar_stcokdetail.add(jSeparator7);

        btn_last.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_last.setText("Last");
        btn_last.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_last.setFocusable(false);
        btn_last.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_last.setPreferredSize(new java.awt.Dimension(70, 28));
        btn_last.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_last.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_lastMouseClicked(evt);
            }
        });
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });
        jToolBar_stcokdetail.add(btn_last);

        jSeparator11.setEnabled(false);
        jSeparator11.setSeparatorSize(new java.awt.Dimension(200, 10));
        jToolBar_stcokdetail.add(jSeparator11);

        btn_last1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_last1.setText("Report");
        btn_last1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_last1.setFocusable(false);
        btn_last1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_last1.setPreferredSize(new java.awt.Dimension(70, 28));
        btn_last1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_last1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_last1MouseClicked(evt);
            }
        });
        btn_last1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_last1ActionPerformed(evt);
            }
        });
        jToolBar_stcokdetail.add(btn_last1);

        txt_prodect_id.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel1.setText("Product ID:");

        jLabel2.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel2.setText("Product Name:");

        txt_product_name.setEditable(false);
        txt_product_name.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel3.setText("Product Cate:");

        txt_prodect_cate.setEditable(false);
        txt_prodect_cate.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel4.setText("Adjust to:");

        cbox_stockin.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        cbox_stockin.setText("Stock IN");
        cbox_stockin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbox_stockinMouseClicked(evt);
            }
        });
        cbox_stockin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_stockinActionPerformed(evt);
            }
        });

        cbox_stockout.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        cbox_stockout.setText("Stock Out");
        cbox_stockout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbox_stockoutMouseClicked(evt);
            }
        });
        cbox_stockout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_stockoutActionPerformed(evt);
            }
        });

        ComBox_adjustTo.setFont(new java.awt.Font("Geist Mono", 0, 14)); // NOI18N
        ComBox_adjustTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adjust Quantiy", "Adjust Cost", "Adjust Price", " " }));
        ComBox_adjustTo.setSelectedItem("Choose");
        ComBox_adjustTo.setToolTipText("Choose Adjust for");
        ComBox_adjustTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComBox_adjustToActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel6.setText("Amount:");

        txt_amount.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_prodect_id, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txt_prodect_cate, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComBox_adjustTo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbox_stockin)
                            .addComponent(txt_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbox_stockout))))
                .addContainerGap(846, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_prodect_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)))
                    .addComponent(ComBox_adjustTo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_prodect_cate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbox_stockin, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbox_stockout))))
        );

        ComBox_adjustTo.getAccessibleContext().setAccessibleName("200");

        jTable_AdjustSotck.setFont(new java.awt.Font("Geist Mono", 0, 14)); // NOI18N
        jTable_AdjustSotck.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Adjust ID", "Product ID", "Product Name", "Product Category", "Adjust to", "Amount", "Adjust for", "Adjust Date"
            }
        ));
        jTable_AdjustSotck.setRowHeight(25);
        jScrollPane1.setViewportView(jTable_AdjustSotck);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar_stcokdetail, javax.swing.GroupLayout.DEFAULT_SIZE, 1665, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar_stcokdetail, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbox_stockoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_stockoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_stockoutActionPerformed

    private void ComBox_adjustToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComBox_adjustToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComBox_adjustToActionPerformed

    private void btn_storeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_storeActionPerformed
        // Store
        try {
            var product_id =txt_prodect_id.getText();
            var adjust_to = ComBox_adjustTo.getModel().getSelectedItem();
            var adjust_amount = txt_amount.getText();
            var adjust_data = LocalDate.now();
            if(product_id.isEmpty()){
                this.txt_prodect_id.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "product id reqiure");
                this.txt_prodect_id.setBackground(Color.white);
                txt_prodect_id.requestFocus();
                return;
            }

            String sql = "INSERT INTO public.adjust_stock(prodcut_id, adjust_to, adjust_for, adjust_date, adjust_amount) VALUES ( ?, ?, ?, ?, ?);";
                PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
                pstmt.setInt(1, Integer.parseInt(product_id));
                pstmt.setString(2,String.valueOf(adjust_to));
                if(cbox_stockin.getModel().isSelected() == true){
                   var adjust_for = cbox_stockin.getText();
                   pstmt.setString(3,String.valueOf(adjust_for));
                }else if(cbox_stockout.getModel().isSelected() == true){
                    var adjust_for = cbox_stockout.getText();
                    pstmt.setString(3,String.valueOf(adjust_for));
                }else{
                    this.ComBox_adjustTo.addItem(" ");
                }
                pstmt.setDate(4, Date.valueOf(adjust_data));
                pstmt.setDouble(5, Double.parseDouble(adjust_amount));
                if (pstmt.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "New Product Added Successfully");
                    showInTabel();
                    resetForm();
                } else {
                    System.out.println("Failed to add product");
                    JOptionPane.showMessageDialog(null, "Failed to add product");
                }
            
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            Logger.getLogger(importStock_Component.class.getName()).log(Level.SEVERE, null, e);
        }

        
    }//GEN-LAST:event_btn_storeActionPerformed

    private void cbox_stockinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbox_stockinMouseClicked
        // TODO add your handling code here:
        if (cbox_stockin.getModel().isSelected()) {
            cbox_stockout.setEnabled(isIcon);
        }else{
            cbox_stockout.setEnabled(true);
        }
    }//GEN-LAST:event_cbox_stockinMouseClicked

    private void cbox_stockoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbox_stockoutMouseClicked
        // TODO add your handling code here:
        if(cbox_stockout.getModel().isSelected()){
            cbox_stockin.setEnabled(isIcon);
        }else{
            cbox_stockin.setEnabled(true);
        }
    }//GEN-LAST:event_cbox_stockoutMouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // Edit
        int index = jTable_AdjustSotck.getSelectedRow();
        if(index == jTable_AdjustSotck.getSelectedRow()){
            selectOnTable(index); 
            btn_store.setEnabled(false);
            btn_store.setText("");
            btn_delete.setEnabled(false);
            btn_delete.setText("");
            btn_search.setEnabled(false);
            btn_search.setText("");
            btn_edit.setVisible(false);
            btn_update.setVisible(true);
            btn_next.setEnabled(false);
            btn_prev.setEnabled(false);
            btn_last.setEnabled(false);
            btn_first.setEnabled(false);
            jTable_AdjustSotck.setEnabled(false);
            btn_reset.setEnabled(false);
//            cbox_stockin.setEnabled(true);
//            cbox_stockout.setEnabled(true);
        }   
    }//GEN-LAST:event_btn_editActionPerformed
   
    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        /// Update
        btn_edit.setVisible(true);
        btn_update.setVisible(false);
        btn_store.setEnabled(true);
        btn_store.setText("Add New");       
        btn_delete.setEnabled(true);
        btn_delete.setText("Delete");
        jTable_AdjustSotck.setEnabled(true);
        btn_search.setEnabled(true);
        btn_search.setText("Search");
        btn_next.setEnabled(true);
        btn_prev.setEnabled(true);
        btn_last.setEnabled(true);
        btn_first.setEnabled(true);
        
        int index = jTable_AdjustSotck.getSelectedRow();
        try {
            var adjust_id = String.valueOf(getDataAdjustProductDto().get(index).getId());
            var product_id =txt_prodect_id.getText();
            var adjust_to = ComBox_adjustTo.getModel().getSelectedItem();
            var adjust_amount = txt_amount.getText();
            var adjust_data = LocalDate.now();
            if(product_id.isEmpty()){
                this.txt_prodect_id.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "product id reqiure");
                this.txt_prodect_id.setBackground(Color.white);
                txt_prodect_id.requestFocus();
                return;
            }
            String sql = "UPDATE public.adjust_stock SET  prodcut_id=?, adjust_to=?, adjust_for=?, adjust_date=?, adjust_amount=? WHERE id=?;";
                PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
                pstmt.setInt(1, Integer.parseInt(product_id));
                pstmt.setString(2,String.valueOf(adjust_to));
                
                if(cbox_stockin.getModel().isSelected() == true){
                   var adjust_for = cbox_stockin.getText();
                   pstmt.setString(3,String.valueOf(adjust_for));
                }else if(cbox_stockout.getModel().isSelected() == true){
                    var adjust_for = cbox_stockout.getText();
                    pstmt.setString(3,String.valueOf(adjust_for));
                }else{
                    this.ComBox_adjustTo.addItem(" ");
                }
                
                pstmt.setDate(4, Date.valueOf(adjust_data));
                pstmt.setDouble(5, Double.parseDouble(adjust_amount));
                pstmt.setInt(6, Integer.parseInt(adjust_id));
                
                
                if (pstmt.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Update Successfully");
                    showInTabel();
                    resetForm();
                } else {
                    System.out.println("Failed to Update Product");
                    JOptionPane.showMessageDialog(null, "Failed to Update Product");
                }
          
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            Logger.getLogger(importStock_Component.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        //Delete
        int index = jTable_AdjustSotck.getSelectedRow();
        Integer id = getDataAdjustProductDto().get(index).getId();
        
        try {
            String sql = "DELETE FROM public.adjust_stock WHERE id=?;";
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure to delete this product","Remove Product",JOptionPane.YES_NO_OPTION);
                
                if (confirm == JOptionPane.YES_NO_OPTION) 
                {
                    if (pstmt.executeUpdate() > 0) {
                    System.out.println("Product deleted");
                    JOptionPane.showMessageDialog(null, "Product Deleted Successfully");
                    
                    showInTabel();
                    resetForm();
                    } else {
                        JOptionPane.showConfirmDialog(null, "Product Not Delete, Make Sure The ID is valid", "Remove Product", JOptionPane.ERROR_MESSAGE);
                    }
                }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showConfirmDialog(null, "Product Not Delete, Make Sure The ID is valid", "Remove Product", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        //Sreach by Adjust_ID Product_id product_Name
        if(this.txt_prodect_id.getText().equals(""))
            {
                this.txt_prodect_id.setBackground(Color.red);
                JOptionPane.showMessageDialog(this, "Product ID must be exist!", "Invalid Data", HEIGHT);
                this.txt_prodect_id.setBackground(Color.white);
                txt_prodect_id.requestFocus();
                return;
            }

        DefaultTableModel tbl = (DefaultTableModel) this.jTable_AdjustSotck.getModel();
        boolean found = false;

        this.jTable_AdjustSotck.clearSelection(); // Clear any previous selections

        for (int i = 0; i < tbl.getRowCount(); i++) {
            if (tbl.getValueAt(i, 1).toString().equals(this.txt_prodect_id.getText().trim())) {
                this.jTable_AdjustSotck.addRowSelectionInterval(i, i); // Highlight each matching row
                if (!found) {
                    this.jTable_AdjustSotck.scrollRectToVisible(this.jTable_AdjustSotck.getCellRect(i, 0, true)); // Scroll to first match
                }
                found = true;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "Product ID not found!", "Search Result", JOptionPane.WARNING_MESSAGE);
            txt_prodect_id.requestFocus();
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        resetForm();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nextMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nextMouseClicked

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        // show and select next recode:
        position ++;
        if(position > getDataAdjustProductDto().size()-1)
        {
            position = getDataAdjustProductDto().size()-1;
            JOptionPane.showMessageDialog(null, "អស់ហើយចុចអីទៀត");
        }
        
        jTable_AdjustSotck.setRowSelectionInterval(position, position);
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_prevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_prevMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_prevMouseClicked

    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        // show and select previous recode:
        position --;
        if(position < 0)
        {
            position = 0;

            JOptionPane.showMessageDialog(null, "អស់ហើយចុចអីទៀត");
        }
       
        jTable_AdjustSotck.setRowSelectionInterval(position, position);
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_lastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lastMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_lastMouseClicked

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        //        // show and select last recode:
        position = getDataAdjustProductDto().size()-1;
       
        jTable_AdjustSotck.setRowSelectionInterval(position, position);
    }//GEN-LAST:event_btn_lastActionPerformed

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        //        // show and select first recode:
        position = 0;
       
        jTable_AdjustSotck.setRowSelectionInterval(position, position);
    }//GEN-LAST:event_btn_firstActionPerformed

    private void btn_last1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_last1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_last1MouseClicked

    private void btn_last1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_last1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_last1ActionPerformed

    private void cbox_stockinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_stockinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_stockinActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComBox_adjustTo;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_last1;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_prev;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_store;
    private javax.swing.JButton btn_update;
    private javax.swing.JCheckBox cbox_stockin;
    private javax.swing.JCheckBox cbox_stockout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JTable jTable_AdjustSotck;
    private javax.swing.JToolBar jToolBar_stcokdetail;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_prodect_cate;
    private javax.swing.JTextField txt_prodect_id;
    private javax.swing.JTextField txt_product_name;
    // End of variables declaration//GEN-END:variables
}
