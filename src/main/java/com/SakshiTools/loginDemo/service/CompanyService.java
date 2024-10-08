package com.SakshiTools.loginDemo.service;

import com.SakshiTools.loginDemo.model.Company;
import com.SakshiTools.loginDemo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}