package ModulComponent;

import DAO.ExspenseDao;
import DAO.IncomeDao;
import DAO.OrderDao;
import DAO.StockDetailDao;
import DAO.invoiceAmounttodayDao;
import DAO.sum_totalAmountDao;
import DTO.ExspenseDto;
import DTO.IncomeDto;
import DTO.Invoice_list;
import DTO.OrderDto;
import DTO.sum_invoiceAmounttoday;
import DTO.sum_totalAmount;
import Database.DatabaseConfig;
import Product_Component.ProductModul;
import Logic.InvoiceDB;
import Logic.SumProduct;
import Logic.product;
import Logic.pruchse;
import Logic.subtotal;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    ExspenseDao exspensesDao = new ExspenseDao();
    IncomeDao incomeDao = new IncomeDao();
    sum_totalAmountDao totalRevenue = new sum_totalAmountDao();
    invoiceAmounttodayDao dailyRevenue = new invoiceAmounttodayDao();
    StockDetailDao sumProduct = new StockDetailDao();
    OrderDao orderDao  = new OrderDao();

    public HomeModul() throws Exception {
        initComponents();
        controllBox();
        showInTabelRevenur();
        getOrderTable();
        
        List<ExspenseDto> result = exspensesDao.loadExspense();
        this.showIncomeTable(result);

        // Create the desired font for the header
        JTableHeader header = tbl_revenue.getTableHeader();
        Font headerFont = new Font("Century Gothic", Font.BOLD, 14); // Example: Bold, Size 14
        header.setFont(headerFont);
        JTableHeader header1 = tbl_exspenses.getTableHeader();
        Font headerFont1 = new Font("Century Gothic", Font.BOLD, 14); // Example: Bold, Size 14
        header1.setFont(headerFont1);
        JTableHeader header2 = tbl_order.getTableHeader();
        Font headerFont2 = new Font("Century Gothic", Font.BOLD, 14); // Example: Bold, Size 14
        header2.setFont(headerFont2);
    }
    // function show product in table

    public void controllBox() throws Exception {
        //Box1
        //setBackgroundPenel
        Color color1 = Color.decode("#89CFF3");
        Color color2 = Color.decode("#A0E9FF");
        jPanel9.setBackground(color1);
        jPanel10.setBackground(color2);
        jPanel11.setBackground(color2);

        //SetText
        jLabelExspenses.setText("Exspenses");
        List<ExspenseDto> sumTotalExspense = exspensesDao.totalExspense();
        jLabel2.setText(String.valueOf(sumTotalExspense.get(0).getTotalExspenses()) + "$");
        jLabel3.setText("Total Exspenses");
        //Box2
        //setBackgroundPenel
        Color color3 = Color.decode("#748E63");
        Color color4 = Color.decode("#99B080");
        jPanel12.setBackground(color3);
        jPanel13.setBackground(color4);
        jPanel14.setBackground(color4);
        //SetText
        jLabel4.setText("Income");
        List<IncomeDto> getTotalIncomeOfProduct = incomeDao.getIncomeOfProdeuct();
        jLabel5.setText(String.valueOf(getTotalIncomeOfProduct.get(0).getIncome_of_produect() + "$"));
        jLabel6.setText("Total Income");
        //Box3
        Color color5 = Color.decode("#B3A492");
        Color color6 = Color.decode("#D6C7AE");
        jPanel15.setBackground(color5);
        jPanel16.setBackground(color6);
        jPanel17.setBackground(color6);
        //SetText
        jLabel7.setText("Revenue");
        List<sum_totalAmount> sum_totalAmount = totalRevenue.sum_totalAmountDto();
        jLabel8.setText(String.valueOf(sum_totalAmount.get(0).getInvoiceAmountTotal()) + "$");
        jLabel9.setText("Total Revenue");
        //Box4
        Color color7 = Color.decode("#FFD966");
        Color color8 = Color.decode("#FEFF86");
        jPanel18.setBackground(color7);
        jPanel19.setBackground(color8);
        jPanel20.setBackground(color8);
        //SetText
        jLabel10.setText("Product Cost");
        List<IncomeDto> totalProductCode = incomeDao.getTotalProdeuctCost();
        jLabel11.setText(String.valueOf(totalProductCode.get(0).getTotal_productCost()) + "$");

        jLabel12.setText("Total Product Cost");
        //Box5
        Color color9 = Color.decode("#95BDFF");
        Color color10 = Color.decode("#B4E4FF");
        jPanel21.setBackground(color9);
        jPanel22.setBackground(color10);
        jPanel23.setBackground(color10);
        //SetText
        jLabel13.setText("Daily Revenue");
        List<sum_invoiceAmounttoday> sum_amount_today = dailyRevenue.sum_invoiceTAmounttodaysDto();
        jLabel14.setText(String.valueOf(sum_amount_today.get(0).getInvoiceAmounttoday() + "$"));
        jLabel15.setText("Total Daily Revenue");
        //Box6
        Color color11 = Color.decode("#C0DEFF");
        Color color12 = Color.decode("#8EA7E9");
        Color color13 = Color.decode("#A555EC");
        Color color14 = Color.decode("#A5F1E9");
        jPanel24.setBackground(color11);
        jPanel2.setBackground(color12);
        jPanel5.setBackground(color12);
        jPanel3.setBackground(color13);
        jPanel6.setBackground(color13);
        jPanel4.setBackground(color14);
        jPanel7.setBackground(color14);
        //SetText
        jLabel16.setText("Stock Detail");

        jLabel17.setText("Stock IN");

        jLabel20.setText(String.valueOf(sumProduct.countStockin().getCount_Stockin()));

        jLabel18.setText("Stock OUT");

        jLabel21.setText(String.valueOf(sumProduct.countStockout().getCount_Stockout()));

        jLabel19.setText("Aavailable");

        jLabel22.setText(String.valueOf(sumProduct.countAvailable().getCount_AvaiProduct()));

    }

    public ArrayList<InvoiceDB> getInvoiceList() {
        ArrayList<InvoiceDB> invoice_list = new ArrayList<>();
        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "select iit.item_id, \n"
                    + "iit.invoice_id,\n"
                    + "product_name,\n"
                    + "iit.price,\n"
                    + "iit.quantity,\n"
                    + "iit.subtotal,\n"
                    + "inv.invoice_date\n"
                    + "from invoice_items  iit\n"
                    + "Left join invoices inv on inv.invoice_id = iit.invoice_id\n"
                    + "ORDER BY iit.item_id DESC;";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Integer item_id = rs.getInt("item_id");
                Integer invoice_id = rs.getInt("invoice_id");
                String product_name = rs.getString("product_name");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
                Double subtotal = rs.getDouble("subtotal");
                Date invoice_date = rs.getDate("invoice_date");
                invoice_list.add(new InvoiceDB(item_id, invoice_id, product_name, price, quantity, subtotal, invoice_date));
            }
        } catch (Exception e) {
            Logger.getLogger(SupplierModul.class.getName()).log(Level.SEVERE, null, e);
        }
        return invoice_list;
    }

    public List<Invoice_list> getDataInvoice_listDto() {
        List<Invoice_list> list = new ArrayList<>();
        try {
            String sql = "SELECT invoice_id, invoice_date, total_amount FROM public.invoices ORDER BY invoice_id DESC ";
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            Invoice_list getdata;
            while (rs.next()) {
                getdata = new Invoice_list(
                        rs.getInt("invoice_id"),
                        rs.getDate("invoice_date"),
                        rs.getDouble("total_amount"));
                list.add(getdata);
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public void showInTabelRevenur() {
        List<Invoice_list> invoice_List = getDataInvoice_listDto();
        DefaultTableModel model = (DefaultTableModel) tbl_revenue.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];

        for (int i = 0; i < invoice_List.size(); i++) {
            row[0] = "INV" + invoice_List.get(i).getInvoice_id();
            row[1] = invoice_List.get(i).getInvoice_date();
            row[2] = "$" + invoice_List.get(i).getTotal_amount();
            model.addRow(row);

        }
    }
     public void showIncomeTable( List<ExspenseDto> Exspense) {
        //insert into jtable
        DefaultTableModel tbl = (DefaultTableModel) this.tbl_exspenses.getModel();
        tbl.setRowCount(0);//clear
        for (ExspenseDto dto : Exspense) {
            tbl.addRow(new Object[]{dto.getExspense_date(), dto.getExspense_purpose(),dto.getTotal()+"$"});
        }
        if (tbl.getRowCount() > 0) {
            this.tbl_exspenses.setRowSelectionInterval(0, 0);
        }
    }
    public ArrayList<pruchse> getpruchse() {
        ArrayList<pruchse> purPro = new ArrayList<>();
        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT SUM(quantity) AS qtyOfsale FROM invoice_items  ;";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer total_quantity = rs.getInt("qtyOfsale");
                purPro.add(new pruchse(total_quantity));
            }

        } catch (Exception e) {
            Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
        }
        return purPro;
    }


    public ArrayList<subtotal> getsubtotal() {
        ArrayList<subtotal> subtotal = new ArrayList<>();
        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT SUM(subtotal) as subtotal FROM invoice_items;";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Double subtotal1 = rs.getDouble("subtotal");
                subtotal.add(new subtotal(subtotal1));
            }

        } catch (Exception e) {
            Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
        }
        return subtotal;
    }
    public void getOrderTable() throws Exception {
        List<OrderDto> getDataOrderTable = orderDao.getOrdertable();
        DefaultTableModel tbl = (DefaultTableModel) this.tbl_order.getModel();
        tbl.setRowCount(0);//clear
        for (OrderDto orderDto : getDataOrderTable) {
            tbl.addRow(new Object[]{
                orderDto.getOrder_date(),
                orderDto.getProduct_name(),
                orderDto.getQuantity(),
                orderDto.getStatus()});
            if (tbl.getRowCount() > 0) {
                this.tbl_order.setRowSelectionInterval(0, 0);
            }
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanelBox1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabelExspenses = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanelBox2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanelBox3 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanelBox4 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanelBox5 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanelBox6 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_revenue = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_exspenses = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_order = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(800, 800));
        setPreferredSize(new java.awt.Dimension(800, 800));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(2, 0));

        jPanelBox1.setBackground(new java.awt.Color(204, 204, 255));
        jPanelBox1.setLayout(new java.awt.GridLayout(3, 0));

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));

        jLabelExspenses.setFont(new java.awt.Font("Geist Mono", 0, 30)); // NOI18N
        jLabelExspenses.setText("N");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelExspenses)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelExspenses)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBox1.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 0, 102));
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Geist Mono", 0, 30)); // NOI18N
        jLabel2.setText("N");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel10.add(jLabel2, gridBagConstraints);

        jPanelBox1.add(jPanel10);

        jPanel11.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel3.setText("N");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel11.add(jLabel3, gridBagConstraints);

        jPanelBox1.add(jPanel11);

        jPanel1.add(jPanelBox1);

        jPanelBox2.setBackground(new java.awt.Color(204, 204, 255));
        jPanelBox2.setLayout(new java.awt.GridLayout(3, 0));

        jPanel12.setBackground(new java.awt.Color(204, 204, 255));

        jLabel4.setFont(new java.awt.Font("Geist Mono", 0, 30)); // NOI18N
        jLabel4.setText("N");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBox2.add(jPanel12);

        jPanel13.setBackground(new java.awt.Color(255, 0, 102));
        jPanel13.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Geist Mono", 0, 30)); // NOI18N
        jLabel5.setText("N");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel13.add(jLabel5, gridBagConstraints);

        jPanelBox2.add(jPanel13);

        jPanel14.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel6.setText("N");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel14.add(jLabel6, gridBagConstraints);

        jPanelBox2.add(jPanel14);

        jPanel1.add(jPanelBox2);

        jPanelBox3.setBackground(new java.awt.Color(204, 204, 255));
        jPanelBox3.setLayout(new java.awt.GridLayout(3, 0));

        jPanel15.setBackground(new java.awt.Color(204, 204, 255));

        jLabel7.setFont(new java.awt.Font("Geist Mono", 0, 30)); // NOI18N
        jLabel7.setText("N");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBox3.add(jPanel15);

        jPanel16.setBackground(new java.awt.Color(255, 0, 102));
        jPanel16.setLayout(new java.awt.GridBagLayout());

        jLabel8.setFont(new java.awt.Font("Geist Mono", 0, 30)); // NOI18N
        jLabel8.setText("N");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel16.add(jLabel8, gridBagConstraints);

        jPanelBox3.add(jPanel16);

        jPanel17.setLayout(new java.awt.GridBagLayout());

        jLabel9.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel9.setText("N");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel17.add(jLabel9, gridBagConstraints);

        jPanelBox3.add(jPanel17);

        jPanel1.add(jPanelBox3);

        jPanelBox4.setBackground(new java.awt.Color(204, 204, 255));
        jPanelBox4.setLayout(new java.awt.GridLayout(3, 0));

        jPanel18.setBackground(new java.awt.Color(204, 204, 255));

        jLabel10.setFont(new java.awt.Font("Geist Mono", 0, 30)); // NOI18N
        jLabel10.setText("N");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBox4.add(jPanel18);

        jPanel19.setBackground(new java.awt.Color(255, 0, 102));
        jPanel19.setLayout(new java.awt.GridBagLayout());

        jLabel11.setFont(new java.awt.Font("Geist Mono", 0, 30)); // NOI18N
        jLabel11.setText("N");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel19.add(jLabel11, gridBagConstraints);

        jPanelBox4.add(jPanel19);

        jPanel20.setLayout(new java.awt.GridBagLayout());

        jLabel12.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel12.setText("N");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel20.add(jLabel12, gridBagConstraints);

        jPanelBox4.add(jPanel20);

        jPanel1.add(jPanelBox4);

        jPanelBox5.setBackground(new java.awt.Color(204, 204, 255));
        jPanelBox5.setLayout(new java.awt.GridLayout(3, 0));

        jPanel21.setBackground(new java.awt.Color(204, 204, 255));

        jLabel13.setFont(new java.awt.Font("Geist Mono", 0, 30)); // NOI18N
        jLabel13.setText("N");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBox5.add(jPanel21);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setLayout(new java.awt.GridBagLayout());

        jLabel14.setFont(new java.awt.Font("Geist Mono", 0, 30)); // NOI18N
        jLabel14.setText("N");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel22.add(jLabel14, gridBagConstraints);

        jPanelBox5.add(jPanel22);

        jPanel23.setLayout(new java.awt.GridBagLayout());

        jLabel15.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel15.setText("N");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel23.add(jLabel15, gridBagConstraints);

        jPanelBox5.add(jPanel23);

        jPanel1.add(jPanelBox5);

        jPanelBox6.setBackground(new java.awt.Color(204, 204, 255));
        jPanelBox6.setLayout(new java.awt.GridLayout(3, 0));

        jPanel24.setBackground(new java.awt.Color(204, 204, 255));

        jLabel16.setFont(new java.awt.Font("Geist Mono", 0, 30)); // NOI18N
        jLabel16.setText("N");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel16)
                .addContainerGap(176, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(14, 14, 14))
        );

        jPanelBox6.add(jPanel24);

        jPanel25.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel17.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel17.setText("N");
        jPanel2.add(jLabel17, new java.awt.GridBagConstraints());

        jPanel25.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel18.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel18.setText("N");
        jPanel3.add(jLabel18, new java.awt.GridBagConstraints());

        jPanel25.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(153, 255, 204));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel19.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel19.setText("N");
        jPanel4.add(jLabel19, new java.awt.GridBagConstraints());

        jPanel25.add(jPanel4);

        jPanelBox6.add(jPanel25);

        jPanel26.setLayout(new java.awt.GridLayout(1, 0));

        jPanel5.setBackground(new java.awt.Color(204, 255, 153));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel20.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel20.setText("N");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel5.add(jLabel20, gridBagConstraints);

        jPanel26.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 51, 204));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel21.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel21.setText("N");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel6.add(jLabel21, gridBagConstraints);

        jPanel26.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel22.setFont(new java.awt.Font("Geist Mono", 0, 18)); // NOI18N
        jLabel22.setText("N");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel7.add(jLabel22, gridBagConstraints);

        jPanel26.add(jPanel7);

        jPanelBox6.add(jPanel26);

        jPanel1.add(jPanelBox6);

        jPanel8.setLayout(new java.awt.GridLayout());

        tbl_revenue.setFont(new java.awt.Font("Geist Mono", 0, 12)); // NOI18N
        tbl_revenue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Inovoice ID", "Invoice Date", "Total Amount"
            }
        ));
        jScrollPane1.setViewportView(tbl_revenue);

        jPanel8.add(jScrollPane1);

        tbl_exspenses.setFont(new java.awt.Font("Geist Mono", 0, 12)); // NOI18N
        tbl_exspenses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Exspenses Date", "Exspenses Porpose", "Total Exspenses"
            }
        ));
        jScrollPane2.setViewportView(tbl_exspenses);

        jPanel8.add(jScrollPane2);

        tbl_order.setFont(new java.awt.Font("Geist Mono", 0, 12)); // NOI18N
        tbl_order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order Date", "Product Name", "Quantity", "Status"
            }
        ));
        jScrollPane3.setViewportView(tbl_order);

        jPanel8.add(jScrollPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1072, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelExspenses;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelBox1;
    private javax.swing.JPanel jPanelBox2;
    private javax.swing.JPanel jPanelBox3;
    private javax.swing.JPanel jPanelBox4;
    private javax.swing.JPanel jPanelBox5;
    private javax.swing.JPanel jPanelBox6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_exspenses;
    private javax.swing.JTable tbl_order;
    private javax.swing.JTable tbl_revenue;
    // End of variables declaration//GEN-END:variables
}
