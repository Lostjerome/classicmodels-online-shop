package com.example.classicmodelsonlineshop.servlets;

import com.example.classicmodelsonlineshop.entities.Product;
import com.example.classicmodelsonlineshop.repositories.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductListServlet", value = "/product-list")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        ProductRepository productRepository = new ProductRepository();

        String pageParam = req.getParameter("page");
        String pageSizeParam = req.getParameter("pageSize");

        int page = pageParam == null ? 1 : Integer.valueOf(pageParam);
        int pageSize = pageSizeParam == null
                ? productRepository.getDefaulPageSize()
                : Integer.valueOf(pageSizeParam);

        List<Product> productList = productRepository.findAll(page, pageSize);

        req.setAttribute("page", page);
        req.setAttribute("pageSize", pageSize);
        req.setAttribute("products", productList);
        req.setAttribute("itemCount", productRepository.countAll());

        getServletContext().getRequestDispatcher("/ProductList.jsp").forward(req, res);
    }
}
