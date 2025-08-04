/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.sum_totalAmount;
import Database.DatabaseConfig;
import Product_Component.ProductModul;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Da Phadenphorakden
 */
public class sum_totalAmountDao {
    public List<sum_totalAmount> sum_totalAmountDto() 
    {
        List<sum_totalAmount> list = new ArrayList<>();
        try{
            String sql = "SELECT sum(total_amount) as invoiceAmountTotal FROM public.invoices; ";
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            sum_totalAmount getdata;
            while (rs.next()) {                
                getdata = new sum_totalAmount(
                        rs.getDouble("invoiceAmountTotal"));
                list.add(getdata);
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
}
