import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChangeGateDialog extends JDialog {
  private GuiApp app;
  private JTextField companyField, flightNumberField, terminalField, gateNumberField;
  private JButton okButton, cancelButton;

  public ChangeGateDialog(GuiApp app) {
    super(app, "Change Gate", true);
    this.app = app;

    companyField = new JTextField(10);
    flightNumberField = new JTextField(10);
    terminalField = new JTextField(10);
    gateNumberField = new JTextField(10);

    okButton = new JButton("OK");
    okButton.addActionListener(e -> {
      changeGate();
      setVisible(false);
    });

    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(e -> setVisible(false));

    // Layout
    JPanel companyPanel = new JPanel();
    companyPanel.add(new JLabel("Company: "));
    companyPanel.add(companyField);

    JPanel flightPanel = new JPanel();
    flightPanel.add(new JLabel("Flight Number: "));
    flightPanel.add(flightNumberField);

    JPanel terminalPanel = new JPanel();
    terminalPanel.add(new JLabel("Terminal: "));
    terminalPanel.add(terminalField);

    JPanel gatePanel = new JPanel();
    gatePanel.add(new JLabel("Gate Number: "));
    gatePanel.add(gateNumberField);

    JPanel controlPanel = new JPanel();
    controlPanel.add(okButton);
    controlPanel.add(cancelButton);

    Container c = getContentPane();
    c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
    c.add(companyPanel);
    c.add(flightPanel);
    c.add(terminalPanel);
    c.add(gatePanel);
    c.add(controlPanel);

    setSize(350, 250);
    setLocationRelativeTo(app);
  }

  private void changeGate() {
    String company = companyField.getText().trim();
    int flightNumber = Integer.parseInt(flightNumberField.getText().trim());
    String flightID = company + flightNumber;

    String terminal = terminalField.getText().trim();
    int gateNumber = Integer.parseInt(gateNumberField.getText().trim());

    app.changeGate(flightID, terminal, gateNumber);
  }
}
