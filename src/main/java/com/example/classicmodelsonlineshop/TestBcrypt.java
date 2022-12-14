package com.example.classicmodelsonlineshop;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.classicmodelsonlineshop.entities.Customer;
import com.example.classicmodelsonlineshop.repositories.CustomerRepository;

public class TestBcrypt {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer = customerRepository.findByName("Jean king");
        System.out.println(customer.getPassword());

        String password = "123abc";

        System.out.println(customer.getPassword());
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), customer.getPassword());
        System.out.println(result.verified);
    }
}
