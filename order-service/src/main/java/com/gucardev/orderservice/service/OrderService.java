package com.gucardev.orderservice.service;

import com.gucardev.orderservice.dto.request.CreateOrderRequest;
import com.gucardev.orderservice.model.Order;

public interface OrderService {

  Order placeOrder(CreateOrderRequest orderRequest);
}
