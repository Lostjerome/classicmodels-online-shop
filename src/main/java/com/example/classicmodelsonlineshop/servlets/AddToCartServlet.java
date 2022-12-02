package com.example.classicmodelsonlineshop.servlets;

import com.example.classicmodelsonlineshop.entities.Product;
import com.example.classicmodelsonlineshop.models.Cart;
import com.example.classicmodelsonlineshop.models.ClassicModelLineItem;
import com.example.classicmodelsonlineshop.repositories.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "AddToCartServlet", value = "/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productCode = req.getParameter("productCode");
        HttpSession session = req.getSession();
        Cart<String, ClassicModelLineItem> cart = (Cart<String, ClassicModelLineItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart<>();
            session.setAttribute("cart", cart);
        }
        ProductRepository productRepository = new ProductRepository();
        Product product = productRepository.find(productCode);
        if (product != null) {
            cart.addItem(productCode, new ClassicModelLineItem(product));
        }
        resp.getWriter().println(cart.getNoOfItem());
    }
}
