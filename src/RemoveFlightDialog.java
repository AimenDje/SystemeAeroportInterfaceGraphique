import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RemoveFlightDialog extends JDialog {
  private GuiApp app;
  private JTextField companyField, flightNumberField;
  private JButton okButton, cancelButton;

  public RemoveFlightDialog(GuiApp app) {
    super(app, "Remove Flight", true);
    this.app = app;

    companyField = new JTextField(10);
    flightNumberField = new JTextField(10);

    okButton = new JButton("OK");
    okButton.addActionListener(e -> {
      removeFlight();
      setVisible(false);
    });

    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(e -> {
      setVisible(false);
    });

    JPanel companyPanel = new JPanel();
    companyPanel.add(new JLabel("Company:"));
    companyPanel.add(companyField);

    JPanel flightNumberPanel = new JPanel();
    flightNumberPanel.add(new JLabel("Flight Number:"));
    flightNumberPanel.add(flightNumberField);

    JPanel controlPanel = new JPanel();
    controlPanel.add(okButton);
    controlPanel.add(cancelButton);

    Container c = getContentPane();
    c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
    c.add(companyPanel);
    c.add(flightNumberPanel);
    c.add(controlPanel);

    setSize(300, 150);
    setLocationRelativeTo(app);
  }

  private void removeFlight() {
    String company = companyField.getText().trim();
    int flightNumber = Integer.parseInt(flightNumberField.getText().trim());
    String flightID = company + flightNumber;

    app.removeFlight(flightID);
  }
}