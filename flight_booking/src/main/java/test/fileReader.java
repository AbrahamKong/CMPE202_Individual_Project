package test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class fileReader {
    public static List<FlightInfo> readFlightInfoFromCSV(String fileName) {
        List<FlightInfo> infos = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        //using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
            // read the first line from the text file
            String line = br.readLine();
            line = br.readLine();

            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                FlightInfo info = enterFlightInfo(attributes);
                // adding book into ArrayList
                infos.add(info);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
//            System.out.println(infos.toString());
        } catch (IOException ioe) { ioe.printStackTrace(); }
        return infos;
    }

    public static List<Flight> readFlightsFromCSV(String fileName) {
        List<Flight> fs = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        //using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
            // read the first line from the text file
            String line = br.readLine();
            line = br.readLine();

            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                // adding book into ArrayList
                fs.add(new Flight(attributes));

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
//            System.out.println(flights.toString());
        } catch (IOException ioe) { ioe.printStackTrace(); }
//        Flights flights = Flights.getInstance(fs);
//        return flights;
        return fs;
    }

    private static FlightInfo enterFlightInfo(String[] info) {
        String bn_temp = info[0];
        String fn_temp = info[1];
        String sc_temp = info[2];
        int sn_temp = Integer.parseInt(info[3]);
        String cn_temp = info[4];

        return new FlightInfo(bn_temp, fn_temp, sc_temp, sn_temp, cn_temp);
    }

//    private static Flights enterFlights(String[] info) {
//        int as_temp = Integer.parseInt(info[2]);
//        int p_temp = Integer.parseInt(info[3]);
//
//        return flights.add(info[0], info[1], as_temp, p_temp, info[4], info[5]);
//    }
}