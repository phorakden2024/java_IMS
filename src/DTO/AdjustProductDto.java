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
public class AdjustProductDto {
    private Integer id;
    private Integer product_id;
    private String name;
    private String category;
    private String adjust_to;
    private Double adjust_amount;
    private String adjust_for;
    private Date date;
    private String image;

    public AdjustProductDto(Integer id, Integer product_id, String name, String category, String adjust_to, Double adjust_amount, String adjust_for, Date date, String image) {
        this.id = id;
        this.product_id = product_id;
        this.name = name;
        this.category = category;
        this.adjust_to = adjust_to;
        this.adjust_amount = adjust_amount;
        this.adjust_for = adjust_for;
        this.date = date;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAdjust_to() {
        return adjust_to;
    }

    public void setAdjust_to(String adjust_to) {
        this.adjust_to = adjust_to;
    }

    public Double getAdjust_amount() {
        return adjust_amount;
    }

    public void setAdjust_amount(Double adjust_amount) {
        this.adjust_amount = adjust_amount;
    }

    public String getAdjust_for() {
        return adjust_for;
    }

    public void setAdjust_for(String adjust_for) {
        this.adjust_for = adjust_for;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    
}
