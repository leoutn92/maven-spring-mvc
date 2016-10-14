package com.project.springapp.repository;

import com.project.springapp.domain.Product;

import java.util.List;

/**
 * Created by developer on 13/10/16.
 */
public interface ProductDao {
    public List<Product> getProductList();

    public void saveProduct(Product prod);

}
