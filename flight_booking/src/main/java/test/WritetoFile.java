package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WritetoFile {
    public static void writeSuccesfulFlightInfoToCSV(List<FlightInfo> f) {
        /*
        * Booking name, flight number, Category, number of seats booked, total price
        *Sam,SJ456,Economy,2,500
        *Richard,BY110,Premium Economy,2,1000
         *Anna,SJ456,Economy,1,250
        * */
        try {
            File myObj = new File("Output.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                FileWriter myWriter = new FileWriter(myObj.getName());
                myWriter.write(FlightInfo.toFile(f));
                myWriter.close();
                System.out.println("Successfully wrote to the file.");

            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeUnsuccesfulFlightInfoToTXT(List<FlightInfo> f) {
        /*
         * Please enter correct booking details for John: invalid flight number
         * Please enter correct booking details for Sierra: invalid card number
         * */
        try {
            File myObj = new File("Output.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                FileWriter myWriter = new FileWriter(myObj.getName());
                myWriter.write(FlightInfo.toError(f));
                myWriter.close();
                System.out.println("Successfully wrote to the file.");

            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}