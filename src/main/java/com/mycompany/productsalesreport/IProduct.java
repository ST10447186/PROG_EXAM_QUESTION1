/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesreport;

/**
 * Contract for the product sales calculations (Q.1.2).
 * Method names are kept exactly as specified in the question paper.
 */
public interface IProduct {

    // Returns the sum of all sales across every product and month
    int GetTotalProductsSold();

    // Returns the average number of sales per entry (total / number of entries)
    double GetAverageProductSold();

    // Returns the name of the product with the highest total sales
    String GetMostPopularProduct();
}
