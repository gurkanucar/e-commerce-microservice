package com.gucardev.productservice.service.impl;

import com.gucardev.productservice.dto.request.CreateProductRequest;
import com.gucardev.productservice.model.Product;
import com.gucardev.productservice.repository.ProductRepository;
import com.gucardev.productservice.service.ProductService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public List<Product> getProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product getProductById(String id) {
    return productRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("product not found!"));
  }

  @Override
  public Product createProduct(CreateProductRequest productRequest) {
    Product product =
        Product.builder()
            .name(productRequest.getName())
            .description(productRequest.getDescription())
            .price(productRequest.getPrice())
            .build();
    return productRepository.save(product);
  }
}
