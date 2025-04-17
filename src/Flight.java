public class Flight {
    private String company;
    private int flightNumber;
    private String destination;
    private int departureTime;
    private String gate;
    private String status;

    /**
     * Constant string for the ON TIME status
     */
    public static final String ONTIME = "ON TIME";
    public static final String CANCELLED = "CANCELLED";
    public static final String BOARDING = "BOARDING";
    public static final String DELAYED = "DELAYED";

    public Flight(String company, int flightNumber, String destination, int departureTime, String gate, String status){
        this.company = company;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.gate = gate;
        this.status = status;
    }
    //Getters
    public String getCompany(){
        return company;
    }
    public int getFlightNumber(){
        return flightNumber;
    }
    public String getDestination(){
        return destination;
    }
    public int getDepartureTime(){
        return departureTime;
    }
    public String getGate(){
        return gate;
    }
    public String getStatus (){
        return status;
    }
    public String getIdFlight(){
        return company+flightNumber;
    }
    //Setters
    public void setCompany(String nom){
        this.company = company;
    }
    public void setFlightNumber(int flightNumber){
        this.flightNumber = flightNumber;
    }
    public void setDestination(String destination){
        this.destination = destination;
    }
    public void setDepartureTime(int departureTime){
        this.departureTime = departureTime;

    }
    public void setGate(String gate) {
        this.gate = gate;
    }
    public void setStatus(String status) {
      if (status.equals(ONTIME) || status.equals(CANCELLED) || status.equals(BOARDING) || status.equals(DELAYED)) {
        this.status = status;
      }
    }

    @Override
    public String toString(){
        return getIdFlight() + " "+ destination + " " + departureTime+ " " + gate + " "+ status ;
    }

}
