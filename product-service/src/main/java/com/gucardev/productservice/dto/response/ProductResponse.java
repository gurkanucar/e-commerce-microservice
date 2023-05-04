package com.gucardev.productservice.dto.response;


import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class ProductResponse {
  private String id;
  private String name;
  private String description;
  private BigDecimal price;
}

