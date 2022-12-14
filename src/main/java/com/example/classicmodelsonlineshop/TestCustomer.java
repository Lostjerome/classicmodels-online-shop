package com.example.classicmodelsonlineshop;

import com.example.classicmodelsonlineshop.entities.Customer;
import com.example.classicmodelsonlineshop.repositories.CustomerRepository;
import jakarta.persistence.EntityManager;

import static com.example.classicmodelsonlineshop.repositories.EntityManagerBuilder.getEntityManager;

public class TestCustomer {
    public static void main(String[] args) {
        testCustomer();
    }

    public static void testCustomer() {
//        EntityManager em = getEntityManager();
        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer = customerRepository.findByName("Jean king");
        System.out.println(customer);
//        System.out.println(customer.getPassword());
        System.out.println(customer.getContactFirstName());
        System.out.println(customer.getContactLastName());
    }

}
