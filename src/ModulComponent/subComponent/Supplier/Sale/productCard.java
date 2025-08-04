package ModulComponent.subComponent.Supplier.Sale;
import Logic.SaleReport;
import ModulComponent.subComponent.Supplier.Sale.InvoicePanel;
import Logic.product;

import javax.swing.*;
import java.awt.*;
import static java.awt.Adjustable.HORIZONTAL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class productCard extends javax.swing.JPanel {

    private static final long serialVersionUID  = 1L;
    public Integer product_id;
    public String name;
    public String category;
    public Double price;
    public String image;
   
    private JLabel product_id_Label;
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JLabel categoryLabel;
    private JSpinner quantitySpinner;
    private static final Invoice invoice = Invoice.getInstance();
    private static JButton btnGenerateInvoiceAfterAdd;

    public productCard() {

       initComponents();
       
       
    }
   
    public productCard(int product_id,String name,String category,Double price,String image) {
       
        initComponents();
        this.product_id = product_id;
        this.name = name;
        this.category= category;
        this.price=price;
        this.image=image;
      
        
        jLabel_nameshow.setText(name);
        jLabel_cateshow.setText(category);
        jLabel_priceshow.setText(String.format("%.2f", price));
        jLabel_image.setText(image);
           
        
        
    }public Integer getProduct_id() {
        return product_id;
    }
    
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public JPanel createCardPanel() {
        
        JPanel cardPanel = new JPanel();
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        cardPanel.setBackground(Color.white);
        
        
        //Image Style
        JLabel imageLabel = new JLabel("Image");
        imageLabel.setPreferredSize(new Dimension(245, 250));
//        imageLabel.setBorder(BorderFactory.createLineBorader(Color.GRAY));
        imageLabel.setFont(new java.awt.Font("Century Gothic", 0, 14));
        imageLabel.setForeground(new java.awt.Color(0, 0, 0));
        imageLabel.setText(image);
        try {
            File imageFile = new File(image);
            if (imageFile.exists()) {
                ImageIcon icon = new ImageIcon(image);
                // Optional: Scale the image to fit the JLabel
                Image scaledImage = icon.getImage().getScaledInstance(245, 200, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaledImage));
                imageLabel.setText(""); // Remove text if only image is needed
            } else {
                imageLabel.setText("Image not found");
            }
        } catch (Exception e) {
            imageLabel.setText("Error loading image");
            e.printStackTrace();
        }
         imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
         cardPanel.add(imageLabel);
       

        product_id_Label = new JLabel("Product ID" + product_id);
        product_id_Label.setFont(new java.awt.Font("Century Gothic", 0, 14)); 
        product_id_Label.setForeground(new java.awt.Color(0, 0, 0));
        product_id_Label.setPreferredSize(new Dimension(200,20));
        //name Style
        nameLabel = new JLabel("Name: " + name);
        nameLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); 
        nameLabel.setForeground(new java.awt.Color(0, 0, 0));
        nameLabel.setPreferredSize(new Dimension(200,20));
      
        cardPanel.add(nameLabel);
        
        //Price Style
        priceLabel = new JLabel("Price: $" + price);
        priceLabel.setFont(new java.awt.Font("Century Gothic", 0, 14));
        priceLabel.setForeground(new java.awt.Color(0, 0, 0));
        priceLabel.setPreferredSize(new Dimension(200,20));
       
        cardPanel.add(priceLabel);

        
        //Category Style
        categoryLabel = new JLabel("Category: " + category);
        categoryLabel.setFont(new java.awt.Font("Century Gothic", 0, 14));
        categoryLabel.setForeground(new java.awt.Color(0, 0, 0));
        categoryLabel.setPreferredSize(new Dimension(200,20));
        
        cardPanel.add(categoryLabel);
        
        
        //Quantity Style
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setFont(new java.awt.Font("Century Gothic", 0, 14));
        quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 0, 100, 1));
        quantitySpinner.setFont(new java.awt.Font("Century Gothic", 0, 14));
        quantitySpinner.setForeground(new java.awt.Color(0, 0, 0));
        quantitySpinner.setPreferredSize(new Dimension(85,35));
      
        JPanel quantityPanel = new JPanel();   
        quantityPanel.setBackground(Color.white);
        quantityPanel.add(quantityLabel);
        quantityPanel.add(quantitySpinner);
       
        cardPanel.add(quantityPanel);
        
        // Button Add to Invoice
        
        JButton btnAdd = new JButton("Add");
        btnAdd.setFont(new java.awt.Font("Century Gothic", 0, 14));
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedQuantity = (Integer) quantitySpinner.getValue();
                if (selectedQuantity > 0) {
                    invoice.addProduct(new Invoice.InvoiceItem(product_id,name, price, selectedQuantity));                   
                    JOptionPane.showMessageDialog(cardPanel,
                            selectedQuantity + " x " + name + " added to invoice.",
                            "Added to Invoice", JOptionPane.INFORMATION_MESSAGE);
                   
                } else {
                    JOptionPane.showMessageDialog(cardPanel,
                            "Please select a quantity greater than 0.",
                            "Invalid Quantity", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        cardPanel.add(btnAdd);
     
        return cardPanel;
 
    }
    private static void updateGenerateInvoiceButton() {
        if (btnGenerateInvoiceAfterAdd == null) {
            btnGenerateInvoiceAfterAdd = new JButton("Generate Invoice");
            btnGenerateInvoiceAfterAdd.setFont(new java.awt.Font("Century Gothic", 0, 14));
            btnGenerateInvoiceAfterAdd.addActionListener(e -> {
                if (invoice.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "No items in the invoice. Please add products first.",
                            "Empty Invoice", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Display invoice in a dialog
                JTextArea invoiceTextArea = new JTextArea(invoice.generateInvoice(), 20, 50);
                invoiceTextArea.setEditable(false);
                invoiceTextArea.setFont(new java.awt.Font("Monospaced", 0, 12));
                JScrollPane scrollPane = new JScrollPane(invoiceTextArea);

                JOptionPane.showMessageDialog(null,
                        scrollPane,
                        "Invoice",
                        JOptionPane.INFORMATION_MESSAGE);

                // Save invoice to file
                try {
                    invoice.saveToFile("invoice.txt");
                    JOptionPane.showMessageDialog(null,
                            "Invoice saved to invoice.txt",
                            "Invoice Saved", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Error saving invoice: " + ex.getMessage(),
                            "Save Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            });
        }
        btnGenerateInvoiceAfterAdd.setEnabled(!invoice.isEmpty());
    }
   
   

    
   
    
   
   
    
    
  
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_name = new javax.swing.JLabel();
        jLabel_cate = new javax.swing.JLabel();
        jLabel_price = new javax.swing.JLabel();
        jLabel_image = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel_nameshow = new javax.swing.JLabel();
        jLabel_priceshow = new javax.swing.JLabel();
        jLabel_cateshow = new javax.swing.JLabel();
        jLabel_qty = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setForeground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(0, 0));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(210, 210));

        jLabel_name.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_name.setText("Name :");

        jLabel_cate.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_cate.setText("Category:");

        jLabel_price.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_price.setText("Price:");

        jLabel_image.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_image.setText("Image");

        jSeparator1.setAlignmentX(100.0F);
        jSeparator1.setAlignmentY(100.0F);
        jSeparator1.setDoubleBuffered(true);

        jLabel_nameshow.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_nameshow.setText("Name");

        jLabel_priceshow.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_priceshow.setText("Price");

        jLabel_cateshow.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_cateshow.setText("Category");

        jLabel_qty.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_qty.setText("Quantiry:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_qty)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(76, 76, 76)
                            .addComponent(jLabel_image))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel_cate)
                                .addComponent(jLabel_price)
                                .addComponent(jLabel_name))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel_nameshow)
                                .addComponent(jLabel_priceshow)
                                .addComponent(jLabel_cateshow)))))
                .addGap(0, 56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel_image)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_name)
                    .addComponent(jLabel_nameshow))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_price)
                    .addComponent(jLabel_priceshow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_cate)
                    .addComponent(jLabel_cateshow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_qty)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_cate;
    private javax.swing.JLabel jLabel_cateshow;
    private javax.swing.JLabel jLabel_image;
    private javax.swing.JLabel jLabel_name;
    private javax.swing.JLabel jLabel_nameshow;
    private javax.swing.JLabel jLabel_price;
    private javax.swing.JLabel jLabel_priceshow;
    private javax.swing.JLabel jLabel_qty;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables

   
   
 
    
   
}
