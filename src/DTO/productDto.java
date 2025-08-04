/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Da Phadenphorakden
 */
public class productDto {
    private Integer id;
    private String name;
    private String category;
    private String image;
    private Double price_of_sale;

    public productDto(Integer id, String name, String category, String image, Double price_of_sale) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.image = image;
        this.price_of_sale = price_of_sale;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice_of_sale() {
        return price_of_sale;
    }

    public void setPrice_of_sale(Double price_of_sale) {
        this.price_of_sale = price_of_sale;
    }

    

    
}
