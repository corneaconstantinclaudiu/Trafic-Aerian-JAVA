public class FlightManager {

    public static void transferAirplane(Airport from, Airport to, Airplane airplane) {
        
        if (!from.getAirplanes().contains(airplane)) {
            System.out.println("EROARE: Avionul " + airplane.getAirplaneName() + " nu se afla la " + from.getAirportInformation().getAirportAddress());
            return;
        }

        Thread flightThread = new Thread(() -> {
            from.removeAirplane(airplane);
            System.out.println("INFO: Avionul " + airplane.getAirplaneName() + " a decolat de la " + from.getAirportInformation().getAirportAddress() + " cu destinatia " + to.getAirportInformation().getAirportAddress());

            try {
                Thread.sleep(10000); // 10000 milisecunde = 10 secunde [cite: 227]
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            to.addAirplane(airplane);
            System.out.println("INFO: Avionul " + airplane.getAirplaneName() + " a aterizat la " + to.getAirportInformation().getAirportAddress());
        });

        flightThread.start();
    }
}