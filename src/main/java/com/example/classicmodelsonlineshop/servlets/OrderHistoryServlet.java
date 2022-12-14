package com.example.classicmodelsonlineshop.servlets;

import com.example.classicmodelsonlineshop.entities.Customer;
import com.example.classicmodelsonlineshop.repositories.OrderRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "OrderHistoryServlet", value = "/order-history")
public class OrderHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderRepository orderRepository = new OrderRepository();
        Customer customer = (Customer) request.getSession().getAttribute("user");
        request.setAttribute("orders", orderRepository.findByCustomerNumber(customer.getCustomerNumber()));
        getServletContext().getRequestDispatcher("/OrderHistory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
