package com.gucardev.orderservice.repository;

import com.gucardev.orderservice.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<Long, OrderItem> {}
