package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		//get string of decimal values
		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		String inputString = in.nextLine();
		System.out.println();

		//split string into array of decimal strings
		String [] strValues = inputString.split(" ");

		String [] binaryValues = new String[strValues.length];

		//loop through each decimal string
		for (int i = 0; i < strValues.length; i++) {
			int decimal = Integer.parseInt(strValues[i]);
			binaryValues[i] = "";

			//new code begin
			//find largest power of 2 that is <= the number
			int largestPower = 0;
			while (true) {
				if (decimal < Math.pow(2, largestPower)) {
					largestPower --;
					break;
				}
				largestPower ++;
			}

			//loop through each power of 2 and subtract if possible. Then add a 1 or 0 to string depending on the success of subtraction
			for (int ip = largestPower; ip >= 0; ip--) {
				if(decimal >= Math.pow(2,  ip)) {
					decimal -= Math.pow(2,  ip);
					binaryValues[i] += "1";
				}
				else {
					binaryValues[i] += "0";
				}

			}
			//new code end
		}

		//loop through binary values to print

		for (int i = 0; i < binaryValues.length; i++) {
			System.out.println(strValues[i] + " in binary is " + binaryValues[i]);
		}

	}

}
