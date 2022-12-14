package com.example.classicmodelsonlineshop.servlets;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.classicmodelsonlineshop.entities.Customer;
import com.example.classicmodelsonlineshop.repositories.CustomerRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AuthenticationServlet", value = "/login")
public class AuthenticationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if (userName == null || userName.trim().length() == 0) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer = customerRepository.findByName(userName);

        if (customer == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray()
                    , customer.getPassword());
            if (!result.verified) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                System.out.println("Wrong password");
            } else {
                request.getSession().setAttribute("user", customer);
                response.sendRedirect("index.jsp");
            }
        }
    }
}
