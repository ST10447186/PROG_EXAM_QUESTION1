/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.productsalesreport;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for Product (Q.1.4), using the sample screenshot data.
 */
public class ProductTest {

    private Product product;

    @BeforeEach
    public void setUp() {
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {
            {25, 18, 20},  // 63
            {15, 10, 12},  // 37
            {18, 15, 20}   // 53
        };
        product = new Product(names, sales);
    }

    // Unit Test 1: 63 + 37 + 53 = 153
    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(153, product.GetTotalProductsSold());
    }

    // Unit Test 2: 153 / 9 = 17
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(17.0, product.GetAverageProductSold(), 0.01);
    }
}