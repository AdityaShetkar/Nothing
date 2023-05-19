package com.order.helper;

import com.order.model.Order;
import com.order.model.OrderDTO;

public class OrderHelper {

    public static OrderDTO toDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(order.getUserId());
        orderDTO.setCryptoCurrencyId(order.getCryptoCurrencyId());
        orderDTO.setQuantity(order.getQuantity());
        orderDTO.setAmount(order.getAmount());
        orderDTO.setOrderType(order.getOrderType());
        orderDTO.setOrderStatus(order.getOrderStatus());

        return orderDTO;
    }

    public static Order toEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setUserId(orderDTO.getUserId());
        order.setCryptoCurrencyId(orderDTO.getCryptoCurrencyId());
        order.setQuantity(orderDTO.getQuantity());
        order.setAmount(orderDTO.getAmount());
        order.setOrderType(orderDTO.getOrderType());
        order.setOrderStatus(orderDTO.getOrderStatus());

        return order;
    }
}
