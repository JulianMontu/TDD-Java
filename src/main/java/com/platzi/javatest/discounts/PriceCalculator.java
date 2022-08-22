package com.platzi.javatest.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
    private List<Double> prices = new ArrayList<>();
    private double discount = 0;

    public Object getTotal() {
        double result = 0;
        for (double price : prices) {
            result += price;

        }
        return result * ((100-discount)/100);
    }

    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
