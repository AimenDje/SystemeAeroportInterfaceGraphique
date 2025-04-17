import java.util.LinkedList;
import java.util.List;

public class Gate extends Subject{
    private List<Flight> flights = new LinkedList<>();
    private String nom;

    public Gate (String nom){
      this.nom = nom;
    }
    
    public String getNom(){
      return nom;
    }
    
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
}
