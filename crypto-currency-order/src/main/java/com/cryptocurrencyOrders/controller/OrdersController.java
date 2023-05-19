package com.cryptocurrencyOrders.controller;

import com.cryptocurrencyOrders.model.OrdersDTO;
import com.cryptocurrencyOrders.response.BaseResponse1;
import com.cryptocurrencyOrders.service.internalservices.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("/create-order")
    public ResponseEntity<OrdersDTO> createOrders(@Valid @RequestBody OrdersDTO orderDTO) {
        OrdersDTO createOrder = this.ordersService.createOrders(orderDTO);
        return new ResponseEntity<>(createOrder, HttpStatus.CREATED);
    }

    @PutMapping("/update-order")
    public ResponseEntity<OrdersDTO> updateOrder(@Valid @RequestBody OrdersDTO orderDTO, @RequestParam("id") UUID id) {
        OrdersDTO updatedOrder = this.ordersService.updateOrders(orderDTO, id);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/delete-order")
    public ResponseEntity<BaseResponse1> deleteOrder(@RequestParam("id") UUID id) {
        this.ordersService.deleteOrders(id);
        return new ResponseEntity<>(new BaseResponse1("Order Deleted Successfully..!", HttpStatus.OK.value()), HttpStatus.OK);
    }

    @GetMapping("/getOrder-byId")
    public ResponseEntity<OrdersDTO> getOrderById(@RequestParam("id") UUID id) {
        return ResponseEntity.ok(this.ordersService.getOrdersById(id));
    }
}
