package com.example.classicmodelsonlineshop;

import com.example.classicmodelsonlineshop.entities.Product;
import com.example.classicmodelsonlineshop.models.Cart;
import com.example.classicmodelsonlineshop.models.ClassicModelLineItem;
import com.example.classicmodelsonlineshop.repositories.ProductRepository;

public class TestCartModel {
    public static void main(String[] args) {
        Cart<String, ClassicModelLineItem> cart = new Cart<>();
        ProductRepository productRepository = new ProductRepository();
        Product product = productRepository.find("S10_1678");
        cart.addItem(product.getId(), new ClassicModelLineItem(product));
        product = productRepository.find("S10_1949");
        cart.addItem(product.getId(), new ClassicModelLineItem(product));
        System.out.println(cart.getNoOfItem());
        System.out.println(cart.getQuantity());
        System.out.println(cart.getTotalPrice());
        System.out.println(cart.getAllItem());
        cart.removeItem("S10_1678");
    }
}
