package com.example.classicmodelsonlineshop.servlets;

import com.example.classicmodelsonlineshop.entities.Customer;
import com.example.classicmodelsonlineshop.entities.Order;
import com.example.classicmodelsonlineshop.repositories.CustomerRepository;
import com.example.classicmodelsonlineshop.repositories.OrderRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderListServlet", value = "/order-list")
public class OrderListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = Integer.valueOf((request.getParameter("userId")));

        CustomerRepository customerRepository = new CustomerRepository();
        OrderRepository orderRepository = new OrderRepository();

        Customer customer = customerRepository.findByID(userId);
        List<Order> orders = orderRepository.findByCustomerNumber(userId);
        request.getSession().setAttribute("orders", orders);
        request.getSession().setAttribute("customer", customer);
        getServletContext().getRequestDispatcher("/OrderList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
