/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Da Phadenphorakden
 */
public class StockDetailTableDto {

    private Integer product_id;
    private String product_name;
    private String product_cate;
    private Integer stockin;
    private Integer stockout;
    private Integer stockavaible;

    public StockDetailTableDto(Integer product_id, String product_name, String product_cate, Integer stockin, Integer stockout, Integer stockavaible) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_cate = product_cate;
        this.stockin = stockin;
        this.stockout = stockout;
        this.stockavaible = stockavaible;
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

    public Integer getStockin() {
        return stockin;
    }

    public void setStockin(Integer stockin) {
        this.stockin = stockin;
    }

    public Integer getStockout() {
        return stockout;
    }

    public void setStockout(Integer stockout) {
        this.stockout = stockout;
    }

    public Integer getStockavaible() {
        return stockavaible;
    }

    public void setStockavaible(Integer stockavaible) {
        this.stockavaible = stockavaible;
    }

}
