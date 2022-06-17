package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		String limitInput = userInput.nextLine();

		// FibNo equals the 2 previous numbers added together
		// 0 1 1 2 3 5 8
		// know the previous 2 numbers
		// previousFibNo - 1
		// currentFibNo - 2
		// temp = currentFibNo
		// currentFibNo = previousFibNo + currentFibNo
		// reviousFibNo = temp

		int limit = Integer.parseInt(limitInput);
		int previous = 1;
		System.out.print("0, 1");

		for (int next = 1; next <= limit;) {
			System.out.print(", " + next);
			int temp = previous + next;
			previous = next;
			next = temp;
		}
	}
}
