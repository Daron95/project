package com.nphase.service;

import com.nphase.entity.ShoppingCart;

import javax.naming.OperationNotSupportedException;
import java.math.BigDecimal;

public class ShoppingCartService {

    public BigDecimal calculateTotalPrice(ShoppingCart shoppingCart) {

        shoppingCart.setPercentage(10);   // example : 10% // configurable
        ArrayList<String> repeatedCategories = new ArrayList<>();
        List<Product> products = shoppingCart.getProducts();

        for (int j = 0; j < products.size(); j++) {
            for (int i = 0; i < products.size(); i++) {
                if (i != j) {
                    if (products.get(i).getCategory().equals(products.get(j).getCategory())) {
                        if (!repeatedCategories.contains(products.get(i).getCategory()))
                            repeatedCategories.add(products.get(i).getCategory());
                    }}}}

        //buying more than 3 items of the product within the same category
        // OR!!   more than 3 items of the same product
        //  ==>>  discount 10 %
        for (Product product : shoppingCart.getProducts()) {
            if (repeatedCategories.contains(product.getCategory()) || product.getQuantity() > 3) {
                product.setPricePerUnit(product.getPricePerUnit().subtract(product.getPricePerUnit().divide(BigDecimal.valueOf((shoppingCart.getPercentage())))));
            }
        }

        return shoppingCart.getProducts()
                .stream().map(product -> product.getPricePerUnit().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
