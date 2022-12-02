package com.example.classicmodelsonlineshop;

import com.example.classicmodelsonlineshop.entities.Product;
import com.example.classicmodelsonlineshop.models.Cart;
import com.example.classicmodelsonlineshop.models.LineItem;
import com.example.classicmodelsonlineshop.repositories.ProductRepository;

public class TestCart {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        Product p = productRepository.find("S10_1949");

        System.out.println("Price: " + p.getMsrp());

        LineItem line = new LineItem(p);
        Cart<String,LineItem> cart = new Cart<>();


        System.out.println("Total price: " + cart.getTotalPrice());

        for(LineItem item : cart.getAllItem()) {
            System.out.println("Item: " + item.getProduct().getId() + ", amount: " + item.getAmount());
        }

    }
}
