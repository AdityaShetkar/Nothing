package com.order.controller;

import com.order.model.OrderDTO;
import com.order.response.BaseResponse1;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create-order")
    public ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        OrderDTO createOrder = this.orderService.createOrder(orderDTO);
        return new ResponseEntity<>(createOrder, HttpStatus.CREATED);
    }

    @PutMapping("/update-order")
    public ResponseEntity<OrderDTO> updateOrder(@Valid @RequestBody OrderDTO orderDTO, @RequestParam("id") UUID id) {
        OrderDTO updatedOrder = this.orderService.updateOrder(orderDTO, id);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/delete-order")
    public ResponseEntity<BaseResponse1> deleteOrder(@RequestParam("id") UUID id) {
        this.orderService.deleteOrder(id);
        return new ResponseEntity<>(new BaseResponse1("Order Deleted Successfully..!", HttpStatus.OK.value()), HttpStatus.OK);
    }

    @GetMapping("/getOrder-byId")
    public ResponseEntity<OrderDTO> getOrderById(@RequestParam("id") UUID id) {
        return ResponseEntity.ok(this.orderService.getOrderById(id));
    }
}