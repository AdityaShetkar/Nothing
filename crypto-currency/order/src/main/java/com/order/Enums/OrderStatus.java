package com.order.Enums;

import java.util.Optional;

public enum OrderStatus {

    NEW("NEW"), CANCELLED("CANCELLED");

    private final String name;

    OrderStatus(String name) {
        this.name = name;
    }

    public static Optional<OrderStatus> getOrderStatus(String name) {

        for (OrderStatus v : values())
            if (v.name.equalsIgnoreCase(name)) return Optional.of(v);

        return Optional.empty();
    }
}
