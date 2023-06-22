package com.example.customerservice.service;

import com.example.customerservice.entity.Customer;
import com.example.customerservice.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;
//    public List<Customer> createCustomer(){
//        var cus1     = Customer.builder().username("hoang")
//                .password("1234")
//                .fullName("Do Minh Hoang")
//                .age(23)
//                .email("hoang@gmail.com")
//                .tel("09234893289").build();
//        var cus2 = Customer.builder().username("kiet")
//                .password("567")
//                .fullName("Vu Ba Kiet")
//                .idCard("8932742932")
//                .age(23)
//                .email("kiet@gmail.com")
//                .tel("097382874").build();
//        var cus3 = Customer.builder().username("quynh")
//                .password("1234")
//                .fullName("Diem Quynh")
//                .idCard("8927349821")
//                .age(23)
//                .email("quynh@gmail.com")
//                .tel("0937885493").build();
//        return customerRepo.saveAll(List.of(cus1, cus2, cus3));
//    }
}
