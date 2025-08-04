/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PermissionDto;
import DTO.UserDto;
import Database.DatabaseConfig;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Da Phadenphorakden
 */
public class PermissionDao {

    public List<PermissionDto> setPermissionDetail(int role_id) throws SQLException {
        List<PermissionDto> resp = new ArrayList<PermissionDto>();
        String sql = "SELECT\n"
                + "    r.name AS role_name,\n"
                + "    p.name AS permission_name,\n"
                + "    p.description AS permission_description\n"
                + "FROM\n"
                + "    role_permission rp\n"
                + "JOIN\n"
                + "    role r ON rp.role_id = r.id\n"
                + "JOIN\n"
                + "    permission p ON rp.permission_id = p.id\n"
                + "Where rp.role_id = '" + role_id + "'\n"
                + "ORDER BY\n"
                + "    r.name, p.name;";
        PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            PermissionDto dto = new PermissionDto();
            dto.setRole_name(rs.getString("role_name"));
            dto.setPermission_name(rs.getString("permission_name"));
            dto.setPermission_description(rs.getString("permission_description"));
            resp.add(dto);
        }
        rs.close();
        return resp;
    }

    public List<PermissionDto> searchPermissionId(Object role_name) throws Exception {
        List<PermissionDto> resp = new ArrayList<PermissionDto>();
        String sql = "SELECT\n"
                + "    r.name AS role_name,\n"
                + "    p.name AS permission_name,\n"
                + "    p.description AS permission_description\n"
                + "FROM\n"
                + "    role_permission rp\n"
                + "JOIN\n"
                + "    role r ON rp.role_id = r.id\n"
                + "JOIN\n"
                + "    permission p ON rp.permission_id = p.id\n"
                + "	Where r.name = '"+ role_name +"'\n"
                + "ORDER BY\n"
                + "    r.name, p.name;";
        PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
        pstmt.setObject(1, role_name);
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                PermissionDto dto = new PermissionDto();
//                dto.setId(rs.getLong("id"));
//                dto.setUid(rs.getLong("uid"));
//                dto.setMenu_name(rs.getString("menu_name"));
//                dto.setMenu_item_name(rs.getString("menu_item_name"));
//                dto.setCreated_by(rs.getLong("created_by"));
//                dto.setCreated_date(rs.getDate("created_date"));
//                dto.setUpdated_by(rs.getLong("updated_by"));
//                dto.setUpdated_date(rs.getDate("updated_date"));
//                dto.setIs_active(rs.getBoolean("is_active"));
                resp.add(dto);
            }
        }
        return resp;
    }
    public List<PermissionDto> fetchPermissionsFromDatabase() {
        List<PermissionDto> resp = new ArrayList<>();
        String sql = "SELECT id, name, description, tick\n"
                + "	FROM public.permission;";

        try {
            PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                PermissionDto dto = new PermissionDto();
                dto.setPermissionId(rs.getInt("id"));
                dto.setPermission_name(rs.getString("name"));
                dto.setPermission_description(rs.getString("description"));
                dto.setTick(rs.getBoolean("tick"));
                resp.add(dto);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching data from database: " + e.getMessage());
        }
        return resp;
    }

}
