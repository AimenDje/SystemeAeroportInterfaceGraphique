import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;

public class AddFlightDialog extends JDialog {
  
  public static final int WIDTH = 300;
  public static final int HEIGHT = 350;
  
  private GuiApp app;
  private String currentState = null;
  
  private JButton okButton, cancelButton;
  private JPanel controlPanel;
  private JTextField companyField, flightNumberField, destinationField;
  private JTextField departureTimeField, terminalField, gateNumberField;
  private JComboBox statusBox;
  
  public AddFlightDialog(GuiApp app) {
    
    super(app, "Add Flight");
    this.app = app;
    
    okButton = new JButton("OK");
    okButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addFlight();
        setVisible(false);
      }
    });
    
    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showConfirmDialog(
          AddFlightDialog.this,
          "Do you want to cancel?",
          "Cancel",
          JOptionPane.YES_NO_OPTION);
        
        if (choice == JOptionPane.YES_OPTION) {
          setVisible(false);
        }
      }
    });
    
    String[] statuses = { Flight.ONTIME, Flight.CANCELLED, Flight.BOARDING, Flight.DELAYED };
    JComboBox<String> statusBox = new JComboBox<String>(statuses);
    statusBox.setSelectedItem(Flight.ONTIME);
    statusBox.setEditable(false);
    statusBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println((String)statusBox.getSelectedItem());
        currentState = (String)statusBox.getSelectedItem();
      }
    });
    
    JPanel companyPanel = new JPanel();
    companyField = new JTextField(10);
    companyPanel.add(new JLabel("Company: "));
    companyPanel.add(companyField);
    
    JPanel flightNumberPanel = new JPanel();
    flightNumberField = new JTextField(10);
    flightNumberPanel.add(new JLabel("Flight Number: "));
    flightNumberPanel.add(flightNumberField);
    
    JPanel destinationPanel = new JPanel();
    destinationField = new JTextField(10);
    destinationPanel.add(new JLabel("Destination: "));
    destinationPanel.add(destinationField);
    
    JPanel departureTimePanel = new JPanel();
    departureTimeField = new JTextField(10);
    departureTimePanel.add(new JLabel("Departure Time: "));
    departureTimePanel.add(departureTimeField);
    
    JPanel terminalPanel = new JPanel();
    terminalField = new JTextField(10);
    terminalPanel.add(new JLabel("Terminal: "));
    terminalPanel.add(terminalField);
    
    JPanel gateNumberPanel = new JPanel();
    gateNumberField = new JTextField(10);
    gateNumberPanel.add(new JLabel("Gate Number: "));
    gateNumberPanel.add(gateNumberField);
    
    JPanel flightStatusPanel = new JPanel();
    flightStatusPanel.add(new JLabel("Flight Status: "));
    flightStatusPanel.add(statusBox);
    
    controlPanel = new JPanel();
    controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
    controlPanel.add(okButton);
    controlPanel.add(cancelButton);
    
    Container c = getContentPane();
    c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
    c.add(companyPanel);
    c.add(flightNumberPanel);
    c.add(destinationPanel);
    c.add(departureTimePanel);
    c.add(terminalPanel);
    c.add(gateNumberPanel);
    c.add(flightStatusPanel);
    c.add(controlPanel);
    
    setSize(new Dimension(WIDTH, HEIGHT));
    setLocationRelativeTo(app);
  
  }
  
  public void addFlight() {
    
    String company = companyField.getText();
    int flightNumber = Integer.parseInt(flightNumberField.getText());
    String destination = destinationField.getText();
    int departureTime = Integer.parseInt(departureTimeField.getText());
    String terminal = terminalField.getText();
    int gateNumber = Integer.parseInt(gateNumberField.getText());
    if (currentState == null) {
      currentState = Flight.ONTIME;
    }
    String statusStr = currentState;
    
    Flight flight = new Flight(
      company, flightNumber, destination, departureTime,
      terminal + "-" + gateNumber, statusStr);
    
    // TODO: Add missing methods in the GuiApp class
    app.addFlightToAirport(flight);
    app.addFlightToTerminal(flight, terminal);
    app.addFlightToGate(flight, terminal, gateNumber);
    app.appendToDisplayArea("Flight added:\n" + flight); 
  }

}
