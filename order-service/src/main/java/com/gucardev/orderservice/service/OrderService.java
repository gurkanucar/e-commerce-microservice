package com.gucardev.orderservice.service;

import com.gucardev.orderservice.dto.request.CreateOrderRequest;
import com.gucardev.orderservice.model.Order;
import java.util.List;

public interface OrderService {

  Order placeOrder(CreateOrderRequest orderRequest);

  Order getOrderById(Long id);

  List<Order> getOrders();
}
