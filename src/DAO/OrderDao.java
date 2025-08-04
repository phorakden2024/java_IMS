/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ExspenseDto;
import DTO.OrderDto;
import DTO.sum_invoiceAmounttoday;
import Database.DatabaseConfig;
import Product_Component.ProductModul;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

;

/**
 *
 * @author Da Phadenphorakden
 */
public class OrderDao {

    public List<OrderDto> getOrdertable() {
        List<OrderDto> list = new ArrayList<>();
        try {
            String sql = "SELECT \n"
                    + "    o.id,\n"
                    + "    o.order_date,\n"
                    + "    o.purpose,\n"
                    + "    p.name as pname,\n"
                    + "    o.quantity,\n"
                    + "    s.name as vname,\n"
                    + "    st.status\n"
                    + "FROM public.tbl_order o\n"
                    + "JOIN public.Product p ON o.product_id = p.id\n"
                    + "JOIN public.Suppliers s ON o.vendor_id = s.id\n"
                    + "JOIN public.tbl_status st ON o.status = st.id\n"
                    + "ORDER BY o.id DESC;";
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // get single row from database with DTO have  alot Variable
                OrderDto getordertable = new OrderDto();
                getordertable.setOrder_id(rs.getInt("id"));
                getordertable.setOrder_date(rs.getDate("order_date"));
                getordertable.setOrder_porpose(rs.getString("purpose"));
                getordertable.setProduct_name(rs.getString("pname"));
                getordertable.setQuantity(rs.getInt("quantity"));
                getordertable.setVendor_name(rs.getString("vname"));
                getordertable.setStatus(rs.getString("status"));
                list.add(getordertable);
            }
        } catch (SQLException e) {
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public boolean delete(long uid) throws Exception {
        List<ExspenseDto> resp = new ArrayList<ExspenseDto>();
        String sql = "DELETE FROM public.tbl_order\n"
                + "	WHERE id = ?;";
        PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
        pstmt.setLong(1, uid);
        int cnt = pstmt.executeUpdate();
        pstmt.close();
        if (cnt > 0) {
            return true;
        }
        return false;
    }
}
