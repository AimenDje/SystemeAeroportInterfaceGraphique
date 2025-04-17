import java.util.List;

public class TerminalScreen extends Observer {
  
  private Terminal terminal;
  private String name;
  private ScreenDialog screenDialog;
  
  public TerminalScreen(Terminal terminal, String name, ScreenDialog screenDialog) {
    this.terminal = terminal;
    this.name = name;
    this.screenDialog = screenDialog;
  }
  
  @Override
  public void update() {
    List<Flight> flights = terminal.getFlights();
    Observer.displayFlights(flights, screenDialog);
  }

}
