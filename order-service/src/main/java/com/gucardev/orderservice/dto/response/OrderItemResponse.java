package com.gucardev.orderservice.dto.response;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponse {
  private Long id;
  private String skuCode;
  private BigDecimal price;
  private Integer quantity;
}
