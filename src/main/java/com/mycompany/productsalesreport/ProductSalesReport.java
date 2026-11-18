/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productsalesreport;


import java.util.Scanner;

/**
 * Entry point for Q.1.1: captures monthly sales and prints the report.
 */
public class ProductSalesReport {

    private static final int NUMBER_OF_MONTHS = 3;

    public static void main(String[] args) {
        // Single-dimensional array of product names
        String[] productNames = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        // Two-dimensional array: rows = products, columns = months
        int[][] sales = new int[productNames.length][NUMBER_OF_MONTHS];

        Scanner input = new Scanner(System.in);

        // Outer loop = products, inner loop = months
        for (int product = 0; product < productNames.length; product++) {
            for (int month = 0; month < NUMBER_OF_MONTHS; month++) {
                sales[product][month] = readSales(input, month + 1, productNames[product]);
            }
            System.out.println(); // blank line between products
        }

        // Calculate via Product, print via PrintProduct
        Product product = new Product(productNames, sales);
        PrintProduct printer = new PrintProduct(product);
        printer.printReport();

        input.close();
    }

    // Prompts until a valid non-negative whole number is entered
    private static int readSales(Scanner input, int month, String productName) {
        while (true) {
            System.out.print("Enter number of sales for month " + month
                    + " for " + productName + " mattress: ");
            String entry = input.nextLine().trim();
            try {
                int value = Integer.parseInt(entry);
                if (value >= 0) {
                    return value;
                }
                System.out.println("Sales cannot be negative. Please try again.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }
}