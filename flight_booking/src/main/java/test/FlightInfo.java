package test;

import java.util.List;

public class FlightInfo {
    private String bookingName;
    private String flightNumber;
    private String seatCategory;
    private int seatNumber;
    private String cardNumber;
    private int totalPrice;
    private boolean bookingStatus;
    private String errorMessage;


    public FlightInfo(String bn, String fn, String sc, int sn, String cn) {
        bookingName = bn;
        flightNumber = fn;
        seatCategory = sc;
        seatNumber = sn;
        cardNumber = cn;
        totalPrice = 0;
        bookingStatus = false;
        errorMessage = "";
    }

    //getters
    public String getBookingName() {
        return bookingName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean getBookingStatus() { return bookingStatus;}

    public String getErrorMessage() {
        return errorMessage;
    }

    //setters
    public void setTotalPrice(Flight f) {
        this.totalPrice = f.getPrice() * this.getSeatNumber();
    }

    public void setBookingStatus(boolean b) {
        this.bookingStatus = b;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage +=  errorMessage ;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "Name='" + bookingName + '\'' +
                ", Flight=" + flightNumber +
                ", Seat Category=" + seatCategory +
                ", Total price=" + totalPrice +
                ", Booking Status=" + bookingStatus +
                ", Error Messege=" + errorMessage +
                '}';
    }

    public static String toFile(List<FlightInfo> infos) {
        String result =  "Booking name, flight number, Category, number of seats booked, total price";
        for (int i = 0; i < infos.size(); i ++){
            result += "\n" + infos.get(i).bookingName + ", " + infos.get(i).flightNumber + ", " + infos.get(i).seatCategory + ", " + infos.get(i).seatNumber + ", " + infos.get(i).totalPrice;
        }
        return result;
    }

    public static String toError(List<FlightInfo> infos) {
        String result =  "";
        for (int i = 0; i < infos.size(); i ++){
            result += "Please enter correct booking details for " +infos.get(i).errorMessage + "\n";
        }
        return result;
    }

    public boolean checkForAvailabilty(List<Flight> flights){
        boolean result = true;
        boolean hasFlight = false;
        boolean hasSeat = false;
        boolean hasSeatCategory = false;
        boolean hasValidCard = false;
        int placeHolder = -1;

        //Factory Design Pattern with the rest of the
        ValidationFactory validationFactory = new ValidationFactory();
        InfoValidation v1 = ValidationFactory.createValidation("hasFlightNumber");
        InfoValidation v2 = ValidationFactory.createValidation("hasSeatCategory");
        InfoValidation v3 = ValidationFactory.createValidation("hasSpace");

        //Has such Flight Number and Has Seat Categories
        for (int i = 0; i  < flights.size() ; i ++){
//            System.out.println(" Current Flight Number is " + flights.get(i).getFlightNumber() + "\n");
//            System.out.println(" Info Flight Info Number is " + flightNumber + "\n");
            if (v1.validateInfo(flights.get(i),this) == true){
//                System.out.println(this.bookingName + " hasFlightNumber passed");
                hasFlight = true;
                if(v2.validateInfo(flights.get(i), this) == true){
                    placeHolder = i;
                    hasSeatCategory = true;
//                    System.out.println(this.bookingName + " hasSeatCategory passed");
                    break;
                }else {
//                    System.out.println(this.bookingName + ": No such Seat Category!");
                    this.setErrorMessage(bookingName + ": No such Seat Category!");
                    result = false;
                }
                break;
            }
        }
        if (result == false)
            this.setErrorMessage(bookingName + ": No such Flight!");

        //Has Enough Space
        if (hasSeatCategory == true){
//            if (flights.get(palceHolder).availableSeats >= info.getSeatNumber())
//            System.out.println("Current Seat Number is " + flights.get(placeHolder).getAvailableSeats() + "\n");
//            System.out.println("Info Flight Seat Number is " + seatNumber + "\n");

            if (v3.validateInfo(flights.get(placeHolder), this) == true){
//                System.out.println(this.bookingName + " hasSpace passed");
                hasSeat = true;
            }else {
//                System.out.println(this.bookingName + ": Not enough seats!");
                if( this.errorMessage.length() < 1)
                    this.setErrorMessage(this.bookingName + ": Not enough seats!");
                return false;
            }
        }
//        this.setErrorMessage("");

        //Has Valid Card Number
        if (hasSeat == true){
            CreditCardValidation cValid = new CreditCardValidation();
            hasValidCard = cValid.validate(this.cardNumber);
            if (hasValidCard == true){
//                System.out.println(this.bookingName + " validCard passed");
            } else {
//                System.out.println(this.bookingName + ": Invalid Card!");
                if( this.errorMessage.length() < 1)
                 this.setErrorMessage(this.bookingName + ": Invalid Card!");
                return false;
            }
        }

        //Calculate Total Price
        if (hasValidCard == true){
            this.setTotalPrice(flights.get(placeHolder));
            flights.get(placeHolder).setAvailableSeats(flights.get(placeHolder).getAvailableSeats() - this.seatNumber);
            this.setBookingStatus(true);
//            this.setErrorMessage("");
        }


        return result;
    }



}