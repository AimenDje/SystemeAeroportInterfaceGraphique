public class GateScreen extends Observer{
    private Gate  gate;
    private String name;
    public GateScreen (Gate gate, ScreenDialog screenDialog){
        this.gate = gate;
        this.name = "GATE " + gate.getNom();

    }
    @Override
    public void update() {
        System.out.println("GATE "+gate.getNom());
        if (gate.getFlights().isEmpty()) {
            return;
        } else {
            for (Flight flight : gate.getFlights()) {
                System.out.println(flight.toString());
            }
        }
    }
}
