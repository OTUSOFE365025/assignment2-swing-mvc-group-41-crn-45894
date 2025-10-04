public class MySwingMVCApp {

    public static void main(String[] args) {
       
        Model m = new Model("Sylvain", "Saurel");
        View v = new View("MVC with SSaurel");
        Controller c = new Controller(m, v);
        c.initController();

        CashRegister register = new CashRegister("products.txt");

        View displayView = new View("Cash Register");
        displayView.createDisplayArea();

        c.setCashRegister(register, displayView);

        new Scanner(c);

        System.out.println("Program started.");
        System.out.println("Press the 'Scan' button to simulate scanning a product.");
    }
}
