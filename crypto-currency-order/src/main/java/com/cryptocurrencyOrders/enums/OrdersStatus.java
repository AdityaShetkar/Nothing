package com.cryptocurrencyOrders.enums;

import java.util.Optional;

public enum OrdersStatus {

    NEW("NEW"), PICKLIST("PICKLIST"), PICKED("PICKED"),
    SHIPPED("SHIPPED"), DELIVERED("DELIVERED"), RETURNED("RETURNED");

    private final String name;

    OrdersStatus(String name) {
        this.name = name;
    }

    public static Optional<OrdersStatus> getOrderStatus(String name) {

        for (OrdersStatus v : values())
            if (v.name.equalsIgnoreCase(name)) return Optional.of(v);

        return Optional.empty();
    }
}