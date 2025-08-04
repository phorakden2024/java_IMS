
package ModulComponent.subComponent.Supplier.Sale;
import ModulComponent.subComponent.Supplier.Sale.Invoice;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
  

public class Invoice {

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
        private Integer id;
        private String name;
        private String category;
        private Integer quantity;
        private Double price;
        private String image;
        private static final Invoice instance = new Invoice();
        public List<InvoiceItem> items = new ArrayList<>();
        
        public Invoice(Integer id, String name, String catagory, Integer quantity, Double price, String image) {
        this.id = id;
        this.name = name;
        this.category = catagory;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
    }
        
     
        public double getGrandTotal() {
            double total = 0.0;
                for (InvoiceItem item : items) {
                    total += item.price * item.quantity;
                }
            return total;
        }
        public List<InvoiceItem> getItems() {
            return items;
        }

        private Invoice() {
            items = new ArrayList<>();
        }

        public static Invoice getInstance() {
            return instance;
        }

        public void addProduct(InvoiceItem item) {
            items.add(item);
        }
        public void clearItems() {
        this.items.clear(); 
        }


        public boolean isEmpty() {
            return items.isEmpty();
        }

        public String generateInvoice() {
            if (items.isEmpty()) {
            return "===== Invoice =====\nNo items in this invoice.\n=====================";
        }

        StringBuilder invoiceText = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        String invoiceNumber = generateInvoiceNumber(); // Implement this method

        // Company Information
        invoiceText.append("===============================================\n");
        invoiceText.append("OG Co.,LTD\n");
        invoiceText.append("123 Main Street\n");
        invoiceText.append("Phnom Penh, State ZIP\n");
        invoiceText.append("Phone: (123) 456-7890\n");
        invoiceText.append("===============================================\n");

        // Invoice Details
        invoiceText.append("Invoice Number: ").append(invoiceNumber).append("\n");
        invoiceText.append("Date:           ").append(date).append("\n");
        invoiceText.append("-----------------------------------------------\n");

        // Customer Information (Example - you might fetch this from somewhere)
        invoiceText.append("Bill To:\n");
        invoiceText.append("  Customer Name (if available)\n");
        invoiceText.append("  Customer Address (if available)\n");
        invoiceText.append("-----------------------------------------------\n");

        // Product Details Header
        invoiceText.append(String.format("%-15s %-10s %-8s %-12s\n", "Product", "Price", "Qty", "Total"));
        invoiceText.append("-----------------------------------------------\n");

        double grandTotal = 0.0;
        for (InvoiceItem item : items) {
            double total = item.price * item.quantity;
            grandTotal += total;
            invoiceText.append(String.format("%-15s $%-10.2f %-8d $%-11.2f\n",
                    item.name, item.price, item.quantity, total));
        }

        // Totals
        invoiceText.append("-----------------------------------------------\n");
        invoiceText.append(String.format("%-10s $%.2f\n", "Subtotal:", grandTotal));
        // Add tax calculation here if applicable
        invoiceText.append(String.format("%-10s $%.2f\n", "Tax (if applicable):", 0.00)); // Example
        invoiceText.append("-----------------------------------------------\n");
        invoiceText.append(String.format("%-10s $%.2f\n", "Grand Total:", grandTotal));
        invoiceText.append("===============================================\n");
        invoiceText.append("Thank you for your purchase!\n");
        invoiceText.append("===============================================\n");

        return invoiceText.toString();
        }

        public void saveToFile(String filename) throws IOException {
            try (FileWriter writer = new FileWriter(filename)) {
                writer.write(generateInvoice());
            }
        }

    

        public static class InvoiceItem {
            public int product_id;
            public String name; // Change to public
            public double price;  // Change to public
            public int quantity;  // Change to public


            public InvoiceItem(int product_id ,String name, double price, int quantity) {
                this.product_id = product_id;
                this.name = name;
                this.price = price;
                this.quantity = quantity;
             
            }

        InvoiceItem(int aInt, String string, String string0, int aInt0, double aDouble, String string1) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        String getProductName() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        }
        private String generateInvoiceNumber() {
        // Simple example: current timestamp as a unique identifier
        return String.valueOf(System.currentTimeMillis());
        // For a more robust solution, you might use a database sequence or a specific format.
    }
    }

