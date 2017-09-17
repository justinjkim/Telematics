package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TelematicsService {

    static void report(VehicleInfo vehicleInfo) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        int VIN = vehicleInfo.getVIN();
        mapper.writeValue(new File(VIN + ".json"), vehicleInfo); // this line, I had to look up online
        String json = mapper.writeValueAsString(vehicleInfo);
        System.out.println(json);
    };
}
