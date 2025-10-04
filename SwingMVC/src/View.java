import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class View {
    private JFrame frame;
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JTextField firstnameTextfield;
    private JTextField lastnameTextfield;
    private JButton firstnameSaveButton;
    private JButton lastnameSaveButton;
    private JButton hello;
    private JButton bye;

    
    private JTextArea scannedItemsArea = new JTextArea(5, 30);
    private JLabel subtotalLabel = new JLabel("Subtotal: $0.00");

    
    public View(String title) {
        frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 120);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        
        firstnameLabel = new JLabel("Firstname :");
        lastnameLabel = new JLabel("Lastname :");
        firstnameTextfield = new JTextField();
        lastnameTextfield = new JTextField();
        firstnameSaveButton = new JButton("Save firstname");
        lastnameSaveButton = new JButton("Save lastname");
        hello = new JButton("Hello!");
        bye = new JButton("Bye!");

       
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(firstnameLabel)
                .addComponent(lastnameLabel))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(firstnameTextfield)
                .addComponent(lastnameTextfield))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(firstnameSaveButton)
                .addComponent(lastnameSaveButton))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(hello)
                .addComponent(bye)));
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(firstnameLabel)
                .addComponent(firstnameTextfield)
                .addComponent(firstnameSaveButton)
                .addComponent(hello))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lastnameLabel)
                .addComponent(lastnameTextfield)
                .addComponent(lastnameSaveButton)
                .addComponent(bye)));

        layout.linkSize(SwingConstants.HORIZONTAL, firstnameSaveButton, lastnameSaveButton);
        layout.linkSize(SwingConstants.HORIZONTAL, hello, bye);
        frame.getContentPane().setLayout(layout);
    }

    
    public JFrame getFrame() { return frame; }
    public void setFrame(JFrame frame) { this.frame = frame; }

    public JLabel getFirstnameLabel() { return firstnameLabel; }
    public void setFirstnameLabel(JLabel firstnameLabel) { this.firstnameLabel = firstnameLabel; }

    public JLabel getLastnameLabel() { return lastnameLabel; }
    public void setLastnameLabel(JLabel lastnameLabel) { this.lastnameLabel = lastnameLabel; }

    public JTextField getFirstnameTextfield() { return firstnameTextfield; }
    public void setFirstnameTextfield(JTextField firstnameTextfield) { this.firstnameTextfield = firstnameTextfield; }

    public JTextField getLastnameTextfield() { return lastnameTextfield; }
    public void setLastnameTextfield(JTextField lastnameTextfield) { this.lastnameTextfield = lastnameTextfield; }

    public JButton getFirstnameSaveButton() { return firstnameSaveButton; }
    public void setFirstnameSaveButton(JButton firstnameSaveButton) { this.firstnameSaveButton = firstnameSaveButton; }

    public JButton getLastnameSaveButton() { return lastnameSaveButton; }
    public void setLastnameSaveButton(JButton lastnameSaveButton) { this.lastnameSaveButton = lastnameSaveButton; }

    public JButton getHello() { return hello; }
    public void setHello(JButton hello) { this.hello = hello; }

    public JButton getBye() { return bye; }
    public void setBye(JButton bye) { this.bye = bye; }

    
    public void createDisplayArea() {
        JFrame displayFrame = new JFrame("Cash Register Display");
        displayFrame.setSize(400, 300);
        displayFrame.setLayout(new BorderLayout());

        scannedItemsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(scannedItemsArea);

        displayFrame.add(scrollPane, BorderLayout.CENTER);
        displayFrame.add(subtotalLabel, BorderLayout.SOUTH);
        displayFrame.setVisible(true);
    }

  
    public void updateDisplay(String text, double subtotal) {
        scannedItemsArea.setText(text);
        subtotalLabel.setText("Subtotal: $" + String.format("%.2f", subtotal));
    }
}

