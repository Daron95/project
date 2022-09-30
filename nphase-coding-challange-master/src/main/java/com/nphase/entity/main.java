package com.nphase.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        String name = "tea";
        BigDecimal pricePerUnit = new BigDecimal("5.3");
        int quantity = 2;
        String category = "drinks";
        Product product1 = new Product(name, pricePerUnit, quantity, category);

        name = "coffee";
        pricePerUnit = new BigDecimal("3.5");
        quantity = 2;
        Product product2 = new Product(name, pricePerUnit, quantity, category);

        name = "cheese";
        pricePerUnit = new BigDecimal("8");
        quantity = 2;
        category = "food";
        Product product3 = new Product(name, pricePerUnit, quantity, category);


        final List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        ShoppingCart shoppingCart = new ShoppingCart(products);

        ShoppingCartService s = new ShoppingCartService();

        System.out.println("Expected total is: " + s.calculateTotalPrice(shoppingCart));
    }
}
