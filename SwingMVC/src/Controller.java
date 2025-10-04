import javax.swing.JOptionPane;
import java.util.List;

public class Controller {
	 private Model model;
	 private View view;
	 
	 public Controller(Model m, View v) {
	  model = m;
	  view = v;
	  initView();
	 }
	 
	 public void initView() {
	  view.getFirstnameTextfield().setText(model.getFirstname());
	  view.getLastnameTextfield().setText(model.getLastname());
	 }
	 
	 public void initController() {
	  view.getFirstnameSaveButton().addActionListener(e -> saveFirstname());
	  view.getLastnameSaveButton().addActionListener(e -> saveLastname());
	  view.getHello().addActionListener(e -> sayHello());
	  view.getBye().addActionListener(e -> sayBye());
	 }
	 
	 private void saveFirstname() {
	  model.setFirstname(view.getFirstnameTextfield().getText());
	  JOptionPane.showMessageDialog(null, "Firstname saved : " + model.getFirstname(), "Info", JOptionPane.INFORMATION_MESSAGE);
	 }
	 
	 private void saveLastname() {
	  model.setLastname(view.getLastnameTextfield().getText());
	  JOptionPane.showMessageDialog(null, "Lastname saved : " + model.getLastname(), "Info", JOptionPane.INFORMATION_MESSAGE);
	 }
	 
	 private void sayHello() {
	  JOptionPane.showMessageDialog(null, "Hello " + model.getFirstname() + " " + model.getLastname(), "Info", JOptionPane.INFORMATION_MESSAGE);
	 }
	 
	 private void sayBye() {
	  System.exit(0);
	 }
    

    private CashRegister register;   
    private View displayView;        

    public void setCashRegister(CashRegister register, View displayView) {
        this.register = register;
        this.displayView = displayView;
    }

    public void handleScan(String upc) {
        if (register == null || displayView == null) {
            System.out.println("Cash Register or Display not initialized!");
            return;
        }

        register.addItemByUPC(upc);

        StringBuilder sb = new StringBuilder();
        List<Product> items = register.getScannedItems();
        for (Product p : items) {
            sb.append(p.toString()).append("\n");
        }

        double subtotal = register.getSubtotal();
        displayView.updateDisplay(sb.toString(), subtotal);
    }
}
