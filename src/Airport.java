import java.util.LinkedList;
import java.util.List;

public class Airport extends Subject{
    private List<Flight> flights = new LinkedList<>();
    @Override
    public void addFlight(Flight flight) {
      flights.add(flight);
      notifyObservers();
    }

    @Override
    public void removeFlight(Flight flight) {
      flights.remove(flight);
      notifyObservers();
    }

    @Override
    public List<Flight> getFlights() {
      return flights;
    }
    public Flight getFlight(String IdFlight) {
    for (Flight flight : flights) {
        if (flight.getIdFlight().equals(IdFlight)) {
            return flight;
        }
    }
    return null;
    }
}
