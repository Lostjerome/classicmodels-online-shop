package com.example.classicmodelsonlineshop.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", servletNames = {"OrderHistoryServlet", "AddToCartServlet", "OfficeListServlet"})
public class AuthenticationFilter implements Filter {
    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
//            res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("<br><br><h2 class='text-danger'>You must be logged in to access this page</h2>");
        } else {
            chain.doFilter(request, response);
        }
    }
}
