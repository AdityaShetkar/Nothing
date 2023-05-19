package com.cryptocurrencyOrders.helper;

import com.cryptocurrencyOrders.model.Orders;
import com.cryptocurrencyOrders.model.OrdersDTO;
import com.cryptocurrencyOrders.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrdersHelper {

    public static OrdersDTO toDTO(Orders orders) {
        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO.setBuyerUserId(orders.getBuyerUserId());
        ordersDTO.setSellerUserId(orders.getSellerUserId());
        ordersDTO.setPrice(orders.getPrice());
        ordersDTO.setOrdersType(orders.getOrdersType());
        ordersDTO.setUserId(orders.getUserId());
        ordersDTO.setBuyQuantity(orders.getBuyQuantity());
        ordersDTO.setSellQuantity(orders.getSellQuantity());
        ordersDTO.setExecutedQuantity(orders.getExecutedQuantity());

        return ordersDTO;
    }

    public static Orders toEntity(OrdersDTO ordersDTO) {
        Orders orders = new Orders();
        orders.setBuyerUserId(ordersDTO.getBuyerUserId());
        orders.setSellerUserId(ordersDTO.getSellerUserId());
        orders.setPrice(ordersDTO.getPrice());
        orders.setOrdersType(ordersDTO.getOrdersType());
        orders.setUserId(ordersDTO.getUserId());
        orders.setBuyQuantity(ordersDTO.getBuyQuantity());
        orders.setSellQuantity(ordersDTO.getSellQuantity());
        orders.setExecutedQuantity(ordersDTO.getExecutedQuantity());

        return orders;
    }

}
