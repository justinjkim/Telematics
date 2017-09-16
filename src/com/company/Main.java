package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner userInput = new Scanner(System.in);

        VehicleInfo newCar = new VehicleInfo();

        // obtain input from the user and set values
        System.out.println("Please enter your vehicle's VIN:");
        newCar.setVIN(userInput.nextInt());

        System.out.println("Please enter your vehicle's current odometer:");
        newCar.setOdometer(userInput.nextDouble());

        System.out.println("Please enter how many gallons of gas your vehicle has consumed:");
        newCar.setConsumption(userInput.nextDouble());

        System.out.println("Please enter the odometer reading of your last oil change:");
        newCar.setOdometerSinceLastOilChange(userInput.nextDouble());

        System.out.println("Please enter your vehicle's engine size in liters:");
        newCar.setEngineSizeInLiters(userInput.nextDouble());


        





    }
}
