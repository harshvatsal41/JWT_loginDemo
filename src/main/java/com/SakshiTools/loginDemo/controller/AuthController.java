package com.SakshiTools.loginDemo.controller;

import com.SakshiTools.loginDemo.model.Employee;
import com.SakshiTools.loginDemo.repository.EmployeeRepository;
import com.SakshiTools.loginDemo.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtService.generateToken(userDetails);
        System.out.println(token);
        return token;
    }

    @PostMapping("/register")
    public String register(@RequestBody Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
        return "Registration successful";
    }
}
