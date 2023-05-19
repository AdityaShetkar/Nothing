package com.order.Enums;

import java.util.Optional;

public enum OrderType {

    BUY("BUY"), SELL("SELL");

    private final String name;

    OrderType(String name) {
        this.name = name;
    }

    public static Optional<OrderType> getOrderStatus(String name) {

        for (OrderType v : values())
            if (v.name.equalsIgnoreCase(name)) return Optional.of(v);

        return Optional.empty();
    }

}
