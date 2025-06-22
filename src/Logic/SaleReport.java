
package Logic;

import java.util.ArrayList;



public class SaleReport {
    
    private static final SaleReport instance = new SaleReport();
    
    private ArrayList <SaleReport> items;
    public static SaleReport getInstance() {
            return instance;
        }
    private SaleReport() {
            items = new ArrayList<>();
        }
    public void addReport(SaleReport item) {
            items.add(item);
        }
    public boolean isEmpty() {
            return items.isEmpty();
        }
}
