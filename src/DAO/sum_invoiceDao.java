/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.sum_invoice;
import Database.DatabaseConfig;
import Product_Component.ProductModul;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Da Phadenphorakden
 */
public class sum_invoiceDao {
    public List<sum_invoice> sum_invoiceDto() 
    {
        List<sum_invoice> list = new ArrayList<>();
        try{
            String sql = "SELECT COUNT(invoice_id) as invoice_id FROM public.invoices WHERE invoice_date = CURRENT_DATE;";
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            sum_invoice getdata;
            while (rs.next()) {                
                getdata = new sum_invoice(
                        rs.getInt("invoice_id"));
                list.add(getdata);
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
}
