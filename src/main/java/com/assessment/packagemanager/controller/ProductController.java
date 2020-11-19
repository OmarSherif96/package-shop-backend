package com.assessment.packagemanager.controller;


import com.assessment.packagemanager.model.Product;
import com.assessment.packagemanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {


    private ProductService productService;

    private  final Logger logger = Logger.getLogger(getClass().getName());


    @Autowired
    public ProductController(ProductService theProductService) {
        productService = theProductService;
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @GetMapping(value = "/product")
    public List<Product> getProducts(){
        List<Product> products = productService.getProducts();
        return products;
    }



}

