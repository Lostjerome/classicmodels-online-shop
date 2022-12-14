package com.example.classicmodelsonlineshop;

import com.example.classicmodelsonlineshop.entities.Product;
import com.example.classicmodelsonlineshop.models.Cart;
import com.example.classicmodelsonlineshop.models.ClassicModelLineItem;
import com.example.classicmodelsonlineshop.repositories.ProductRepository;

public class TestCart {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        Product p = productRepository.find("S10_1949");

        System.out.println("Price: " + p.getMsrp());

        ClassicModelLineItem line = new ClassicModelLineItem(p);
        Cart<String, ClassicModelLineItem> cart = new Cart<>();


        System.out.println("Total price: " + cart.getTotalPrice());

        for (ClassicModelLineItem item : cart.getAllItem()) {
            System.out.println("Item: " + item.getProduct().getId() + ", amount: " + item.getQuantity());
        }

    }
}
