import java.awt.event.*;
import javax.swing.*;

/**
 * You can use this very simple class
 * to test the GUI in the virtual desktop
 * (use Run Current from the top menu bar
 * to run the program in a console,
 * then press the Virtual Desktop button)
 */
public class TestFrame extends JFrame {
  
  public TestFrame() {
    super("Test Frame");
    this.setSize(300, 100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    JButton addButton = new JButton("Test Button");
    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Button Pressed");
      }
    });
    
    this.add(addButton);
  }
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        TestFrame frame = new TestFrame();
        frame.setVisible(true);
      }
    });
  }
  
}
