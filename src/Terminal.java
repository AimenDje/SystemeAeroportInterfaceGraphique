import java.util.List;
import java.util.LinkedList;

public class Terminal extends Subject{

  private List<Flight> flights = new LinkedList<>();
  private String nom;

  public Terminal (String nom){
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
