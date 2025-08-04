/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Da Phadenphorakden
 */
public class StockDetailDto {
    private Integer Count_Products;
    private Integer Count_Stockin;
    private Integer Count_Stockout;
    private Integer Count_AvaiProduct;

    public StockDetailDto(Integer Count_Products, Integer Count_Stockin, Integer Count_Stockout, Integer Count_AvaiProduct) {
        this.Count_Products = Count_Products;
        this.Count_Stockin = Count_Stockin;
        this.Count_Stockout = Count_Stockout;
            this.Count_AvaiProduct = Count_AvaiProduct;
    }

    public Integer getCount_Products() {
        return Count_Products;
    }

    public void setCount_Products(Integer Count_Products) {
        this.Count_Products = Count_Products;
    }

    public Integer getCount_Stockin() {
        return Count_Stockin;
    }

    public void setCount_Stockin(Integer Count_Stockin) {
        this.Count_Stockin = Count_Stockin;
    }

    public Integer getCount_Stockout() {
        return Count_Stockout;
    }

    public void setCount_Stockout(Integer Count_Stockout) {
        this.Count_Stockout = Count_Stockout;
    }

    public Integer getCount_AvaiProduct() {
        return Count_AvaiProduct;
    }

    public void setCount_AvaiProduct(Integer Count_AvaiProduct) {
        this.Count_AvaiProduct = Count_AvaiProduct;
    }

    

   
}
