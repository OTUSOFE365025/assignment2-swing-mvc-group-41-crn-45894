import java.util.List;

public class Controller {
    private CashRegister model;
    private View view;

    public Controller(CashRegister m, View v) {
        model = m;
        view = v;
        initView();
    }

    public void initView() {
        view.updateDisplay(model.getScannedItems(), model.getSubtotal());
    }

    // Handles UPC scans from the Scanner window
    public void handleScan(String upc) {
        model.addItemByUPC(upc);
        List<Product> items = model.getScannedItems();
        double subtotal = model.getSubtotal();
        view.updateDisplay(items, subtotal);
    }
}
