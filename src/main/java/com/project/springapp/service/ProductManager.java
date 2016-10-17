package com.project.springapp.service;

import com.project.springapp.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by developer on 13/10/16.
 */
@Service
public interface ProductManager extends Serializable {
    public void increasePrice(int porcentage);
    public List<Product> getProducts();
}

