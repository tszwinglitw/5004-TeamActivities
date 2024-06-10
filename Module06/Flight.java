import java.util.*;

public class Flight implements Comparable<Flight> {
    private String airline;
    private int flightNumber;
    private String airlineCode;

    public Flight(String airline, int flightNumber, String airlineCode) {
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.airlineCode = airlineCode;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getFlightID() {
        return airlineCode + flightNumber;
    }

    public String getAirlineCode() { return this.airlineCode; }

    @Override
    public int hashCode() {
        return Objects.hash(this.getFlightID());
        // return this.getFlightID().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if(!(o instanceof Flight)) {
            return false;
        }

        Flight other = (Flight) o;
        return this.getFlightID().equals(other.getFlightID());
    }


    @Override
    public int compareTo(Flight o) {
        return this.getFlightID().compareTo(o.getFlightID());
    }

    @Override
    public String toString() {
        return "Flight{" + "airline='" + airline + '\'' + ", flightNumber=" + flightNumber
                + ", airlineCode='" + airlineCode + '\'' + '}';
    }


    public static void main(String[] args) {


        Flight f1 = new Flight("Delta", 123, "DL");
        Flight f2 = new Flight("American", 456, "AA");
        Flight f3 = new Flight("United", 789, "UA");

        System.out.println(f1.compareTo(f2));
        System.out.println(f2.compareTo(f3));
        System.out.println(f3.compareTo(f1));

        List<Flight> flights = new ArrayList<>();
        // can't use list.of() only, as it returns an immutable list, so we add one to new list
        flights.addAll(List.of(f1, f2, f3));


        System.out.println(flights);

        System.out.println("Sorting by Flight ID:");
        flights.sort(null);
        System.out.println(flights.stream().map(f -> f.getFlightID()).toList());
        System.out.println(flights);

        // TODO: Create a lambda expression to sort the flights by flight number

        System.out.println("Sorting by Flight Number:");
        flights.sort((a, b) -> a.getFlightNumber() - b.getFlightNumber());
        System.out.println(flights.stream().map(f -> f.getFlightNumber()).toList());
        System.out.println(flights);

        System.out.println("Sorting by airline code:");
        flights.sort((a, b) -> a.getAirlineCode().compareTo(b.getAirlineCode()));
        System.out.println(flights.stream().map(f -> f.getAirlineCode()).toList());
        System.out.println(flights);


        // TODO: Add code using a TreeSet to store the flights in order

        Set<Flight> flightSet = new TreeSet<>(flights);
        System.out.println("Set<Flight> flightSet:");
        System.out.println(flightSet.stream().map(f -> f.getFlightID()).toList());



        // TODO: Add code to store the flights in a TreeMap
        // use the flight as key, and Integer as value - storing the number of seats on the flight
        TreeMap<Flight, Integer> flightSeats = new TreeMap<>();

        // assuming F1, F2, F3 are already created
        flightSeats.put(f1, 100);
        flightSeats.put(f2, 200);
        flightSeats.put(f3, 300);
        System.out.println(flightSeats);

    }
}
