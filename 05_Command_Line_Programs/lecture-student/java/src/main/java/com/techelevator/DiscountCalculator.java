package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {
//    public int [] copyArray(int[] arrayToCopy){
//
//    }
    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {
        DiscountCalculator myDiscountCalculatorObject= new DiscountCalculator();


        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");
        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");
        String discountAmount= scanner.nextLine();
        double discountPercent= Double.parseDouble(discountAmount)/100;



        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String seriesOfPrices= scanner.nextLine();

        String[] pricesArray = seriesOfPrices.split(" ");
        for (String currentValue: pricesArray){
            double price= Double.parseDouble(currentValue);
            double salesPrice= price- (price* discountPercent);

            System.out.println("Sales price is "+ salesPrice);
        }


//        int[] numbersArray={42, 19,9};
//        System.out.println("numbersArray.length: "+ numbersArray.length);
//    for (int counter = 1; counter <=3; counter++){
//             System.out.println("counter: "+counter);
//
//         }
//        int [] copiedNumbersArray= new int[3];
//        copiedNumbersArray[0]= numbersArray[0];
//        copiedNumbersArray[1]= numbersArray[1];
//        copiedNumbersArray[2]= numbersArray[2];
//
//        for (int index=0; index< numbersArray.length; index++){
//            copiedNumbersArray[0]=numbersArray[numbersArray.length-1];
//            System.out.println(copiedNumbersArray);
//        }
//
//        System.out.println("Finished Copy: ");


    }

}