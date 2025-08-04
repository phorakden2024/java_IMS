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
public class adjust_product_price {
    private Integer id;
    private Integer product_id;
    private String operation;
    private Date date;
    private Double price;

    public adjust_product_price(Integer id, Integer product_id, String operation, Date date, Double price) {
        this.id = id;
        this.product_id = product_id;
        this.operation = operation;
        this.date = date;
        this.price = price;
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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
            
}
