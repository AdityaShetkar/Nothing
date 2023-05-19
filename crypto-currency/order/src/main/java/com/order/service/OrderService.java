package com.order.service;

import com.order.model.OrderDTO;

import java.util.UUID;

public interface OrderService {

    public OrderDTO createOrder(OrderDTO orderDTO);

    public OrderDTO updateOrder(OrderDTO orderDTO, UUID id);

    public void deleteOrder(UUID id);

    OrderDTO getOrderById(UUID id);

}
