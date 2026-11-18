/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesreport;


/**
 * Performs all calculations for the product sales report (Q.1.2).
 *
 * Data design:
 *  - productNames : single-dimensional array, one name per product
 *  - sales        : two-dimensional array, rows = products, columns = months
 */
public class Product implements IProduct {

    // Private so data is only accessed through the class methods (encapsulation)
    private final String[] productNames;
    private final int[][] sales;

    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;
    }

    // Adds up one product's sales across all months (shared helper, avoids duplicate loops)
    private int getProductTotal(int productIndex) {
        int productTotal = 0;
        for (int month = 0; month < sales[productIndex].length; month++) {
            productTotal += sales[productIndex][month];
        }
        return productTotal;
    }

    // Total of every product's sales over all months
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int product = 0; product < sales.length; product++) {
            total += getProductTotal(product);
        }
        return total;
    }

    // Average per entry: total / (products x months) -> 153 / 9 = 17
    @Override
    public double GetAverageProductSold() {
        int numberOfEntries = 0;
        for (int[] productSales : sales) {
            numberOfEntries += productSales.length;
        }

        // Guard against division by zero
        if (numberOfEntries == 0) {
            return 0;
        }
        return (double) GetTotalProductsSold() / numberOfEntries;
    }

    // Finds the product with the highest total sales
    @Override
    public String GetMostPopularProduct() {
        int bestIndex = 0;
        int bestTotal = getProductTotal(0);

        for (int product = 1; product < sales.length; product++) {
            int currentTotal = getProductTotal(product);
            if (currentTotal > bestTotal) {
                bestTotal = currentTotal;
                bestIndex = product;
            }
        }
        return productNames[bestIndex];
    }

    // Highest single monthly sale of the most popular product (the "(25)" in the sample)
    public int GetMostPopularProductHighestSale() {
        int bestIndex = indexOf(GetMostPopularProduct());
        int highest = sales[bestIndex][0];
        for (int month = 1; month < sales[bestIndex].length; month++) {
            if (sales[bestIndex][month] > highest) {
                highest = sales[bestIndex][month];
            }
        }
        return highest;
    }

    // Returns the array position of a product name
    private int indexOf(String name) {
        for (int i = 0; i < productNames.length; i++) {
            if (productNames[i].equals(name)) {
                return i;
            }
        }
        return 0;
    }
}