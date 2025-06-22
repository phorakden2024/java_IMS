
package Logic;

public class product {
    private Integer id;
    private String name;
    private String category;
    private Integer quantity;
    private Double price;
    private String image;

    public product(Integer id, String name, String catagory, Integer quantity, Double price, String image) {
        this.id = id;
        this.name = name;
        this.category = catagory;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
    }

    public product(String product_1, double d, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public String getCatagory() {
        return category;
    }

    public void setCatagory(String catagory) {
        this.category = catagory;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
