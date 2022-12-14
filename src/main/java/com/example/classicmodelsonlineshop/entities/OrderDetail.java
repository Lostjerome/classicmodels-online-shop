package com.example.classicmodelsonlineshop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ForeignKey;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "orderdetails")
@IdClass(OrderDetailID.class)
public class OrderDetail {
    @Id
    private int orderNumber;
    @Id
    private String productCode;
    private int quantityOrdered;
    private double priceEach;
    private int orderLineNumber;
}
