package com.order.service.impl;

import com.order.constant.ConstantUtils;
import com.order.exception.ResourceNotFoundException;
import com.order.helper.OrderHelper;
import com.order.model.Order;
import com.order.model.OrderDTO;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;
import com.order.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository ordersRepository;

    @Autowired
    private OrderUtil ordersUtil;

    @Override
    public OrderDTO createOrder(OrderDTO ordersDTO) {

        Order orders = this.ordersUtil.settingValues(ordersDTO);
        Order addedOrder = this.ordersRepository.save(orders);
        return OrderHelper.toDTO(addedOrder);
    }

    @Override
    public OrderDTO updateOrder(OrderDTO ordersDTO, UUID id) {

        Order orders = this.ordersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));

        orders.setUpdatedDate(ConstantUtils.DATE);
        if (ordersDTO.getQuantity() != null)
            orders.setQuantity(ordersDTO.getQuantity());

        if (ordersDTO.getAmount () != null)
            orders.setAmount(ordersDTO.getAmount());

        if (ordersDTO.getCryptoCurrencyId() != null)
            orders.setCryptoCurrencyId(ordersDTO.getCryptoCurrencyId());

        if (ordersDTO.getOrderType() != null)
            orders.setOrderType(ordersDTO.getOrderType());

        if (ordersDTO.getOrderStatus() != null)
            orders.setOrderStatus(ordersDTO.getOrderStatus());

        Order updatedOrder = this.ordersRepository.save(orders);
        OrderDTO ordersDTO1 = OrderHelper.toDTO(updatedOrder);
        return ordersDTO1;

    }

    @Override
    public void deleteOrder(UUID id) {
        Order orders = this.ordersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));

        this.ordersRepository.delete(orders);

    }

    @Override
    public OrderDTO getOrderById(UUID id) {
        Order orders = this.ordersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));

        return OrderHelper.toDTO(orders);

    }
}
