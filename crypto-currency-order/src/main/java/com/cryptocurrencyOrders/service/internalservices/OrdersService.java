package com.cryptocurrencyOrders.service.internalservices;

import com.cryptocurrencyOrders.model.OrdersDTO;

import java.util.UUID;

public interface OrdersService {

    public OrdersDTO createOrders(OrdersDTO ordersDTO);

    public OrdersDTO updateOrders(OrdersDTO ordersDTO, UUID id);

    public void deleteOrders(UUID id);

    OrdersDTO getOrdersById(UUID id);

}
