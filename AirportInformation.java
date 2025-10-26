public final class AirportInformation {
    private final String airportAddress;
    private final String airportTelephone;
    private final String airportManager;

    public AirportInformation(String airportAddress, String airportTelephone, String airportManager) {
        this.airportAddress = airportAddress;
        this.airportTelephone = airportTelephone;
        this.airportManager = airportManager;
    }

    public String getAirportAddress() {
        return airportAddress;
    }

    public String getAirportTelephone() {
        return airportTelephone;
    }

    public String getAirportManager() {
        return airportManager;
    }

    @Override
    public String toString() {
        return airportAddress; // Simplificăm afișarea la adresa
    }
}