
package Logic;

public class CurrentStock {
    private Integer id;
    private String name;
    private String category;
    private Integer stockIn;
    private Integer stockOut;
    private Integer currentStock;
    public CurrentStock(Integer id, String name, String category, Integer stockIn, Integer stockOut, Integer currentStock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.stockIn = stockIn;
        this.stockOut = stockOut;
        this.currentStock = currentStock;
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

    public Integer getStockIn() {
        return stockIn;
    }

    public void setStockIn(Integer stockIn) {
        this.stockIn = stockIn;
    }

    public Integer getStockOut() {
        return stockOut;
    }

    public void setStockOut(Integer stockOut) {
        this.stockOut = stockOut;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

  
       
}
