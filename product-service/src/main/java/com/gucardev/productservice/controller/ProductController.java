package com.gucardev.productservice.controller;

import com.gucardev.common.response.ApiResponse;
import com.gucardev.productservice.dto.request.CreateProductRequest;
import com.gucardev.productservice.dto.response.ProductResponse;
import com.gucardev.productservice.service.ProductService;
import jakarta.validation.Valid;
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
@RequestMapping("/api/product")
public class ProductController {

  private final ProductService productService;
  private final ModelMapper mapper;

  public ProductController(ProductService productService, ModelMapper mapper) {
    this.productService = productService;
    this.mapper = mapper;
  }

  @GetMapping
  public ResponseEntity<ApiResponse<Object>> getProducts() {
    return ApiResponse.builder()
        .data(
            productService.getProducts().stream()
                .map(product -> mapper.map(product, ProductResponse.class))
                .toList())
        .build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<Object>> getProductById(@PathVariable String id) {
    return ApiResponse.builder()
        .data(mapper.map(productService.getProductById(id), ProductResponse.class))
        .build();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<ApiResponse<Object>> createProduct(
      @Valid @RequestBody CreateProductRequest product) {
    return ApiResponse.builder()
        .data(mapper.map(productService.createProduct(product), ProductResponse.class))
        .build();
  }
}
