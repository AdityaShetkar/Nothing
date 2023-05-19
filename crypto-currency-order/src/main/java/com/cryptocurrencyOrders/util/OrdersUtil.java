package com.cryptocurrencyOrders.util;

import com.cryptocurrencyOrders.constant.ConstantUtils;
import com.cryptocurrencyOrders.enums.OrdersStatus;
import com.cryptocurrencyOrders.helper.OrdersHelper;
import com.cryptocurrencyOrders.model.Orders;
import com.cryptocurrencyOrders.model.OrdersDTO;
import com.cryptocurrencyOrders.repository.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class OrdersUtil {

    @Autowired
    private OrdersRepository ordersRepository;

    public Orders settingValues(OrdersDTO ordersDTO) {
        Orders orders = OrdersHelper.toEntity(ordersDTO);
        orders.setId(UUID.randomUUID());
        orders.setOrdersNumber(orderNumber());
        orders.setOrdersStatus(OrdersStatus.NEW.name());
        orders.setCreatedDate(ConstantUtils.DATE);

        return orders;
    }

    private String orderNumber() {
        int count = 1;
        String newOrderNumber = null;
        String countForOrderNumber = this.ordersRepository.getOrdersNumber();

        if (countForOrderNumber == null) {
            newOrderNumber = String.format(ConstantUtils.DATE + ConstantUtils.FORMAT, count);
        } else {
            int lastDigit = Character.getNumericValue(countForOrderNumber.charAt(countForOrderNumber.length() - 1));
            count = lastDigit + count;
            newOrderNumber = String.format(ConstantUtils.DATE + ConstantUtils.FORMAT, count);
            log.info("new account Number " + newOrderNumber);
        }
        return newOrderNumber;
    }
}
