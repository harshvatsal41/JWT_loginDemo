package com.SakshiTools.loginDemo.controller;

import com.SakshiTools.loginDemo.model.Company;
import com.SakshiTools.loginDemo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public Company addCompany(@RequestBody Company company) {
        return companyService.addCompany(company);
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }
}