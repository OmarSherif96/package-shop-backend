package com.assessment.packagemanager.service;

import com.assessment.packagemanager.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product>  getProducts();
    public Product getProductById(Integer id);
}
