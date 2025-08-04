/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.importProductDto;
import DTO.productDto;
import Database.DatabaseConfig;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Da Phadenphorakden
 */
public class ImportProductDao {
    public Long store(importProductDto impdto ) throws Exception {    
        String sql = "INSERT INTO stockin(name, category, quantity, cost, price)VALUES (?, ?, ?, ?, ?);";
                PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
                pstmt.setString(1, impdto.getName());
                pstmt.setString(2, impdto.getCategory());
                pstmt.setInt(3,impdto.getQty());
                pstmt.setDouble(4, impdto.getCost());
                pstmt.setDouble(5, impdto.getPrice());
        ResultSet rs=pstmt.executeQuery();
        Boolean test=rs.next();
        if(test==true)
        {
            return rs.getLong("id");
        }
        return 0L;
    }
}
