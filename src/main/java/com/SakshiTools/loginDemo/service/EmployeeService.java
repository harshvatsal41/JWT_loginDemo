package com.SakshiTools.loginDemo.service;

import com.SakshiTools.loginDemo.model.Employee;
import com.SakshiTools.loginDemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Optional<Employee> findByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }
}