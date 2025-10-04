
public class MySwingMVCApp {
    public static void main(String[] args) {
        CashRegister model = new CashRegister("products.txt");
        View view = new View("Cash Register");
        Controller controller = new Controller(model, view);

       
        new Scanner(controller);

        System.out.println("Program started. Click 'Scan' to simulate scanning.");
    }
}
