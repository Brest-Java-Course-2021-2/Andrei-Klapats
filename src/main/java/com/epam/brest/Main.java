package com.epam.brest;



import java.io.*;
import java.math.BigDecimal;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // pricePerKg = getValueFromCon(scanner, "Enter pricePerKg:");
        //pricePerKm = getValueFromCon(scanner, "Enter pricePerKm:");


        BigDecimal weight, pricePerKg, length, pricePerKm;
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                weight = getValueFromCon(scanner, "Enter weight:");
                if (weight != null && weight.doubleValue() > 0) {
                    length = getValueFromCon(scanner, "Enter length:");
                    if (length != null && weight.doubleValue() > 0) {
                     //   pricePerKg = getValueFromFile(weight,"./resources/PricePerKg");
                       // pricePerKm = getValueFromFile(length,"./resources/PricePerKm");
                    }
                }

                // System.out.println("Result:" + new CalcImpl().handle(weight, pricePerKg, length, pricePerKm));
                // System.out.println("Enter 'q' for exit or 'c' to continue:");

            } while (!scanner.hasNext("q"));
        }
    }

    private static BigDecimal getValueFromCon(Scanner scanner, String outputMessage) {
        BigDecimal enteredValue = null;
        System.out.print(outputMessage);
        try {
            enteredValue = scanner.nextBigDecimal();
        } catch (Exception exception) {
            System.out.println("Error");
        }
        return enteredValue;


    }
    @SuppressWarnings("resources")
    private static BigDecimal getPriceKgFromFile(BigDecimal variable,String inputFileName)throws FileNotFoundException  {

       // Collection for tytel's value

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
