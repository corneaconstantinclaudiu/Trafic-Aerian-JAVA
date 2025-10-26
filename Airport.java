import java.util.Vector;

public class Airport {
    private final AirportInformation airportInformation;
    private final Vector<Airplane> airplanes;

    public Airport(AirportInformation airportInformation) {
        this.airportInformation = airportInformation;
        this.airplanes = new Vector<>();
    }

    public void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }

    public void removeAirplane(Airplane airplane) {
        airplanes.remove(airplane);
    }

    public Vector<Airplane> getAirplanes() {
        return airplanes;
    }

    public AirportInformation getAirportInformation() {
        return airportInformation;
    }
}