package com.project.springapp.service;

import com.project.springapp.domain.Product;

import java.io.Serializable;
import java.util.List;

/**
 * Created by developer on 13/10/16.
 */
public interface ProductManager extends Serializable {
    public void increasePrice(int porcentage);
    public List<Product> getProducts();
}

