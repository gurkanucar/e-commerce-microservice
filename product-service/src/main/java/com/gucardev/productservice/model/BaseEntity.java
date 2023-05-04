package com.gucardev.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class BaseEntity {

  @Id private String id;
}
