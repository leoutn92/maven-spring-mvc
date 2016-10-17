package com.project.springapp.repository;

import com.project.springapp.domain.Product;

import java.util.List;

/**
 * Created by developer on 14/10/16.
 */
public class InMemoryProductDao implements ProductDao {

    private List<Product> productList;

    public InMemoryProductDao(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void saveProduct(Product prod) {

    }
}
