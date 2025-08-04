/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.StockDetailDto;
import Database.DatabaseConfig;
import com.sun.jdi.connect.spi.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author Da Phadenphorakden
 */
public class StockDetailDao {

//    public List<StockDetailDto> Count_product() {
//        List<StockDetailDto> list = new ArrayList<>();
//        try {
//            String sql = "SELECT Count(id) as Count_Products FROM public.product;";
//            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
//            ResultSet rs = pstmt.executeQuery();
//            StockDetailDto getdata;
//            while (rs.next()) {
//                getdata = new StockDetailDto(
//                        rs.getInt("Count_Products"));
//                list.add(getdata);
//            }
//        } catch (SQLException e) {
//            Logger.getLogger(StockDetailDto.class.getName()).log(Level.SEVERE, null, e);
//        }
//        return list;
//    }
    public StockDetailDto countProducts() {
        String sql = "SELECT COUNT(id) AS Count_Products FROM public.product";
        try {
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new StockDetailDto(rs.getInt("Count_Products"), null, null, null); // Count_Stockin set to null
            } else {
                return new StockDetailDto(0, null, null, null); // Default if no rows (adjust as needed)
            }
        } catch (SQLException e) {
            Logger.getLogger(StockDetailDao.class.getName()).log(Level.SEVERE, "Error counting products", e);
            throw new RuntimeException("Database error while counting products", e); // Or handle differently
        }
    }

    public StockDetailDto countStockin() {
        String sql = "SELECT Sum(quantity) as Count_Stockin FROM public.stockin;";
        try {
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new StockDetailDto(null, rs.getInt("Count_Stockin"), null, null); // Count_Stockin set to null
            } else {
                return new StockDetailDto(null, 0, null, null); // Default if no rows (adjust as needed)
            }
        } catch (SQLException e) {
            Logger.getLogger(StockDetailDao.class.getName()).log(Level.SEVERE, "Error counting products", e);
            throw new RuntimeException("Database error while counting products", e); // Or handle differently
        }
    }

    public StockDetailDto countStockout() {
        String sql = "SELECT Sum(quantity) As Count_Stockout FROM public.invoice_items;";
        try {
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new StockDetailDto(null, null, rs.getInt("Count_Stockout"), null); // Count_Stockin set to null
            } else {
                return new StockDetailDto(null, null, 0, null); // Default if no rows (adjust as needed)
            }
        } catch (SQLException e) {
            Logger.getLogger(StockDetailDao.class.getName()).log(Level.SEVERE, "Error counting products", e);
            throw new RuntimeException("Database error while counting products", e); // Or handle differently
        }

    }

    public StockDetailDto countAvailable() {
        String sql = "SELECT\n"
                + "    SUM(\n"
                + "        (SELECT COALESCE(SUM(sin.quantity), 0) FROM stockin sin WHERE sin.product_id = pro.id) -\n"
                + "        (SELECT COALESCE(SUM(ini.quantity), 0) FROM invoice_items ini WHERE ini.product_id = pro.id)\n"
                + "    ) AS Count_Available\n"
                + "FROM\n"
                + "    Product pro";
        try {
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new StockDetailDto(null, null, null, rs.getInt("Count_Available")); // Count_Stockin set to null
            } else {
                return new StockDetailDto(null, null, null, 0); // Default if no rows (adjust as needed)
            }
        } catch (SQLException e) {
            Logger.getLogger(StockDetailDao.class.getName()).log(Level.SEVERE, "Error counting products", e);
            throw new RuntimeException("Database error while counting products", e); // Or handle differently
        }

    }

}
