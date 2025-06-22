
package Logic;

public class InvoiceDB {
    private Integer item_id;
        private Integer invoice_id;
        private String product_name;
        private Double price;
        private Integer quantity;
        private Double subtotal;
    public InvoiceDB(Integer item_id, Integer invoice_id, String product_name, Double price, Integer quantity, Double subtotal) {
        this.item_id = item_id;
        this.invoice_id = invoice_id;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Integer getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Integer invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
        
}
