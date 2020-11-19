package com.assessment.packagemanager.service;

import com.assessment.packagemanager.dao.PackageRepository;
import com.assessment.packagemanager.dao.ProductRepository;
import com.assessment.packagemanager.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

@Service
public class ProductServiceImpl implements ProductService {

    ObjectMapper objectMapper = new ObjectMapper();


    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository theProductRepository){
        productRepository= theProductRepository;
    }


    @Override
    public List<Product> getProducts() {
        try {
            return productRepository.findAll();
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Product getProductById(Integer id) {
        return null;
    }

}
