/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ExspenseDto;
import DTO.PermissionDto;
import DTO.sum_invoiceAmounttoday;
import Database.DatabaseConfig;
import Product_Component.ProductModul;
import java.sql.Date;
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
public class ExspenseDao {

    public Long addExspense(ExspenseDto addExspense) throws Exception {
        String sql = "INSERT INTO public.tbl_exspense(\n"
                + "	expense_date, purpose, description, quantity, price, total)\n"
                + "	VALUES ( ?, ?, ?, ?, ?, ?);";
        PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
        ExspenseDto dto = new ExspenseDto();
        pstmt.setString(1, dto.getExspense_purpose());
        pstmt.setDate(2, (Date) dto.getExspense_date());
        pstmt.setString(3, dto.getExspense_description());
        pstmt.setInt(4, dto.getQuantity());
        pstmt.setDouble(5, dto.getExspense_price());
        ResultSet rs = pstmt.executeQuery();
        Boolean test = rs.next();
        if (test == true) {
            return rs.getLong("id");
        }

        return 0L;

    }

    public List<ExspenseDto> loadExspense() throws Exception {
        List<ExspenseDto> resp = new ArrayList<>();
        String sql = "SELECT id, expense_date, purpose, description, quantity, price, total\n"
                + "	FROM public.tbl_exspense;";
        PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
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

    public boolean delete(long uid) throws Exception {
        List<ExspenseDto> resp = new ArrayList<ExspenseDto>();
        String sql = "DELETE FROM public.tbl_exspense\n"
                + "	WHERE id =?;";
        PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
        pstmt.setLong(1, uid);
        int cnt = pstmt.executeUpdate();
        pstmt.close();
        if (cnt > 0) {
            return true;
        }
        return false;
    }

    public List<ExspenseDto> dailyExspense() {
        List<ExspenseDto> list = new ArrayList<>();
        try {
            String sql = "SELECT Sum(total) AS dailyExspenses\n"
                    + "	FROM public.tbl_exspense\n"
                    + "	Where expense_date = CURRENT_DATE;";
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            sum_invoiceAmounttoday getdata;
            while (rs.next()) {
                // get single row from database with DTO have  alot Variable
                ExspenseDto getDailyExspense = new ExspenseDto();
                getDailyExspense.setDailyExspenses(rs.getDouble("dailyExspenses"));
                list.add(getDailyExspense);
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public List<ExspenseDto> monthlyExspense() {
        List<ExspenseDto> list = new ArrayList<>();
        try {
            String sql = "SELECT SUM(total) AS monthlyExpenses\n"
                    + "FROM public.tbl_exspense\n"
                    + "WHERE DATE_TRUNC('month', expense_date) = DATE_TRUNC('month', CURRENT_DATE);";
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // get single row from database with DTO have  alot Variable
                ExspenseDto getmonthlyExspense = new ExspenseDto();
                getmonthlyExspense.setMonthlyExspenses(rs.getDouble("monthlyExpenses"));
                list.add(getmonthlyExspense);
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public List<ExspenseDto> totalExspense() {
        List<ExspenseDto> list = new ArrayList<>();
        try {
            String sql = "SELECT SUM(total) AS monthlyExpenses\n"
                    + "FROM public.tbl_exspense;";
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // get single row from database with DTO have  alot Variable
                ExspenseDto gettotalExspense = new ExspenseDto();
                gettotalExspense.setTotalExspenses(rs.getDouble("monthlyExpenses"));
                list.add(gettotalExspense);
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductModul.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

}
