package com.example.classicmodelsonlineshop.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDetailID implements Serializable {
    private int orderNumber;
    private String productCode;

    public OrderDetailID() {
    }

}
