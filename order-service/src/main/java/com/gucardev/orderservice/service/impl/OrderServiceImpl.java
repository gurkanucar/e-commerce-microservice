package com.gucardev.orderservice.service.impl;

import com.gucardev.orderservice.dto.request.CreateOrderRequest;
import com.gucardev.orderservice.dto.request.CreateOrderRequestItems;
import com.gucardev.orderservice.model.Order;
import com.gucardev.orderservice.model.OrderItem;
import com.gucardev.orderservice.repository.OrderRepository;
import com.gucardev.orderservice.service.OrderService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

  public OrderServiceImpl(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  @Transactional
  public Order placeOrder(CreateOrderRequest orderRequest) {

    var order =
        Order.builder()
            .orderNumber(UUID.randomUUID().toString())
            .orderItems(extractOrderItemsFromDto(orderRequest.getOrderItems()))
            .build();

    return orderRepository.save(order);
  }

  @Override
  public Order getOrderById(Long id) {
    return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("order not found!"));
  }

  @Override
  public List<Order> getOrders() {
    return orderRepository.findAll();
  }

  private List<OrderItem> extractOrderItemsFromDto(List<CreateOrderRequestItems> orderItems) {
    return orderItems.stream()
        .map(
            createOrderRequestItems ->
                OrderItem.builder()
                    .skuCode(createOrderRequestItems.getSkuCode())
                    .price(createOrderRequestItems.getPrice())
                    .quantity(createOrderRequestItems.getQuantity())
                    .build())
        .toList();
  }
}
