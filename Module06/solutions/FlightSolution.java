package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class FlightSolution implements Comparable<FlightSolution> {
    private String airline;
    private int flightNumber;
    private String airlineCode;

    public FlightSolution(String airline, int flightNumber, String airlineCode) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof FlightSolution))
            return false;

        FlightSolution flight = (FlightSolution) o;
        return getFlightID().equals(flight.getFlightID());
    }

    @Override
    public int hashCode() {
        return getFlightID().hashCode();
    }


    @Override
    public int compareTo(FlightSolution o) {
        return this.getFlightID().compareTo(o.getFlightID());
    }

    @Override
    public String toString() {
        return "Flight{" + "airline='" + airline + '\'' + ", flightNumber=" + flightNumber
                + ", airlineCode='" + airlineCode + '\'' + '}';
    }


    public static void main(String[] args) {
        FlightSolution f1 = new FlightSolution("Delta", 123, "DL");
        FlightSolution f2 = new FlightSolution("American", 456, "AA");
        FlightSolution f3 = new FlightSolution("United", 789, "UA");

        System.out.println(f1.compareTo(f2));
        System.out.println(f2.compareTo(f3));
        System.out.println(f3.compareTo(f1));

        List<FlightSolution> flights = new ArrayList<>();
        flights.addAll(List.of(f1, f2, f3));

        System.out.println(flights);

        flights.sort(null);

        System.out.println(flights);

        flights.sort((flight1, flight2) -> flight1.getFlightNumber() - flight2.getFlightNumber());

        System.out.println(flights);

        System.out.println("Flight Set Examples");
        Set<FlightSolution> flightSet = new TreeSet<>(flights);

        System.out.println(flightSet); // are they in order?



        TreeMap<FlightSolution, Integer> flightSeats = new TreeMap<>();

        // assuming F1, F2, F3 are already created
        flightSeats.put(f1, 100);
        flightSeats.put(f2, 200);
        flightSeats.put(f3, 300);

        System.out.println(flightSeats);

    }
}
