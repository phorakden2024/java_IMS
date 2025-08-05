package Product_Component;
import DTO.importProductDto;
import DTO.productDto;
import Database.DatabaseConfig;
import Product_Component.Dialog.Adjust_price_dialog;
import Database.DatabaseConnection;
import Logic.product;
import UI.productReport;
import java.awt.*;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.JTableHeader;






public class ProductModul extends javax.swing.JPanel {

    private static final String url = "jdbc:postgresql://localhost:5432/Inventory"; // Replace with your DB details
    private static final String user = "postgres"; // Replace with your DB username
    private static final String password = "dan@12345"; // Replace with your DB password

    Border textField_border = BorderFactory.createMatteBorder(0,0,2,0,Color.DARK_GRAY);
    int position = 0;
    public ProductModul() {
        initComponents();
        showProductInTabel();
        
        btn_update.setVisible(false);

        jTextField_prdname.setBorder(textField_border);
        jTextField_por_id.setBorder(textField_border);
        jTextField_img_path.setBorder(textField_border);
        // Create the desired font for the header
        JTableHeader header = jTable_products.getTableHeader();
        Font headerFont = new Font("Century Gothic", Font.BOLD, 16); // Example: Bold, Size 14
        header.setFont(headerFont);
    }
    
    // function that return an array list
    public ArrayList<productDto> getProductsDtoList()
    {
        ArrayList<productDto> list = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM product ORDER BY id DESC;";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            productDto Product;
            while (rs.next()) {                
                Product = new productDto(
                        rs.getInt("id"), 
                        rs.getString("name"), 
                        rs.getString("category"), 
                        rs.getString("image"),
                        rs.getDouble("priceofsale"));
                list.add(Product);
            }
            
        } catch (Exception e) {
            Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
    // function show product in table
    public void showProductInTabel()
    {
        ArrayList<productDto> productsList = getProductsDtoList();
        DefaultTableModel model = (DefaultTableModel) jTable_products.getModel();
        model.setRowCount(0);
        Object[] row = new Object[5];
        
        for( int i = 0;i < productsList.size();i++)
        {
            row[0] = productsList.get(i).getId();
            row[1] = productsList.get(i).getName();
            row[2] = productsList.get(i).getCategory();
            row[3] = productsList.get(i).getPrice_of_sale();
            row[4] = productsList.get(i).getImage();
            
            
            
            model.addRow(row);
            
        }
    }
    //funnction show data from database into textbox
    public void showProductData(int index)
    {
        jTextField_por_id.setText(String.valueOf(getProductsDtoList().get(index).getId()));
        jTextField_prdname.setText(getProductsDtoList().get(index).getName());
        jComboBox_pro_cate.setSelectedItem(getProductsDtoList().get(index).getCategory());
        jTextField_img_path.setText(getProductsDtoList().get(index).getImage());
        txt_priceofsale.setText(String.valueOf(getProductsDtoList().get(index).getPrice_of_sale()));
        displayimg(getProductsDtoList().get(index).getImage(), jLabel_iamge);
        
    }
    // function display image
    public void displayimg (String ImgPath,JLabel label){
        ImageIcon imgIco = new ImageIcon(ImgPath);
        Image img = imgIco.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img));
    }
    // function clear fields
    public void clearFields()
    {
        jTextField_por_id.setText("");
        jTextField_prdname.setText("");
        jComboBox_pro_cate.setSelectedIndex(0);
        jTextField_img_path.setText("");
        txt_priceofsale.setText("");
        jLabel_iamge.setIcon(null);
    }
    private void showKhmerMessageDialog(Component parent, String message, String title, int messageType) {
        // Set Khmer font (e.g., "Khmer OS" or another installed Khmer font)
        Font khmerFont = new Font("Khmer OS", Font.PLAIN, 16);

        // Create a JLabel with the message and Khmer font
        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(khmerFont);

        // Show the JOptionPane with the custom label
        JOptionPane.showMessageDialog(parent, messageLabel, title, messageType);
    }
    public void setEnabled_btn_false(){
            btn_add.setEnabled(false);
            btn_first.setEnabled(false);
            btn_last.setEnabled(false);
            btn_next.setEnabled(false);
            btn_prev.setEnabled(false);
            btn_delete.setEnabled(false);
            btn_report.setEnabled(false);
            btn_adjust_price.setEnabled(false);
            jTable_products.setEnabled(false);
    } 
    public void setEnabled_btn_true(){
        
            btn_add.setEnabled(true);
            btn_first.setEnabled(true);
            btn_last.setEnabled(true);
            btn_next.setEnabled(true);
            btn_prev.setEnabled(true);
            btn_delete.setEnabled(true);
            btn_report.setEnabled(true);
            btn_adjust_price.setEnabled(true);
            jTable_products.setEnabled(true);
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
        jTable_products = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_add = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btn_edit = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btn_delete = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btn_adjust_price = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btn_prev = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btn_first = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btn_last = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btn_next = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        btn_report = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jTextField_por_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_prdname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_pro_cate = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btn_browse = new javax.swing.JButton();
        jLabel_iamge = new javax.swing.JLabel();
        jTextField_img_path = new javax.swing.JTextField();
        txt_priceofsale = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(1116, 804));

        jTable_products.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable_products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Category", "Price of Sale", "Image"
            }
        ));
        jTable_products.setRowHeight(25);
        jTable_products.setSelectionBackground(new java.awt.Color(168, 168, 168));
        jTable_products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_products);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jLabel2.setFont(new java.awt.Font("Geist Mono", 1, 24)); // NOI18N
        jLabel2.setText("Products");
        jToolBar1.add(jLabel2);

        jSeparator1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jSeparator1.setEnabled(false);
        jSeparator1.setSeparatorSize(new java.awt.Dimension(40, 10));
        jToolBar1.add(jSeparator1);

        btn_add.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_add.setText("Add New");
        btn_add.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_add.setPreferredSize(new java.awt.Dimension(70, 28));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_add);
        jToolBar1.add(jSeparator2);

        btn_edit.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_edit.setText("Edit");
        btn_edit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_edit.setFocusable(false);
        btn_edit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_edit.setPreferredSize(new java.awt.Dimension(70, 28));
        btn_edit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMouseClicked(evt);
            }
        });
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_edit);

        btn_update.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_update.setText("Update");
        btn_update.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_update.setPreferredSize(new java.awt.Dimension(70, 28));
        btn_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_updateMouseClicked(evt);
            }
        });
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_update);
        jToolBar1.add(jSeparator3);

        btn_delete.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_delete.setPreferredSize(new java.awt.Dimension(70, 28));
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
        });
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_delete);
        btn_delete.getAccessibleContext().setAccessibleName("");

        jSeparator5.setEnabled(false);
        jSeparator5.setSeparatorSize(new java.awt.Dimension(200, 10));
        jToolBar1.add(jSeparator5);

        btn_adjust_price.setFont(new java.awt.Font("Geist Mono", 1, 14)); // NOI18N
        btn_adjust_price.setText("Adjust Price Detail");
        btn_adjust_price.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_adjust_price.setFocusable(false);
        btn_adjust_price.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_adjust_price.setPreferredSize(new java.awt.Dimension(200, 28));
        btn_adjust_price.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_adjust_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adjust_priceActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_adjust_price);

        jSeparator10.setEnabled(false);
        jSeparator10.setRequestFocusEnabled(false);
        jSeparator10.setSeparatorSize(new java.awt.Dimension(200, 10));
        jToolBar1.add(jSeparator10);

        btn_prev.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_prev.setText("Prev");
        btn_prev.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_prev.setPreferredSize(new java.awt.Dimension(70, 28));
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
        jToolBar1.add(btn_prev);
        jToolBar1.add(jSeparator8);

        btn_first.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_first.setText("First");
        btn_first.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_first.setPreferredSize(new java.awt.Dimension(70, 28));
        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_first);
        jToolBar1.add(jSeparator7);

        btn_last.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_last.setText("Last");
        btn_last.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_last.setPreferredSize(new java.awt.Dimension(70, 28));
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
        jToolBar1.add(btn_last);
        jToolBar1.add(jSeparator6);

        btn_next.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_next.setText("Next");
        btn_next.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_next.setMinimumSize(new java.awt.Dimension(56, 31));
        btn_next.setPreferredSize(new java.awt.Dimension(70, 28));
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
        jToolBar1.add(btn_next);

        jSeparator11.setEnabled(false);
        jSeparator11.setSeparatorSize(new java.awt.Dimension(200, 10));
        jToolBar1.add(jSeparator11);

        btn_report.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_report.setText("Report");
        btn_report.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_report.setFocusable(false);
        btn_report.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_report.setPreferredSize(new java.awt.Dimension(70, 28));
        btn_report.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_reportMouseClicked(evt);
            }
        });
        btn_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_report);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jTextField_por_id.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setText("ID:");
        jLabel1.setVerifyInputWhenFocusTarget(false);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setText("Name:");

        jTextField_prdname.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jTextField_prdname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_prdnameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setText("Category:");

        jComboBox_pro_cate.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jComboBox_pro_cate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cloth", "Toy", "Drink", "Wood", "Steel", "Shoe", "Stationery", "House", "Other" }));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setText("Image");

        btn_browse.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_browse.setText("Browse");
        btn_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browseActionPerformed(evt);
            }
        });

        jLabel_iamge.setBackground(new java.awt.Color(204, 204, 204));
        jLabel_iamge.setMaximumSize(new java.awt.Dimension(100, 100));
        jLabel_iamge.setMinimumSize(new java.awt.Dimension(100, 100));
        jLabel_iamge.setOpaque(true);
        jLabel_iamge.setPreferredSize(new java.awt.Dimension(100, 100));

        jTextField_img_path.setEnabled(false);
        jTextField_img_path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_img_pathActionPerformed(evt);
            }
        });

        txt_priceofsale.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txt_priceofsale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priceofsaleActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setText("Price of Sale");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_prdname, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_por_id, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(8, 8, 8)
                        .addComponent(jComboBox_pro_cate, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_priceofsale, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(jLabel_iamge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_img_path, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btn_browse))
                .addGap(304, 304, 304))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox_pro_cate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_priceofsale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel_iamge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(btn_browse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField_img_path, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_por_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_prdname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator4)
        );

        btn_browse.getAccessibleContext().setAccessibleName("");

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1612, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 2141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // Storge
        //INSERT INTO products(name, category, image) VALUES (?, ?, ?, ?, ?);
       try {
            // Get input values
            String name = jTextField_prdname.getText().trim();
            String category = jComboBox_pro_cate.getSelectedItem() != null ? jComboBox_pro_cate.getSelectedItem().toString() : "";
            String img = jTextField_img_path.getText();
            Double priceofsale = Double.valueOf(txt_priceofsale.getText());

            // Validate inputs
            if (name.isEmpty() || category.isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "Please fill all required fields");
                return;
            }

            // Database operation
            try{
                String sql = "INSERT INTO product(name, category, image,priceofsale) VALUES (?, ?, ?,?)";
                PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
                pstmt.setString(1, name);
                pstmt.setString(2, category);
                pstmt.setString(3, img);
                pstmt.setDouble(4, priceofsale);
                

                if (pstmt.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "New Product Added Successfully");
                    showProductInTabel();
                    clearFields();
                } else {
                    System.out.println("Failed to add product");
                    JOptionPane.showMessageDialog(null, "Failed to add product");
                }
            } catch (SQLException e) {
                Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
                
            }
        } catch (HeadlessException | NumberFormatException e) {
            Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }  
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
         // remove product by ID
 
            // Get input values
            int index = jTable_products.getSelectedRow();
            Integer id = getProductsDtoList().get(index).getId();
           

            // Database operation
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String sql = "DELETE FROM product WHERE id=?;";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, id);
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure to delete this product","Remove Product",JOptionPane.YES_NO_OPTION);
                
                if (confirm == JOptionPane.YES_NO_OPTION) 
                {
                    if (ps.executeUpdate() > 0) {
                    System.out.println("Product deleted");
//                    JOptionPane.showConfirmDialog(null, "Product Deleted Successfully", "Remove Product", JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                    showProductInTabel();
                    } else {
                        JOptionPane.showConfirmDialog(null, "Product Not Delete, Make Sure The ID is valid", "Remove Product", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
            } catch (SQLException e) {
//                Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
                  JOptionPane.showConfirmDialog(null, "Product Not Delete, Make Sure The ID is valid", "Remove Product", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browseActionPerformed
        // browse to diplay image
        JFileChooser filechooser = new JFileChooser();
        filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*image","pgn","jpg","Jpeg");
        filechooser.addChoosableFileFilter(filter);
        
        if (filechooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedImage = filechooser.getSelectedFile();
            
            String ImgPath = selectedImage.getAbsolutePath();
            displayimg(ImgPath, jLabel_iamge);
            jTextField_img_path.setText(ImgPath);
            System.out.println(ImgPath);
        }
        else
        {
            System.out.println("No File Selected");
        }
       
    }//GEN-LAST:event_btn_browseActionPerformed

    private void btn_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateMouseClicked
        //update or edit product
        try {
            // Get input values
            Integer id = Integer.valueOf(jTextField_por_id.getText());
            String name = jTextField_prdname.getText().trim();
            String category = jComboBox_pro_cate.getSelectedItem() != null ? jComboBox_pro_cate.getSelectedItem().toString() : "";
            String image = jTextField_img_path.getText();
            Double priceofsale = Double.valueOf(txt_priceofsale.getText());

            // Validate inputs
            if (name.isEmpty() || category.isEmpty()) {
                System.out.println("Please fill all required fields");
                return;
            }
            // Database operation
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String sql = "UPDATE product SET name=?, category=?, image=?,priceofsale=? WHERE id=?;";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, category);
                ps.setString(3, image);
                ps.setDouble(4, priceofsale);
                ps.setInt(5, id);

                if (ps.executeUpdate() > 0) {
                    System.out.println("Product Updated");
                    showKhmerMessageDialog(null, "ផលិតផលបានធ្វើបច្ចុប្បន្នភាពជោគជ័យ!", "ជោគជ័យ", JOptionPane.INFORMATION_MESSAGE);
                    showProductInTabel();
                    clearFields();
                    btn_edit.setVisible(true);
                    btn_update.setVisible(false);
                    setEnabled_btn_true();
                } else {
                    System.out.println("Failed to Updated Product");
                    JOptionPane.showMessageDialog(null, "Failed to Updated Product");
                }
            } catch (SQLException e) {
                Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
            }
        } catch (Exception e) {
            Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
            
        }  
    }//GEN-LAST:event_btn_updateMouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
       
      
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void jTable_productsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productsMouseClicked
//        // display the select product to info
        int index = jTable_products.getSelectedRow();
 
        position = index;
    }//GEN-LAST:event_jTable_productsMouseClicked

    private void btn_lastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lastMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_lastMouseClicked

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
//        // show and select last recode:
        position = getProductsDtoList().size()-1;
   
        jTable_products.setRowSelectionInterval(position, position);
    }//GEN-LAST:event_btn_lastActionPerformed

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
//        // show and select first recode:
        position = 0;
        showProductData(position);
        jTable_products.setRowSelectionInterval(position, position);
    }//GEN-LAST:event_btn_firstActionPerformed

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
       
        jTable_products.setRowSelectionInterval(position, position);
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nextMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nextMouseClicked

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        // show and select next recode:
        position ++;
        if(position > getProductsDtoList().size()-1)
        {
            position = getProductsDtoList().size()-1;
            JOptionPane.showMessageDialog(null, "អស់ហើយចុចអីទៀត");
        }
      
        jTable_products.setRowSelectionInterval(position, position);
    }//GEN-LAST:event_btn_nextActionPerformed

    private void jTextField_prdnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_prdnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_prdnameActionPerformed

    private void jTextField_img_pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_img_pathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_img_pathActionPerformed

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_editMouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        //Edit
        int index = jTable_products.getSelectedRow();
        if(index == jTable_products.getSelectedRow()){
            showProductData(index);
            btn_edit.setVisible(false);
            btn_update.setVisible(true);
            setEnabled_btn_false();
            
        }
        
    }//GEN-LAST:event_btn_editActionPerformed

    private void txt_priceofsaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceofsaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceofsaleActionPerformed

    private void btn_reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_reportMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_reportMouseClicked

    private void btn_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportActionPerformed
        productReport rvR = new productReport(null, true);
        rvR.setTitle("Product Report");
        rvR.setVisible(true);
    }//GEN-LAST:event_btn_reportActionPerformed

    @SuppressWarnings("deprecation")
    private void btn_adjust_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adjust_priceActionPerformed
        int index = jTable_products.getSelectedRow();
        int select_id = getProductsDtoList().get(index).getId();
        Adjust_price_dialog  ajpd = new Adjust_price_dialog(null,select_id);
            if(index == jTable_products.getSelectedRow()){
                System.out.println(select_id);
                ajpd.setVisible(true);
                
            }
            
       
    }//GEN-LAST:event_btn_adjust_priceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_adjust_price;
    private javax.swing.JButton btn_browse;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_prev;
    private javax.swing.JButton btn_report;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> jComboBox_pro_cate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_iamge;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable_products;
    private javax.swing.JTextField jTextField_img_path;
    private javax.swing.JTextField jTextField_por_id;
    private javax.swing.JTextField jTextField_prdname;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txt_priceofsale;
    // End of variables declaration//GEN-END:variables
}
