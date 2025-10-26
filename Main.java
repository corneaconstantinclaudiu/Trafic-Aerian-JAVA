import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        
        AirportInformation infoCluj = new AirportInformation("Aeroportul International Avram Iancu, Cluj-Napoca", "0264-307500", "David Ciceo");
        AirportInformation infoBucuresti = new AirportInformation("Aeroportul International Henri Coanda, Otopeni", "021-2041000", "Cosmin Pestesan");
        AirportInformation infoTimisoara = new AirportInformation("Aeroportul International Traian Vuia, Timisoara", "0256-386089", "Daniel Stamatovici");

        Airport cluj = new Airport(infoCluj);
        Airport bucuresti = new Airport(infoBucuresti);
        Airport timisoara = new Airport(infoTimisoara);
        
        Vector<Airport> airports = new Vector<>();
        airports.add(cluj);
        airports.add(bucuresti);
        airports.add(timisoara);

        cluj.addAirplane(new Airplane("Boeing 737", "180 locuri, 2 clase", "comercial", "TAROM"));
        cluj.addAirplane(new Airplane("Airbus A320", "150 locuri, 2 clase", "comercial", "Wizz Air"));
        cluj.addAirplane(new Airplane("Cessna 172", "4 locuri, 1 clasa", "privat", "Aviation School"));

        bucuresti.addAirplane(new Airplane("Boeing 787", "300 locuri, 3 clase", "comercial", "Qatar Airways"));
        bucuresti.addAirplane(new Airplane("Airbus A380", "500 locuri, 4 clase", "comercial", "Emirates"));
        bucuresti.addAirplane(new Airplane("Learjet 75", "8 locuri, 1 clasa", "business", "Private Jet Co."));

        timisoara.addAirplane(new Airplane("Boeing 747 Cargo", "N/A", "cargo", "Cargolux"));
        timisoara.addAirplane(new Airplane("Embraer E190", "100 locuri, 2 clase", "comercial", "Lufthansa"));
        timisoara.addAirplane(new Airplane("ATR 72", "70 locuri, 1 clasa", "regional", "Air Connect"));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Meniu Gestiune Trafic Aerian ---");
            System.out.println("1. Afiseaza toate aeroporturile si avioanele de la sol");
            System.out.println("2. Porneste un zbor");
            System.out.println("3. Iesire");
            System.out.print("Alege o optiune: ");
            
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Situatia la sol ---");
                    for (Airport airport : airports) {
                        System.out.println("Aeroport: " + airport.getAirportInformation().getAirportAddress());
                        Vector<Airplane> planes = airport.getAirplanes();
                        if (planes.isEmpty()) {
                            System.out.println("  -> Niciun avion la sol.");
                        } else {
                            for (Airplane plane : planes) {
                                System.out.println("  -> " + plane);
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n--- Planifica un zbor ---");
                    
                    System.out.println("Alege aeroportul de plecare (0-" + (airports.size()-1) + "):");
                    for(int i = 0; i < airports.size(); i++) System.out.println(i + ": " + airports.get(i).getAirportInformation());
                    int fromIndex = scanner.nextInt();
                    Airport fromAirport = airports.get(fromIndex);

                    System.out.println("Alege aeroportul de destinatie (0-" + (airports.size()-1) + "):");
                    for(int i = 0; i < airports.size(); i++) System.out.println(i + ": " + airports.get(i).getAirportInformation());
                    int toIndex = scanner.nextInt();
                    Airport toAirport = airports.get(toIndex);

                    Vector<Airplane> availablePlanes = fromAirport.getAirplanes();
                    if(availablePlanes.isEmpty()){
                        System.out.println("Nu exista avioane disponibile in acest aeroport!");
                        break;
                    }
                    
                    System.out.println("Alege avionul (0-" + (availablePlanes.size()-1) + "):");
                    for(int i = 0; i < availablePlanes.size(); i++) System.out.println(i + ": " + availablePlanes.get(i));
                    int planeIndex = scanner.nextInt();
                    Airplane planeToFly = availablePlanes.get(planeIndex);

                    FlightManager.transferAirplane(fromAirport, toAirport, planeToFly);
                    break;
                case 3:
                    System.out.println("Inchidere sistem...");
                    break;
                default:
                    System.out.println("Optiune invalida!");
                    break;
            }
        } while (choice != 3);

        scanner.close();
        System.exit(0); 
    }
}