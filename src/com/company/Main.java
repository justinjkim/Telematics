package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner userInput = new Scanner(System.in);

        VehicleInfo newCar = new VehicleInfo();

        System.out.println("Please enter your vehicle's VIN:");
        newCar.setVIN(userInput.nextInt());

        System.out.println(newCar.getVIN());





    }
}
