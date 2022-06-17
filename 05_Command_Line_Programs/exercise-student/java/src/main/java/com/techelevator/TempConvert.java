package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		System.out.println("Please enter a temperature.");
		String input = myScanner.nextLine();
		Double temp = Double.parseDouble(input);
		double tempC = temp;
		double tempF = temp;

		System.out.println("Is the temperature in (C)elsius or (F)arenheit?");
		String unit = myScanner.nextLine();

		if( unit.equals("C")) {
			tempC = temp * 1.8 +32;
			System.out.println(temp + " degress celsius is " + tempC + " degrees farenheit");



		}
		else if( unit.equals("F")){
			tempF = (temp - 32) / 1.8;
			System.out.println(temp + " degress farenheit is " + tempF + " degrees celsius");



		}
		else {
			System.out.println("Not a valid entry.");
		}

	}

}
