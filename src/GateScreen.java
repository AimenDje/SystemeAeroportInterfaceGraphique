import java.util.List;

public class GateScreen extends Observer{
    private Gate  gate;
    private String name;

    private ScreenDialog screenDialog;

    public GateScreen (Gate gate, ScreenDialog screenDialog){
        this.gate = gate;
        this.name = "GATE " + gate.getNom();
        this.screenDialog = screenDialog;
    }

    @Override
    public void update() {
        List<Flight> flights = gate.getFlights();
        Observer.displayFlights(flights, screenDialog);
    }
}
