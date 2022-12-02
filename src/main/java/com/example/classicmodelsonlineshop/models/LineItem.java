package com.example.classicmodelsonlineshop.models;

import com.example.classicmodelsonlineshop.entities.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineItem implements CartItem {
    private Product product;
    private Double price;
    private Integer amount;

    private Double percentDiscount;

    public LineItem(Product product) {
        this(product, 1, 0.0);
    }

    public LineItem(Product product, Integer amount) {
        this(product, amount, 0.0);
    }

    public LineItem(Product product, Integer amount, Double perCentDiscount) {
        this.product = product;
        this.price = product.getMsrp().doubleValue();
        this.amount = amount;
        this.percentDiscount = perCentDiscount;
    }


    @Override
    public int getQuantity() {
        return amount;
    }

    @Override
    public void setQuantity(int quantity) {
        this.amount = quantity;
    }

    @Override
    public double getUnitPrice() {
        return price;
    }

    @Override
    public double getTotal() {
        return getUnitPrice() * getQuantity() -
                getUnitPrice() * getQuantity() * percentDiscount;
    }

    @Override
    public double getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    @Override
    public String toString() {
        return '{' + product.getProductName() +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

}
