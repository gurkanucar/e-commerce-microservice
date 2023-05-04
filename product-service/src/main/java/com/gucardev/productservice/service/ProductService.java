package com.gucardev.productservice.service;

import com.gucardev.productservice.dto.request.CreateProductRequest;
import com.gucardev.productservice.model.Product;
import java.util.List;

public interface ProductService {

  List<Product> getProducts();

  Product getProductById(String id);

  Product createProduct(CreateProductRequest product);
}
