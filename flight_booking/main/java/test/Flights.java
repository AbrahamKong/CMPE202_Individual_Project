package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flights extends Flight {

    private static Flights flights;
    private static List<Flight> fs;

    private Flights(List<Flight> f) {
        super();
        fs = f;
    }

    public static Flights getInstance(List<Flight> f){
        if (flights==null)
            flights = new Flights(f);
        return flights;
    }

    public static void addFlights(Flight flight) {
        fs.add(flight);
    }

    public static Flight get(int i) {
        return fs.get(i);
    }

    public static int size() {
        return fs.size();
    }
}
