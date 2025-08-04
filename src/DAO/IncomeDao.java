/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.IncomeDto;
import Database.DatabaseConfig;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Da Phadenphorakden
 */
public class IncomeDao {

    public List<IncomeDto> loadIncomeToTable() throws Exception {
        List<IncomeDto> resp = new ArrayList<>();
        String sql = "SELECT\n"
                + "    pro.id AS product_id,\n"
                + "    pro.name AS product_name,\n"
                + "    pro.category AS product_cate,\n"
                + "    COALESCE(sin_agg.total_quantity_in, 0) AS product_stockin,\n"
                + "    COALESCE(sin_first.cost, 0) AS product_cost,\n"
                + "    COALESCE(sin_first.cost, 0) * COALESCE(sin_agg.total_quantity_in, 0) AS total_cost,\n"
                + "    COALESCE(ini_agg.total_quantity_out, 0) AS product_stockout,\n"
                + "    COALESCE(sin_first.price, 0) AS product_price,\n"
                + "    (COALESCE(sin_agg.total_quantity_in, 0) - COALESCE(ini_agg.total_quantity_out, 0)) AS product_available,\n"
                + "    COALESCE(sin_first.price, 0) * COALESCE(ini_agg.total_quantity_out, 0) AS total_revenue,\n"
                + "    (COALESCE(sin_first.price, 0) * COALESCE(ini_agg.total_quantity_out, 0)) - (COALESCE(sin_first.cost, 0) * COALESCE(ini_agg.total_quantity_out, 0)) AS income\n"
                + "FROM\n"
                + "    Product pro\n"
                + "LEFT JOIN LATERAL (\n"
                + "    -- Get the first cost and price for each product\n"
                + "    SELECT\n"
                + "        sin.product_id,\n"
                + "        sin.cost,\n"
                + "        sin.price\n"
                + "    FROM\n"
                + "        stockin sin\n"
                + "    WHERE\n"
                + "        sin.product_id = pro.id\n"
                + "    LIMIT 1\n"
                + ") AS sin_first ON TRUE\n"
                + "LEFT JOIN (\n"
                + "    -- Sum quantities from stockin\n"
                + "    SELECT\n"
                + "        sin.product_id,\n"
                + "        SUM(sin.quantity) AS total_quantity_in\n"
                + "    FROM\n"
                + "        stockin sin\n"
                + "    GROUP BY\n"
                + "        sin.product_id\n"
                + ") AS sin_agg ON pro.id = sin_agg.product_id\n"
                + "LEFT JOIN (\n"
                + "    -- Sum quantities from invoice_items\n"
                + "    SELECT\n"
                + "        ini.product_id,\n"
                + "        SUM(ini.quantity) AS total_quantity_out\n"
                + "    FROM\n"
                + "        invoice_items ini\n"
                + "    GROUP BY\n"
                + "        ini.product_id\n"
                + ") AS ini_agg ON pro.id = ini_agg.product_id\n"
                + "ORDER BY\n"
                + "    pro.id;";
        PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            IncomeDto dto = new IncomeDto();
            dto.setProduct_id(rs.getInt("product_id"));
            dto.setProduct_name(rs.getString("product_name"));
            dto.setProduct_cate(rs.getString("product_cate"));
            dto.setProduct_stockin(rs.getInt("product_stockin"));
            dto.setProduct_cost(rs.getDouble("product_cost"));
            dto.setTotal_cost(rs.getDouble("total_cost"));
            dto.setProduct_stockout(rs.getInt("product_stockout"));
            dto.setProduct_price(rs.getDouble("product_price"));
            dto.setProduct_available(rs.getInt("product_available"));
            dto.setTotal_revenue(rs.getDouble("total_revenue"));
            dto.setIncome(rs.getDouble("income"));

            resp.add(dto);
        }
        rs.close();
        return resp;
    }

    public List<IncomeDto> getIncomeOfProdeuct() throws Exception {
        List<IncomeDto> resp = new ArrayList<>();
        String sql = "SELECT SUM(income) AS total_income\n"
                + "FROM (\n"
                + "    SELECT\n"
                + "        pro.id AS product_id,\n"
                + "        pro.name AS product_name,\n"
                + "        pro.category AS product_cate,\n"
                + "        COALESCE(sin_agg.total_quantity_in, 0) AS product_stockin,\n"
                + "        COALESCE(sin_first.cost, 0) AS product_cost,\n"
                + "        COALESCE(sin_first.cost, 0) * COALESCE(sin_agg.total_quantity_in, 0) AS total_cost,\n"
                + "        COALESCE(ini_agg.total_quantity_out, 0) AS product_stockout,\n"
                + "        COALESCE(sin_first.price, 0) AS product_price,\n"
                + "        (COALESCE(sin_agg.total_quantity_in, 0) - COALESCE(ini_agg.total_quantity_out, 0)) AS product_available,\n"
                + "        COALESCE(sin_first.price, 0) * COALESCE(ini_agg.total_quantity_out, 0) AS total_revenue,\n"
                + "        (COALESCE(sin_first.price, 0) * COALESCE(ini_agg.total_quantity_out, 0)) - \n"
                + "        (COALESCE(sin_first.cost, 0) * COALESCE(ini_agg.total_quantity_out, 0)) AS income\n"
                + "    FROM\n"
                + "        Product pro\n"
                + "    LEFT JOIN LATERAL (\n"
                + "        -- Get the first cost and price for each product\n"
                + "        SELECT\n"
                + "            sin.product_id,\n"
                + "            sin.cost,\n"
                + "            sin.price\n"
                + "        FROM\n"
                + "            stockin sin\n"
                + "        WHERE\n"
                + "            sin.product_id = pro.id\n"
                + "        LIMIT 1\n"
                + "    ) AS sin_first ON TRUE\n"
                + "    LEFT JOIN (\n"
                + "        -- Sum quantities from stockin\n"
                + "        SELECT\n"
                + "            sin.product_id,\n"
                + "            SUM(sin.quantity) AS total_quantity_in\n"
                + "        FROM\n"
                + "            stockin sin\n"
                + "        GROUP BY\n"
                + "            sin.product_id\n"
                + "    ) AS sin_agg ON pro.id = sin_agg.product_id\n"
                + "    LEFT JOIN (\n"
                + "        -- Sum quantities from invoice_items\n"
                + "        SELECT\n"
                + "            ini.product_id,\n"
                + "            SUM(ini.quantity) AS total_quantity_out\n"
                + "        FROM\n"
                + "            invoice_items ini\n"
                + "        GROUP BY\n"
                + "            ini.product_id\n"
                + "    ) AS ini_agg ON pro.id = ini_agg.product_id\n"
                + ") AS subquery";
        PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            IncomeDto dto = new IncomeDto();
            dto.setIncome_of_produect(rs.getDouble("total_income"));
            resp.add(dto);
        }
        rs.close();
        return resp;

    }

    public List<IncomeDto> getTotalProdeuctCost() throws Exception {
        List<IncomeDto> resp = new ArrayList<>();
        String sql = "SELECT SUM(total_cost) AS total_product_cost\n"
                + "FROM (\n"
                + "    SELECT\n"
                + "        COALESCE(sin_first.cost, 0) * COALESCE(sin_agg.total_quantity_in, 0) AS total_cost\n"
                + "    FROM\n"
                + "        Product pro\n"
                + "    LEFT JOIN LATERAL (\n"
                + "        SELECT sin.cost\n"
                + "        FROM stockin sin\n"
                + "        WHERE sin.product_id = pro.id\n"
                + "        LIMIT 1\n"
                + "    ) AS sin_first ON TRUE\n"
                + "    LEFT JOIN (\n"
                + "        SELECT sin.product_id, SUM(sin.quantity) AS total_quantity_in\n"
                + "        FROM stockin sin\n"
                + "        GROUP BY sin.product_id\n"
                + "    ) AS sin_agg ON pro.id = sin_agg.product_id\n"
                + ") AS subquery;";
        PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            IncomeDto dto = new IncomeDto();
            dto.setTotal_productCost(rs.getDouble("total_product_cost"));
            resp.add(dto);
        }
        rs.close();
        return resp;
    }
}
