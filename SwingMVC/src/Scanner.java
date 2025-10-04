// This window emulates the scanning of an item. Every time the buttom is pressed
// it will send a notification of a UPC code

import java.awt.BorderLayout;
import java.io.File;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Scanner {
    private JFrame frame;
    private JPanel scannerPanel;
    private JButton scanButton;

    private List<String> upcCodes = new ArrayList<>();
    private Random rand = new Random();
    private Controller controller;

    public Scanner(Controller controller) {
        this.controller = controller;

        loadUPCs("products.txt");

        frame = new JFrame("Scanner");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(120, 120);
        frame.setLocation(300, 50);

        scanButton = new JButton("Scan");
        scannerPanel = new JPanel();
        scannerPanel.add(scanButton);
        frame.getContentPane().add(scannerPanel);

        scanButton.addActionListener(e -> scanProduct());

        frame.setVisible(true);
    }

	
    private void loadUPCs(String filename) {
        try (java.util.Scanner sc = new java.util.Scanner(new File(filename))) {
            while (sc.hasNext()) {
                upcCodes.add(sc.next());   
                sc.next();                
                sc.nextDouble();          
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    private void scanProduct() {
        if (upcCodes.isEmpty()) {
            System.out.println("No UPC codes found in file!");
            return;
        }

        String upc = upcCodes.get(rand.nextInt(upcCodes.size()));
        System.out.println("Scanned: " + upc);
        controller.handleScan(upc);
    }

    public JFrame getFrame() { return frame; }
    public JPanel getScannerPanel() { return scannerPanel; }
    public JButton getScanButton() { return scanButton; }
}

