package com.assessment.packagemanager.dao;

import com.assessment.packagemanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
