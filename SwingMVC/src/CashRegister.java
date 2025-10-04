import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class CashRegister {
    private Map<String, Product> products = new HashMap<>();
    private List<Product> scannedItems = new ArrayList<>();

    public CashRegister(String filename) {
        loadProducts(filename);
    }

    private void loadProducts(String filename) {
        try (java.util.Scanner sc = new java.util.Scanner(new File(filename))) {
            while (sc.hasNext()) {
                String upc = sc.next();
                String name = sc.next();
                double price = sc.nextDouble();
                products.put(upc, new Product(upc, name, price));
            }
        } catch (Exception e) {
            System.out.println("Error reading product file: " + e.getMessage());
        }
    }

    public void addItemByUPC(String upc) {
        if (products.containsKey(upc)) {
            scannedItems.add(products.get(upc));
        }
    }

    public List<Product> getScannedItems() {
        return scannedItems;
    }

    public double getSubtotal() {
        double total = 0.0;
        for (Product p : scannedItems) {
            total += p.getPrice();
        }
        return total;
    }
}
