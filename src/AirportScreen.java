import java.util.List;

public class AirportScreen extends Observer {

    private Airport airport;
    private String name;
    private ScreenDialog screenDialog;

    public AirportScreen(Airport airport, String name, ScreenDialog screenDialog) {
        this.airport = airport;
        this.name = name;
        this.screenDialog = screenDialog;
    }

    @Override
    public void update() {
        List<Flight> flights = airport.getFlights();
        Observer.displayFlights(flights, screenDialog);
    }

}