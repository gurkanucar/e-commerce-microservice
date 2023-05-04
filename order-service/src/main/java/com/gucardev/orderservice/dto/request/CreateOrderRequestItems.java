package com.gucardev.orderservice.dto.request;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequestItems {

  private String skuCode;
  private BigDecimal price;
  private Integer quantity;
}
