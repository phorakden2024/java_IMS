/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Da Phadenphorakden
 */
public class UserDto {

    private long uid;
    private String uname;
    private String upass;
    private String confirm_code;
    private Date code_exp;
    private Boolean is_active;
    private Integer role_id;
    private String role_name;

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
 
    

//    public UserDto(long uid, String uname, String upass, String confirm_code, Date code_exp, Boolean is_active) {
//        this.uid = uid;
//        this.uname = uname;
//        this.upass = upass;
//        this.confirm_code = confirm_code;
//        this.code_exp = code_exp;
//        this.is_active = is_active;
//    }
    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getConfirm_code() {
        return confirm_code;
    }

    public void setConfirm_code(String confirm_code) {
        this.confirm_code = confirm_code;
    }

    public Date getCode_exp() {
        return code_exp;
    }

    public void setCode_exp(Date code_exp) {
        this.code_exp = code_exp;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }
}
