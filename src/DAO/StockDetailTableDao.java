/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.StockDetailTableDto;
import Database.DatabaseConfig;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Da Phadenphorakden
 */
public class StockDetailTableDao {

    public List<StockDetailTableDto> stockDetailTable() throws Exception {
        List<StockDetailTableDto> list = new ArrayList<>();
        String sql = "SELECT\n"
                + "    pro.id AS product_id,\n"
                + "    pro.name AS product_name,\n"
                + "    pro.category AS product_cate,\n"
                + "    (SELECT COALESCE(SUM(sin.quantity), 0) FROM stockin sin WHERE sin.product_id = pro.id) AS product_stockin,\n"
                + "    (SELECT COALESCE(SUM(ini.quantity), 0) FROM invoice_items ini WHERE ini.product_id = pro.id) AS product_stockout,\n"
                + "    (\n"
                + "        (SELECT COALESCE(SUM(sin.quantity), 0) FROM stockin sin WHERE sin.product_id = pro.id) -\n"
                + "        (SELECT COALESCE(SUM(ini.quantity), 0) FROM invoice_items ini WHERE ini.product_id = pro.id)\n"
                + "    ) AS product_available\n"
                + "FROM\n"
                + "    Product pro\n"
                + "ORDER BY\n"
                + "    pro.id;"; // Modify query if needed
        try {
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                StockDetailTableDto stockDetailtable = new StockDetailTableDto(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_cate"),
                        rs.getInt("product_stockin"),
                        rs.getInt("product_stockout"),
                        rs.getInt("product_available"));
                list.add(stockDetailtable);
            }
        } catch (SQLException e) {
            Logger.getLogger(StockDetailTableDao.class.getName()).log(Level.SEVERE, "Error counting products", e);
            throw new RuntimeException("Database error while counting products", e); // Or handle differently
        }
        return list;
    }
}
