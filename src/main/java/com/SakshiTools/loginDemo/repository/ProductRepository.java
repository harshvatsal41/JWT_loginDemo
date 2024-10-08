package com.SakshiTools.loginDemo.repository;

import com.SakshiTools.loginDemo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}