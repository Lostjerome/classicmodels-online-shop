package com.example.classicmodelsonlineshop.servlets;

import com.example.classicmodelsonlineshop.entities.Customer;
import com.example.classicmodelsonlineshop.entities.Order;
import com.example.classicmodelsonlineshop.repositories.OrderRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "OrderDetailListServlet", value = "/order-detail-list")
public class OrderDetailListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer orderId = Integer.valueOf((request.getParameter("orderId")));
        OrderRepository orderRepository = new OrderRepository();
        Order order = orderRepository.find(orderId);

        request.getSession().setAttribute("order", order);
        getServletContext().getRequestDispatcher("/OrderDetailList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
