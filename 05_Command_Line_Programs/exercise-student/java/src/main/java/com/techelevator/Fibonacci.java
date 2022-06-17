package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
//		Scanner scanner= new Scanner(System.in);
//		System.out.println("Enter a number for our Fibonacci sequence: ");
//
//		int limit= Integer.parseInt(limitInput);
//		int previous=1;
//		System.out.println("0, 1");
//
//		for (int next=1; next <=limit;){
//			System.out.print(","+next);
//			int temp= previous+next;
//			previous=next;
//			next=temp;
//		}

		Scanner input = new Scanner(System.in);
		int sum = 0;
		int firstNum = 0;
		int secondNum = 1;
		String startingNums = "0, 1";

		System.out.println("Please enter the Fibonacci number: ");

		int upperBoundNum = input.nextInt();

		System.out.print(startingNums);
		while (sum < upperBoundNum) {
			sum = firstNum + secondNum;

			if (sum < upperBoundNum) {
				System.out.print(", " + sum);
				firstNum = secondNum;
				secondNum = sum;

			}
		}

		System.out.println();
	}

}
