package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the length: ");
		input.nextLine();
		int length = Integer.parseInt(input.nextLine());

		System.out.println("Is the measurement in (m)eter, or (f)eet? ");
		String meterOrFeet = input.nextLine();

		if (meterOrFeet.equals("m")) {
			int convertToFeet = (int)(length * 3.2808399);
			System.out.println(length + "m is " + convertToFeet + "f.");
		}
		else if (meterOrFeet.equals("f")) {
			int convertToMeters = (int)(length * 0.3048);
			System.out.println(length + "f is " + convertToMeters + "f.");
		}
	}

}
