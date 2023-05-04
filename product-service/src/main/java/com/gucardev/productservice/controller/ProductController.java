package com.gucardev.productservice.controller;

import com.gucardev.productservice.dto.request.CreateProductRequest;
import com.gucardev.productservice.dto.response.ProductResponse;
import com.gucardev.productservice.service.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
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
  public List<ProductResponse> getProducts() {
    return productService.getProducts().stream()
        .map(product -> mapper.map(product, ProductResponse.class))
        .toList();
  }

  @GetMapping("/{id}")
  public ProductResponse getProductById(@PathVariable String id) {
    return mapper.map(productService.getProductById(id), ProductResponse.class);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductResponse createProduct(@Valid @RequestBody CreateProductRequest product) {
    return mapper.map(productService.createProduct(product), ProductResponse.class);
  }
}
