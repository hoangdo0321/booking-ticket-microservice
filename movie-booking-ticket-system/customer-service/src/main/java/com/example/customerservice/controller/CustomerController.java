package com.example.customerservice.controller;

import com.example.customerservice.entity.Customer;
import com.example.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private Environment env;
    @Autowired
    private CustomerService customerService;

//    @RequestMapping("/cus")
//    public String home(){
//        return "Hello from Customer Service running at port: " + env.getProperty("local.server.port");
//    }
//    @GetMapping("/create")
//    public List<Customer> createCustomers(){
//        return customerService.createCustomer();
//    }

}
