package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TelematicsService {

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
        File file = new File(".");
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                // Now you have a File object named "f".
                // You can use this to create a new instance of Scanner
                ObjectMapper mapper = new ObjectMapper();
                VehicleInfo vi = mapper.readValue(f, VehicleInfo.class);
                System.out.println(vi);
            }
        }




    }






}
