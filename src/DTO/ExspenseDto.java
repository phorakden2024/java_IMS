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
public class ExspenseDto {

    private int exspense_id;
    private String exspense_purpose;
    private Date exspense_date;
    private String exspense_description;
    private int quantity;
    private Double exspense_price;
    private Double total;
    private Double dailyExspenses;
    private Double monthlyExspenses;
    private Double totalExspenses;

    public Double getDailyExspenses() {
        return dailyExspenses;
    }

    public void setDailyExspenses(Double dailyExspenses) {
        this.dailyExspenses = dailyExspenses;
    }

    public Double getMonthlyExspenses() {
        return monthlyExspenses;
    }

    public void setMonthlyExspenses(Double monthlyExspenses) {
        this.monthlyExspenses = monthlyExspenses;
    }

    public Double getTotalExspenses() {
        return totalExspenses;
    }

    public void setTotalExspenses(Double totalExspenses) {
        this.totalExspenses = totalExspenses;
    }

    

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    

    public int getExspense_id() {
        return exspense_id;
    }

    public void setExspense_id(int exspense_id) {
        this.exspense_id = exspense_id;
    }

    public String getExspense_purpose() {
        return exspense_purpose;
    }

    public void setExspense_purpose(String exspense_purpose) {
        this.exspense_purpose = exspense_purpose;
    }
    public Date getExspense_date() {
        return exspense_date;
    }

    public void setExspense_date(Date exspense_date) {
        this.exspense_date = exspense_date;
    }

    public String getExspense_description() {
        return exspense_description;
    }

    public void setExspense_description(String exspense_description) {
        this.exspense_description = exspense_description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getExspense_price() {
        return exspense_price;
    }

    public void setExspense_price(Double exspense_price) {
        this.exspense_price = exspense_price;
    }

}
