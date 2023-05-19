package com.cryptocurrencyOrders.service.impl;

import com.cryptocurrencyOrders.constant.ConstantUtils;
import com.cryptocurrencyOrders.exception.ResourceNotFoundException;
import com.cryptocurrencyOrders.exception.ValidatorException;
import com.cryptocurrencyOrders.helper.OrdersHelper;
import com.cryptocurrencyOrders.model.Orders;
import com.cryptocurrencyOrders.model.OrdersDTO;
import com.cryptocurrencyOrders.repository.OrdersRepository;
import com.cryptocurrencyOrders.service.internalservices.OrdersService;
import com.cryptocurrencyOrders.util.OrdersUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrdersUtil ordersUtil;

    @Override
    public OrdersDTO createOrders(OrdersDTO ordersDTO) {
        if (ordersDTO.getBuyerUserId() == ordersDTO.getSellerUserId()) {
            throw new ValidatorException(ConstantUtils.BUYER_AND_SELLER_SHOULD_NOT_BE_SAME);
        }
        Orders orders = this.ordersUtil.settingValues(ordersDTO);
        Orders addedOrders = this.ordersRepository.save(orders);
        return OrdersHelper.toDTO(addedOrders);
    }

    @Override
    public OrdersDTO updateOrders(OrdersDTO ordersDTO, UUID id) {

        Orders orders = this.ordersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));

        orders.setUpdatedDate(ConstantUtils.DATE);
        if (ordersDTO.getBuyerUserId() != null)
            orders.setBuyerUserId(ordersDTO.getBuyerUserId());

        if (ordersDTO.getSellerUserId() != null)
            orders.setSellerUserId(ordersDTO.getSellerUserId());

        if (ordersDTO.getPrice() != null)
            orders.setPrice(ordersDTO.getPrice());

        if (ordersDTO.getOrdersType() != null)
            orders.setOrdersType(ordersDTO.getOrdersType());

        if (ordersDTO.getUserId() != null)
            orders.setUserId(ordersDTO.getUserId());

        if (ordersDTO.getBuyQuantity() != null)
            orders.setBuyQuantity(ordersDTO.getBuyQuantity());

        if (ordersDTO.getSellQuantity() != null)
            orders.setSellQuantity(ordersDTO.getSellQuantity());

        if (ordersDTO.getExecutedQuantity() != null)
            orders.setExecutedQuantity(ordersDTO.getExecutedQuantity());


        Orders updatedOrder = this.ordersRepository.save(orders);
        OrdersDTO ordersDTO1 = OrdersHelper.toDTO(updatedOrder);
        return ordersDTO1;

    }

    @Override
    public void deleteOrders(UUID id) {
        Orders orders = this.ordersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));

        this.ordersRepository.delete(orders);

    }

    @Override
    public OrdersDTO getOrdersById(UUID id) {
        Orders orders = this.ordersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));

        return OrdersHelper.toDTO(orders);

    }

//    private void userDetailsById( UUID buyersId, UUID sellerId ){
//        if (buyersId == null || sellerId == null){
//            throw new ValidatorException(ConstantUtils.SOMETHING_WENT_WRONG);
//        }
//        var buyersResponseEntity = userFeignClientService.userById(buyersId);
//        var sellerResponseEntity = userFeignClientService.userById(sellerId);
//        if (Objects.requireNonNull(buyersResponseEntity.getBody().getData()) == null || buyersResponseEntity.getStatusCodeValue()!=200){
//            throw  new ValidatorException(ConstantUtils.BUYER_NOT_FOUND);
//        }
//        if (Objects.requireNonNull(sellerResponseEntity.getBody().getData())== null || sellerResponseEntity.getStatusCodeValue()!=200){
//            throw  new ValidatorException(ConstantUtils.SELLER_NOT_FOUND);
//        }

    //        if ( userDTO.getId() != buyersId){
//            throw  new ValidatorException(ConstantUtils.BUYER_NOT_FOUND);
//        } else if (userDTO.getId() != sellerId) {
//            throw new ValidatorException(ConstantUtils.SELLER_NOT_FOUND);
//        }
    {

    }
}

