package test;

import java.util.ArrayList;
import java.util.List;

public class Flight {

    private String seatCategory;
    private String flightNumber;
    private int availableSeats;
    private int price;
    private String arrival;
    private String departure;

    //default constructor
    Flight() {
    }

    // constructor
    public Flight(String[] str) {
        this.seatCategory = str[0];
        this.flightNumber = str[1];
        this.availableSeats = Integer.parseInt(str[2]);
        this.price = Integer.parseInt(str[3]);
        this.arrival = str[4];
        this.departure = str[5];
    }

//    protected static void addFlight(String[] str) {
//        flights.add(new Flights(str[0], str[1], str[2], str[3], str[4], str[5]));
//    }

    //getters
    public String getSeatCategory() {
        return seatCategory;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public int getPrice() { return price; }

    public String getArrival() {
        return arrival;
    }

    public String getDeparture() {
        return departure;
    }

    //Setters
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }



    @Override
    public String toString() {
        return "Flights{" +
                "Flight Number='" + flightNumber + '\'' +
                ", Available Seats=" + availableSeats +
                ", Arrival=" + arrival +
                ", Departure=" + departure +
                ", Price=" + price +
                '}';
    }


}