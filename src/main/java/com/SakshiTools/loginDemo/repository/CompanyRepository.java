package com.SakshiTools.loginDemo.repository;

import com.SakshiTools.loginDemo.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String> {
}