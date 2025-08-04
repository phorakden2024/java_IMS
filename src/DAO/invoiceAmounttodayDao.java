/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ExspenseDto;
import DTO.sum_invoiceAmounttoday;
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
public class invoiceAmounttodayDao {

    public List<sum_invoiceAmounttoday> sum_invoiceTAmounttodaysDto() {
        List<sum_invoiceAmounttoday> list = new ArrayList<>();
        try {
            String sql = "SELECT SUm(total_amount) as invoiceAmounttoday FROM public.invoices WHERE invoice_date = CURRENT_DATE;";
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // get single row from database with DTO have  alot Variable
                sum_invoiceAmounttoday sumInv = new sum_invoiceAmounttoday();
                sumInv.setInvoiceAmounttoday(rs.getDouble("invoiceAmounttoday"));
                list.add(sumInv);
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
    public List<sum_invoiceAmounttoday> incomeCurrentMonthDto() {
        List<sum_invoiceAmounttoday> list = new ArrayList<>();
        try {
            String sql = "SELECT SUM(total_amount) AS incomeCurrentMonthly \n"
                    + "FROM public.invoices\n"
                    + "WHERE DATE_TRUNC('month', invoice_date) = DATE_TRUNC('month', CURRENT_DATE);";
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            sum_invoiceAmounttoday getdata;
            while (rs.next()) {
                // get single row from database with DTO have  alot Variable
                sum_invoiceAmounttoday sumIncomeCurrentMonthly = new sum_invoiceAmounttoday();
                sumIncomeCurrentMonthly.setIncomeCurrentMonthly(rs.getDouble("incomeCurrentMonthly"));
                list.add(sumIncomeCurrentMonthly);
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    

}
