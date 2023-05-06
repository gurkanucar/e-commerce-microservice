package com.gucardev.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.gucardev.productservice", "com.gucardev.common"})
public class ProductServiceApplication {

  public static void main(String[] args) {

    SpringApplication.run(ProductServiceApplication.class, args);
  }
}
