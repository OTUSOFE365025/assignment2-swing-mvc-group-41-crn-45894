public class MySwingMVCApp {

    public static void main(String[] args) {

        Model m = new Model("Sylvain", "Saurel");
        View v = new View("MVC with SSaurel");
        Controller c1 = new Controller(m, v);
        c1.initController();


        CashRegister register = new CashRegister("products.txt");

        Model m2 = new Model("Aliza", "Rizwan");
        View displayView = new View("Cash Register");
        Controller c2 = new Controller(m2, displayView);
        c2.initController();

        displayView.createDisplayArea();

        c2.setCashRegister(register, displayView);

        new Scanner(c2);

        System.out.println("Program started successfully.");
        System.out.println("Click 'Scan' to simulate scanning products.");
    }
}
