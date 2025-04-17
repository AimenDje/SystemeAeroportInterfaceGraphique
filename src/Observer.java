import java.util.List;

public abstract class Observer {
  
  public abstract void update();

  public static void displayFlights(List<Flight> flights, ScreenDialog screenDialog) {
  if (flights.isEmpty()) {
    screenDialog.setScreenText("---");
    return;
  }
  
  StringBuilder res = new StringBuilder();
  for (Flight flight : flights) {
    res.append(flight.toString());
    res.append("\n");
  }
  screenDialog.setScreenText(res.toString());
}
  
}
