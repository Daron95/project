package com.nphase.entity;

import java.util.List;

public class ShoppingCart {
    private final List<Product> products;

    public int percentage = 1;

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
