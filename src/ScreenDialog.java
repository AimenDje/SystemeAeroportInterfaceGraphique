import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScreenDialog extends JDialog {
  
  public static final int WIDTH = 250;
  public static final int HEIGHT = 80;
  
  private static final int LINE_COUNT = 5;
  private static final int LINE_SIZE = 20; // in characters
  
  private GuiApp app;
  private String screenName;
  private int screenColour;
  
  private JButton closeButton;
  private JPanel controlPanel;
  private JTextArea displayArea;
  private JScrollPane scrollPane;
  
  public ScreenDialog(GuiApp app, String screenName, int screenColour) {
    super(app, screenName);
    this.app = app;
    this.screenName = screenName;
    this.screenColour = screenColour;
    
    displayArea = new JTextArea(LINE_COUNT, LINE_SIZE);
    displayArea.setEditable(false);
    scrollPane = new JScrollPane(displayArea,
                                 JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                 JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    
    closeButton = new JButton("Close");
    closeButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showConfirmDialog(
          ScreenDialog.this,
          "Do you want to close?",
          "Close",
          JOptionPane.YES_NO_OPTION);
        
        if (choice == JOptionPane.YES_OPTION) {
          setVisible(false);
        }
      }
    });
    
    controlPanel = new JPanel();
    controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
    controlPanel.add(closeButton);
    
    Container c = getContentPane();
    c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
    c.add(displayArea);
    c.add(controlPanel);
    
    setSize(new Dimension(WIDTH, HEIGHT));
    setLocationRelativeTo(app);
  }
  
  protected void setScreenText(String text) {
    displayArea.setText(text);
  }
  
  protected void ClearScreenText() {
    displayArea.setText("");
  }

} 
