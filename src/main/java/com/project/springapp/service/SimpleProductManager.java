package com.project.springapp.service;

import com.project.springapp.domain.Product;
import com.project.springapp.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by developer on 13/10/16.
 */
@Service
public class SimpleProductManager implements ProductManager {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ProductDao productDao;


    private List<Product> products;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getProducts() {

        return productDao.getProductList();
    }

    public void increasePrice(int percentage) {
        List<Product> products = productDao.getProductList();
        if (products != null) {
            for (Product product: products) {
                double newPrice = product.getPrice().doubleValue() *
                        (100+percentage)/100;
                product.setPrice(newPrice);
                productDao.saveProduct(product);
            };
        };
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
