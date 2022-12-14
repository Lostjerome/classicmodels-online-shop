package com.example.classicmodelsonlineshop.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@NamedQueries({
        @NamedQuery(name = "Product.FindAll", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Product.count", query = "SELECT COUNT(p) as count FROM Product p"),
})
@Table(name = "products", indexes = {
        @Index(name = "productLine", columnList = "productLine"),
})
@Entity
public class Product {
    @Id
    @Column(name = "productCode", nullable = false, length = 15)
    private String id;
    @Column(name = "productName", nullable = false, length = 70)
    private String productName;
    @Column(name = "productLine", nullable = false, length = 50)
    private String productLine;
    @Column(name = "productScale", nullable = false, length = 10)
    private String productScale;
    private String productVendor;
    private String productDescription;
    @Column(name = "quantityInStock")
    private Integer quantityInStock;
    private BigDecimal buyPrice;
    private BigDecimal msrp;

}
