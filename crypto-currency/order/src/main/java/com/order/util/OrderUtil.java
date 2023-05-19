package com.order.util;


import com.order.Enums.OrderStatus;
import com.order.Enums.OrderType;
import com.order.constant.ConstantUtils;
import com.order.helper.OrderHelper;
import com.order.model.Order;
import com.order.model.OrderDTO;
import com.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderUtil {

    @Autowired
    private OrderRepository orderRepository;

    public Order settingValues(OrderDTO orderDTO) {
        Order order = OrderHelper.toEntity(orderDTO);
        order.setId(UUID.randomUUID());
        order.setOrderNumber(orderNumber());
        order.setOrderType(OrderType.BUY);
        order.setOrderStatus(OrderStatus.NEW);
        order.setCreatedDate(ConstantUtils.DATE);

        return order;
    }

    private String orderNumber() {
        int count = 1;
        String newOrderNumber = null;
        String countForOrderNumber = this.orderRepository.getOrderNumber();

        if (countForOrderNumber == null) {
            newOrderNumber = String.format(ConstantUtils.DATE + ConstantUtils.FORMAT, count);
        } else {
            int lastDigit = Character.getNumericValue(countForOrderNumber.charAt(countForOrderNumber.length() - 1));
            count = lastDigit + count;
            newOrderNumber = String.format(ConstantUtils.DATE + ConstantUtils.FORMAT, count);
        }
        return newOrderNumber;
    }
}
