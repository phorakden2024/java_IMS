/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Da Phadenphorakden
 */
public class IncomeDto {
    private Integer product_id;
    private String product_name;
    private String product_cate;
    private Integer product_stockin;
    private Double product_cost;
    private Double total_cost;
    private Integer product_stockout;
    private Double product_price;
    private Integer product_available;
    private Double total_revenue;
    private Double income;
    private Double income_of_produect;
    private Double total_productCost;

    public Double getTotal_productCost() {
        return total_productCost;
    }

    public void setTotal_productCost(Double total_productCost) {
        this.total_productCost = total_productCost;
    }
    

    public Double getIncome_of_produect() {
        return income_of_produect;
    }

    public void setIncome_of_produect(Double income_of_produect) {
        this.income_of_produect = income_of_produect;
    }
    

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_cate() {
        return product_cate;
    }

    public void setProduct_cate(String product_cate) {
        this.product_cate = product_cate;
    }

    public Integer getProduct_stockin() {
        return product_stockin;
    }

    public void setProduct_stockin(Integer product_stockin) {
        this.product_stockin = product_stockin;
    }

    public Double getProduct_cost() {
        return product_cost;
    }

    public void setProduct_cost(Double product_cost) {
        this.product_cost = product_cost;
    }

    public Double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(Double total_cost) {
        this.total_cost = total_cost;
    }

    public Integer getProduct_stockout() {
        return product_stockout;
    }

    public void setProduct_stockout(Integer product_stockout) {
        this.product_stockout = product_stockout;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public Integer getProduct_available() {
        return product_available;
    }

    public void setProduct_available(Integer product_available) {
        this.product_available = product_available;
    }

    public Double getTotal_revenue() {
        return total_revenue;
    }

    public void setTotal_revenue(Double total_revenue) {
        this.total_revenue = total_revenue;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }
    
}
