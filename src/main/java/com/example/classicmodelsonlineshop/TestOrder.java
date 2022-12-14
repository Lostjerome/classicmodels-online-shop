package com.example.classicmodelsonlineshop;

import com.example.classicmodelsonlineshop.entities.Customer;
import com.example.classicmodelsonlineshop.entities.Order;
import com.example.classicmodelsonlineshop.entities.OrderDetail;
import com.example.classicmodelsonlineshop.repositories.CustomerRepository;
import com.example.classicmodelsonlineshop.repositories.OrderDetailRepository;
import com.example.classicmodelsonlineshop.repositories.OrderRepository;

import java.util.List;

public class TestOrder {
    public static void main(String[] args) {
        OrderRepository orderRepository = new OrderRepository();
        OrderDetailRepository orderDetailRepository = new OrderDetailRepository();
        CustomerRepository customerRepository = new CustomerRepository();

        Integer customerNumber = customerRepository.findByName("Jean King").getCustomerNumber();

        List<Order> order = orderRepository.findByCustomerNumber(customerNumber);
//        list all order
        for (Order o : order) {
            System.out.printf("Order number: %d, order date: %s, required date: %s, shipped date: %s, status: %s, customer number: %d\n", o.getOrderNumber(), o.getOrderDate(), o.getRequiredDate(), o.getShippedDate(), o.getStatus(), o.getCustomerNumber());
        }
//        break line
        System.out.println();
        System.out.println();
        for (OrderDetail od : order.get(0).getOrderDetails()) {
//            OrderDetail od = order.get(0).getOrderDetails().get(1);
            System.out.printf("Product Code: %s, Quantity: %d, Price: %f, Discount: %d%n"
                    , od.getProductCode(), od.getQuantityOrdered(), od.getPriceEach(), od.getOrderLineNumber());
        }
        System.out.println(orderDetailRepository.findByOrderNumber(order.get(0).getOrderNumber()));

    }
}

//String.format("Order number: %d, Product code: %s, Quantity: %d, Price: %s, Order line number: %d",
//        o.getOrderNumber(),
//        od.getProductCode(),
//        od.getQuantityOrdered(),
//        od.getPriceEach(),
//        od.getOrderLineNumber())