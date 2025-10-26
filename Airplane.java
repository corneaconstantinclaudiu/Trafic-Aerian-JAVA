public class Airplane extends AbstractAirplane implements AirplaneDataInterface {
    private final String airplaneName;
    private final String airplaneInformation;
    private final String airplaneType;

    public Airplane(String airplaneName, String airplaneInformation, String airplaneType, String airline) {
        this.airplaneName = airplaneName;
        this.airplaneInformation = airplaneInformation;
        this.airplaneType = airplaneType;
        setAirline(airline);
    }

    @Override
    public String getAirplaneName() {
        return airplaneName;
    }

    @Override
    public String getAirplaneInformation() {
        return airplaneInformation;
    }

    @Override
    public String getAirplaneType() {
        return airplaneType;
    }

    @Override
    public String toString() {
        return getAirline() + " " + getAirplaneName() + " (" + getAirplaneType() + ")";
    }
}