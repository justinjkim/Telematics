package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TelematicsService {

    List<VehicleInfo> vehicles = new ArrayList<>(); // putting this outside the methods to initialize it

    public static void report(VehicleInfo vehicleInfo) throws IOException{ // need to understand why throwing IO exception here works

        ObjectMapper mapper = new ObjectMapper();

        // get the VIN from Vehicle Info
        int VIN = vehicleInfo.getVIN();

        // write new File based on VIN
        mapper.writeValue(new File(VIN + ".json"), vehicleInfo); // this line, I had to look up online

        // test to make sure json is formatted properly
        String json = mapper.writeValueAsString(vehicleInfo);
        System.out.println(json);
    };

    public static void convertToJava() throws IOException {
        List<VehicleInfo> vehicles = new ArrayList<>();
        File file = new File(".");
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                // Now you have a File object named "f".
                // You can use this to create a new instance of Scanner
                ObjectMapper mapper = new ObjectMapper();
                VehicleInfo vi = mapper.readValue(f, VehicleInfo.class);
                //System.out.println(vi);
                vehicles.add(vi);
            }
        }
        System.out.println(vehicles);


        // FOR NOW, I MOVED THE UPDATEDASHBOARD() METHOD TO WITHIN THE CONVERTTOJAVA() METHOD

        double avgOdometer = 0;
        double avgConsumption = 0;
        double avgLastOilChange = 0;
        String updatedHTML = "";



        for (VehicleInfo vehicle: vehicles) {
            avgOdometer += vehicle.getOdometer();
            avgConsumption += vehicle.getConsumption();
            avgLastOilChange += vehicle.getOdometerSinceLastOilChange();
        }

        System.out.println(vehicles);

        System.out.println("Averages:");
        System.out.println(avgOdometer);
        System.out.println(avgConsumption);
        System.out.println(avgLastOilChange);

        updatedHTML +=
                "<html>" + "<title>Vehicle Telematics Dashboard</title> " +
                        "<body> " +
                        "<h1 align=\"center\">Averages for # vehicles</h1> " +
                        "<table align=\"center\"> " +
                        "<tr> " +
                        "<th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>" +
                        "</tr> " +
                        "<tr> " +
                        "<td align=\"center\">#</td><td align=\"center\">#</td><td align=\"center\">#</td align=\"center\"><td align=\"center\">#</td> " +
                        "</tr> " +
                        "</table> " +
                        "<h1 align=\"center\">History</h1> " +
                        "<table align=\"center\" border=\"1\"> " +
                        "<tr> " +
                        "<th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th> " +
                        "</tr> " +
                        "<tr> " +
                        "<td align=\"center\">#</td><td align=\"center\">#</td><td align=\"center\">#</td><td align=\"center\">#</td align=\"center\"><td align=\"center\">#</td> " +
                        "</tr> " +
                        "<tr> " +
                        "<td align=\"center\">45435</td><td align=\"center\">123</td><td align=\"center\">234</td><td align=\"center\">345</td align=\"center\"><td align=\"center\">4.5</td> " +
                        "</tr> " +
                        "</table> " +
                        "</body> " +
                        "</html>";




        File finalFile = new File("dashboard.html");

    }






   // }




}
