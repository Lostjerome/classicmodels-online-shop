package com.example.classicmodelsonlineshop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class OrderDetailID implements Serializable {
    private int orderNumber;
    private String productCode;

    public OrderDetailID() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetailID that = (OrderDetailID) o;

        if (orderNumber != that.orderNumber) return false;
        return productCode != null ? productCode.equals(that.productCode) : that.productCode == null;
    }

    @Override
    public int hashCode() {
        int result = orderNumber;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        return result;
    }
}
