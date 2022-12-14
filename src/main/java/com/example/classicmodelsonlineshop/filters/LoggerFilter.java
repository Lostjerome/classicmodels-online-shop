package com.example.classicmodelsonlineshop.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

//@WebFilter(filterName = "LoggerFilter", urlPatterns = "/*")
@WebFilter(filterName = "LoggerFilter")
public class LoggerFilter implements Filter {
    private FilterConfig config;

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        ขาเข้า
        long before = System.currentTimeMillis();
//        invoke resource
        chain.doFilter(request, response);
//        ขาออก
        HttpServletRequest req = (HttpServletRequest) request;
        long duration = System.currentTimeMillis() - before;
        String msg = "Servlet duration: " + req.getRequestURI() + duration + "ms";
        config.getServletContext().log(msg);
    }
}
