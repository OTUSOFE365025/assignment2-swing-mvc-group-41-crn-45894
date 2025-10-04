import java.io.File;
import java.util.*;

public class CashRegister {
    private Map<String, Product> products = new HashMap<>();
    private List<Product> scannedItems = new ArrayList<>();

    public CashRegister(String filename) {
        loadProducts(filename);
    }

    private void loadProducts(String filename) {
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNext()) {
                String upc = sc.next();
                String name = sc.next();
                double price = sc.nextDouble();
                products.put(upc, new Product(upc, name, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        return scannedItems.stream().mapToDouble(Product::getPrice).sum();
    }
}
