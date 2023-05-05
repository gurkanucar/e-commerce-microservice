package com.gucardev.orderservice.controller;

import com.gucardev.orderservice.dto.request.CreateOrderRequest;
import com.gucardev.orderservice.dto.response.OrderResponse;
import com.gucardev.orderservice.service.OrderService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

  private final OrderService orderService;
  private final ModelMapper mapper;

  public OrderController(OrderService orderService, ModelMapper mapper) {
    this.orderService = orderService;
    this.mapper = mapper;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<OrderResponse> placeOrder(@RequestBody CreateOrderRequest orderRequest) {
    return ResponseEntity.ok(
        mapper.map(orderService.placeOrder(orderRequest), OrderResponse.class));
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
    return ResponseEntity.ok(mapper.map(orderService.getOrderById(id), OrderResponse.class));
  }

  @GetMapping
  public ResponseEntity<List<OrderResponse>> getOrders() {
    return ResponseEntity.ok(
        orderService.getOrders().stream()
            .map(order -> mapper.map(order, OrderResponse.class))
            .toList());
  }
}
