package com.project.springapp.service;

import com.project.springapp.domain.Product;

import java.util.List;

/**
 * Created by developer on 13/10/16.
 */

public class SimpleProductManager implements ProductManager {

    private static final long serialVersionUID = 1L;

    private List<Product> products;


    public List<Product> getProducts() {
        return products;
    }

    public void increasePrice(int percentage) {
        if (products != null) {
            for (Product product: products) {
                double newPrice = product.getPrice().doubleValue() *
                        (100+percentage)/100;
                product.setPrice(newPrice);
            };
        };
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
