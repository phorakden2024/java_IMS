
package ModulComponent;
import Logic.product;
import java.awt.*;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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






public class ProductModul extends javax.swing.JPanel {

    private static final String url = "jdbc:postgresql://localhost:5432/Inventory"; // Replace with your DB details
    private static final String user = "postgres"; // Replace with your DB username
    private static final String password = "dan@12345"; // Replace with your DB password

    Border textField_border = BorderFactory.createMatteBorder(0,0,2,0,Color.DARK_GRAY);
    int position = 0;
    public ProductModul() {
        initComponents();
        showProductInTabel();
       
        jTextField_prdname.setBorder(textField_border);
        jTextField_por_id.setBorder(textField_border);
        jTextField_proqty.setBorder(textField_border);
        jTextField_proprice.setBorder(textField_border);
        jTextField_img_path.setBorder(textField_border);
    }
    
    // function that return an array list
    public ArrayList<product> getProductsList()
    {
        ArrayList<product> list = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM products ORDER BY id DESC;";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            product Product;
            while (rs.next()) {                
                Product = new product(
                        rs.getInt("id"), 
                        rs.getString("name"), 
                        rs.getString("category"), 
                        rs.getInt("quantity"), 
                        rs.getDouble("price"), 
                        rs.getString("image"));
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
        ArrayList<product> productsList = getProductsList();
        DefaultTableModel model = (DefaultTableModel) jTable_products.getModel();
        model.setRowCount(0);
        Object[] row = new Object[6];
        
        for( int i = 0;i < productsList.size();i++)
        {
            row[0] = productsList.get(i).getId();
            row[1] = productsList.get(i).getName();
            row[2] = productsList.get(i).getCatagory();
            row[3] = productsList.get(i).getQuantity();
            row[4] = productsList.get(i).getPrice();
            row[5] = productsList.get(i).getImage();
            
            model.addRow(row);
            
        }
    }
    //funnction show data from database into textbox
    public void showProductData(int index)
    {
        jTextField_por_id.setText(String.valueOf(getProductsList().get(index).getId()));
        jTextField_prdname.setText(getProductsList().get(index).getName());
        jComboBox_pro_cate.setSelectedItem(getProductsList().get(index).getCatagory());
        jTextField_proqty.setText(getProductsList().get(index).getQuantity().toString());
        jTextField_proprice.setText(getProductsList().get(index).getPrice().toString());
        jTextField_img_path.setText(getProductsList().get(index).getImage());
        displayimg(getProductsList().get(index).getImage(), jLabel_iamge);
        
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
        jTextField_proqty.setText("");
        jTextField_proprice.setText("");
        jTextField_img_path.setText("");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_por_id = new javax.swing.JTextField();
        jTextField_prdname = new javax.swing.JTextField();
        jTextField_proprice = new javax.swing.JTextField();
        jTextField_proqty = new javax.swing.JTextField();
        jComboBox_pro_cate = new javax.swing.JComboBox<>();
        jLabel_iamge = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();
        btn_remove1 = new javax.swing.JButton();
        jTextField_img_path = new javax.swing.JTextField();
        btn_last = new javax.swing.JButton();
        btn_first = new javax.swing.JButton();
        btn_prev = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jTable_products.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable_products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Category", "Quantity", "Price", "Image"
            }
        ));
        jTable_products.setRowHeight(50);
        jTable_products.setSelectionBackground(new java.awt.Color(168, 168, 168));
        jTable_products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_products);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setText("ID:");
        jLabel1.setVerifyInputWhenFocusTarget(false);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel2.setText("Create Product");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setText("Category:");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setText("Quantuty:");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setText("Image");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setText("Price:");

        jTextField_por_id.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jTextField_prdname.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jTextField_proprice.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jTextField_proprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_propriceKeyReleased(evt);
            }
        });

        jTextField_proqty.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jTextField_proqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_proqtyKeyTyped(evt);
            }
        });

        jComboBox_pro_cate.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jComboBox_pro_cate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cloth", "Toy", "Drink", "Wood", "Steel", "Shoe", "Stationery", "House", "Other" }));

        jLabel_iamge.setBackground(new java.awt.Color(204, 204, 204));
        jLabel_iamge.setMaximumSize(new java.awt.Dimension(100, 100));
        jLabel_iamge.setMinimumSize(new java.awt.Dimension(100, 100));
        jLabel_iamge.setOpaque(true);
        jLabel_iamge.setPreferredSize(new java.awt.Dimension(100, 100));

        btn_add.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_update.setText("Update");
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

        btn_remove.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_remove.setText("Remove");
        btn_remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_removeMouseClicked(evt);
            }
        });
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });

        btn_remove1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_remove1.setText("Browse");
        btn_remove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_remove1ActionPerformed(evt);
            }
        });

        jTextField_img_path.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_img_path.setEnabled(false);

        btn_last.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_last.setText("Last");
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

        btn_first.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_first.setText("First");
        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });

        btn_prev.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_prev.setText("Prev");
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

        btn_next.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btn_next.setText("Next");
        btn_next.setMinimumSize(new java.awt.Dimension(56, 31));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_remove1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_por_id)
                                    .addComponent(jTextField_prdname)
                                    .addComponent(jTextField_proqty)
                                    .addComponent(jTextField_proprice)
                                    .addComponent(jComboBox_pro_cate, 0, 198, Short.MAX_VALUE)
                                    .addComponent(jLabel_iamge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_remove))
                                .addComponent(jTextField_img_path, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_por_id, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_prdname, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox_pro_cate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_proqty, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_proprice, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_remove1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel_iamge, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_img_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // add new propuect
        //INSERT INTO products(name, category, price, image) VALUES (?, ?, ?, ?, ?);
       try {
            // Get input values
            String name = jTextField_prdname.getText().trim();
            String category = jComboBox_pro_cate.getSelectedItem() != null ? jComboBox_pro_cate.getSelectedItem().toString() : "";
            String qtyText = jTextField_proqty.getText().trim();
            String priceText = jTextField_proprice.getText().trim();
            String img = jTextField_img_path.getText();
            

            // Validate inputs
            if (name.isEmpty() || category.isEmpty() || qtyText.isEmpty() || priceText.isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "Please fill all required fields");
                return;
            }

            // Parse numeric inputs with error handling
            Integer quantity;
            Double price;
            try {
                quantity = Integer.valueOf(qtyText);
                price = Double.valueOf(priceText);
            } catch (NumberFormatException e) {
                System.out.println("Quantity and Price must be valid numbers");
                return;
            }

            // Database operation
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String sql = "INSERT INTO products(name, category, quantity, price, image) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, category);
                ps.setInt(3, quantity);
                ps.setDouble(4, price);
                ps.setString(5, img);

                if (ps.executeUpdate() > 0) {
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
        } catch (Exception e) {
            Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
        }  
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_removeActionPerformed

    private void btn_remove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_remove1ActionPerformed
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
       
    }//GEN-LAST:event_btn_remove1ActionPerformed

    private void btn_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateMouseClicked
        //update or edit product
        try {
            // Get input values
            Integer id = Integer.valueOf(jTextField_por_id.getText());
            String name = jTextField_prdname.getText().trim();
            String category = jComboBox_pro_cate.getSelectedItem() != null ? jComboBox_pro_cate.getSelectedItem().toString() : "";
            String qtyText = jTextField_proqty.getText().trim();
            String priceText = jTextField_proprice.getText().trim();
            String img = jTextField_img_path.getText();

            // Validate inputs
            if (name.isEmpty() || category.isEmpty() || qtyText.isEmpty() || priceText.isEmpty()) {
                System.out.println("Please fill all required fields");
                return;
            }

            // Parse numeric inputs with error handling
            Integer quantity;
            Double price;
            try {
                quantity = Integer.valueOf(qtyText);
                price = Double.valueOf(priceText);
            } catch (NumberFormatException e) {
                System.out.println("Quantity and Price must be valid numbers");
                return;
            }

            // Database operation
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String sql = "UPDATE products SET name=?, category=?, quantity=?, price=?, image=? WHERE id=?;";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, category);
                ps.setInt(3, quantity);
                ps.setDouble(4, price);
                ps.setString(5, img);
                ps.setInt(6, id);

                if (ps.executeUpdate() > 0) {
                    System.out.println("Product Updated");
                    JOptionPane.showMessageDialog(null, "Product Updated Successfully");
                    showKhmerMessageDialog(null, "ផលិតផលបានធ្វើបច្ចុប្បន្នភាពជោគជ័យ!", "ជោគជ័យ", JOptionPane.INFORMATION_MESSAGE);
                    showProductInTabel();
                    clearFields();
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

    private void btn_removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_removeMouseClicked
        // remove product by ID
 
            // Get input values
            Integer id = Integer.valueOf(jTextField_por_id.getText());

            // Database operation
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String sql = "DELETE FROM products WHERE id=?;";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, id);
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure to delete this product","Remove Product",JOptionPane.YES_NO_OPTION);
                
                if (confirm == JOptionPane.YES_NO_OPTION) 
                {
                    if (ps.executeUpdate() > 0) {
                    System.out.println("Product deleted");
                    JOptionPane.showConfirmDialog(null, "Product Deleted Successfully", "Remove Product", JOptionPane.INFORMATION_MESSAGE);
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
      
    }//GEN-LAST:event_btn_removeMouseClicked

    private void jTable_productsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productsMouseClicked
        // display the select product to info
        int index = jTable_products.getSelectedRow();
        showProductData(index);
        position = index;
    }//GEN-LAST:event_jTable_productsMouseClicked

    private void btn_lastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lastMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_lastMouseClicked

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        // show and select last recode:
        position = getProductsList().size()-1;
        showProductData(position);
        jTable_products.setRowSelectionInterval(position, position);
    }//GEN-LAST:event_btn_lastActionPerformed

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        // show and select first recode:
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
        showProductData(position);
        jTable_products.setRowSelectionInterval(position, position);
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nextMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nextMouseClicked

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        // show and select next recode:
        position ++;
        if(position > getProductsList().size()-1)
        {
            position = getProductsList().size()-1;
            JOptionPane.showMessageDialog(null, "អស់ហើយចុចអីទៀត");
        }
        showProductData(position);
        jTable_products.setRowSelectionInterval(position, position);
    }//GEN-LAST:event_btn_nextActionPerformed

    private void jTextField_proqtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_proqtyKeyTyped
        // allow only number input
        if(!Character.isDigit(evt.getKeyChar()))
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_proqtyKeyTyped

    private void jTextField_propriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_propriceKeyReleased
        // allow double
        try {
            Double.valueOf(jTextField_proprice.getText());
        } catch (NumberFormatException ex) {
            System.out.println( ex.getMessage());
            jTextField_proprice.setText("");
        }
    }//GEN-LAST:event_jTextField_propriceKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_prev;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_remove1;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> jComboBox_pro_cate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_iamge;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable_products;
    private javax.swing.JTextField jTextField_img_path;
    private javax.swing.JTextField jTextField_por_id;
    private javax.swing.JTextField jTextField_prdname;
    private javax.swing.JTextField jTextField_proprice;
    private javax.swing.JTextField jTextField_proqty;
    // End of variables declaration//GEN-END:variables
}
