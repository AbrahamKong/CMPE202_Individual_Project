package test;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.*;

import static test.fileReader.*;


public class RunClient {

    public static void main(String[] args) throws CsvValidationException, IOException {


        String filename="/Users/abraham/Documents/Code/flight_booking/src/main/data/flights.csv";
        List<Flight> flights = readFlightsFromCSV(filename);

        filename="/Users/abraham/Documents/Code/flight_booking/src/main/data/Sample.csv";
        List<FlightInfo> infos = readFlightInfoFromCSV(filename);

        List<FlightInfo> successful = new ArrayList<>();
        List<FlightInfo> unsuccessful = new ArrayList<>();


        for (int i = 0; i < infos.size(); i ++){
//            System.out.println(infos.get(i).getBookingName() + ": " + infos.get(i).checkForAvailabilty(flights) + "\n");
            infos.get(i).checkForAvailabilty(flights);
            if (infos.get(i).getBookingStatus() == true) {
                successful.add(infos.get(i));
            } else{
                unsuccessful.add(infos.get(i));
            }
        }

//        //Print out for validation
//        System.out.println("unSuccessful: \n");
//        for (int i = 0; i < unsuccessful.size(); i ++){
//            System.out.println(unsuccessful.get(i).toString());
//        }

        //Output Successful Flight Booking to Output.csv
        WritetoFile.writeSuccesfulFlightInfoToCSV(successful);
        //Output Unsuccessful Flight Booking to Output.txt
        WritetoFile.writeUnsuccesfulFlightInfoToTXT(unsuccessful);



    }

}


