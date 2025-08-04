/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.UserDto;
import Database.DatabaseConfig;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Da Phadenphorakden
 */
public class UserDao {

    public List<UserDto> loadUserRole() throws Exception {
        List<UserDto> resp = new ArrayList<UserDto>();
        String sql = "SELECT u.id,\n"
                + "u.uname,\n"
                + "u.upass,\n"
                + "u.is_active,\n"
                + "r.name,\n"
                + "u.role_id\n"
                + "FROM public.tbluser u\n"
                + "Left join role r on r.id = u.role_id\n"
                + "ORDER BY id ASC ";
        PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            UserDto dto = new UserDto();
            dto.setUid(rs.getLong("id"));
            dto.setUname(rs.getString("uname"));
            dto.setUpass(rs.getString("upass"));
            dto.setIs_active(rs.getBoolean("is_active"));
            dto.setRole_name(rs.getString("name"));
            dto.setRole_id(rs.getInt("role_id"));
            resp.add(dto);
        }
        rs.close();
        return resp;
    }

    public List<UserDto> loadAllUsers() throws Exception {
        List<UserDto> resp = new ArrayList<UserDto>();
        String sql = "select id,uname,upass,confirm_code,code_exp,is_active from public.tbluser order by uname;";
        PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            UserDto dto = new UserDto();
            dto.setUid(rs.getLong("id"));
            dto.setUname(rs.getString("uname"));
            dto.setUpass(rs.getString("upass"));
            dto.setConfirm_code(rs.getString("confirm_code"));
            dto.setCode_exp(rs.getDate("code_exp"));
            dto.setIs_active(rs.getBoolean("is_active"));
            resp.add(dto);
        }
        rs.close();
        return resp;
    }

    public Long addUser(UserDto usr) throws Exception {
        String sql = "with tmp as\n"
                + "(select ? uname,? upass,? is_active from public.tbluser where not exists(select 1 from public.tbluser where uname=?) limit 1)\n"
                + "insert into public.tbluser(uname,upass,is_active)\n"
                + "(select uname,upass,is_active from tmp)\n"
                + "returning id ";
        PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement(sql);
        pstmt.setString(1, usr.getUname());
        pstmt.setString(2, usr.getUpass());
        pstmt.setBoolean(3, usr.getIs_active());
        pstmt.setString(4, usr.getUname());
        ResultSet rs = pstmt.executeQuery();
        Boolean test = rs.next();
        if (test == true) {
            return rs.getLong("id");
        }
        return 0L;
    }

    public boolean updateUser(UserDto oldUser, UserDto newUser) throws Exception {
        PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement("update public.tbluser set uname=?,upass=?,is_active=? where id=? \n"
                + " and not exists(select 1 from public.tbluser where id<>? and uname=?) ");
        pstmt.setString(1, newUser.getUname());
        pstmt.setString(2, newUser.getUpass());
        pstmt.setBoolean(3, newUser.getIs_active());
        pstmt.setLong(4, newUser.getUid());
        pstmt.setLong(5, oldUser.getUid());
        pstmt.setString(6, oldUser.getUname());

        int cnt = pstmt.executeUpdate();
        pstmt.close();
        if (cnt > 0) {
            return true;
        }
        return false;
    }

    public boolean deleteUser(long uid) throws Exception {
        List<UserDto> resp = new ArrayList<UserDto>();
        PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement("delete from public.tbluser where id=? ");
        pstmt.setLong(1, uid);
        int cnt = pstmt.executeUpdate();
        pstmt.close();
        if (cnt > 0) {
            return true;
        }
        return false;
    }

    public List<UserDto> searchById(Long uid) throws Exception {
        List<UserDto> resp = new ArrayList<UserDto>();
        //Connection con=ConnectionConfig.getConnection();
        PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement("select id,uname,upass,confirm_code,code_exp,is_active from public.tbluser where id=? order by uname");
        pstmt.setLong(1, uid);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            UserDto dto = new UserDto();
            dto.setUid(rs.getLong("id"));
            dto.setUname(rs.getString("uname"));
            dto.setUpass(rs.getString("upass"));
            dto.setConfirm_code(rs.getString("confirm_code"));
            dto.setCode_exp(rs.getDate("code_exp"));
            dto.setIs_active(rs.getBoolean("is_active"));
            resp.add(dto);
        }
        rs.close();
        return resp;
    }

    public List<UserDto> searchByName(String name) throws Exception {
        List<UserDto> resp = new ArrayList<UserDto>();
        //Connection con=ConnectionConfig.getConnection();
        PreparedStatement pstmt = DatabaseConfig.getConnection().prepareStatement("select id,uname,upass,confirm_code,code_exp,is_active from public.tbluser where uname=? order by uname");
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            UserDto dto = new UserDto();
            dto.setUid(rs.getLong("id"));
            dto.setUname(rs.getString("uname"));
            dto.setUpass(rs.getString("upass"));
            dto.setConfirm_code(rs.getString("confirm_code"));
            dto.setCode_exp(rs.getDate("code_exp"));
            dto.setIs_active(rs.getBoolean("is_active"));
            resp.add(dto);
        }
        rs.close();
        return resp;
    }
}
