/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesreport;

/**
 * Responsible only for printing the report (Q.1.3).
 */
public class PrintProduct {

    private final Product product;

    public PrintProduct(Product product) {
        this.product = product;
    }

    // Prints the report heading and separator line
    public void printHeader() {
        System.out.println();
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println();
        System.out.println("*".repeat(40));
    }

    // Prints the total product sales
    public void printTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    // Prints the average, rounded to a whole number as in the sample
    public void printAverageProductSales() {
        System.out.println("AVERAGE PRODUCT SALES: " + Math.round(product.GetAverageProductSold()));
    }

    // Prints the most popular product with its highest monthly sale in brackets
    public void printMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct()
                + "(" + product.GetMostPopularProductHighestSale() + ")");
    }

    // Prints the complete report in order
    public void printReport() {
        printHeader();
        printTotalProductSales();
        printAverageProductSales();
        printMostPopularProduct();
    }
}
