package com.gucardev.productservice;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;

public abstract class BaseIntegrationTest {

  @Container public static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo");

  @DynamicPropertySource
  static void setProperties(DynamicPropertyRegistry properties) {
    properties.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
  }
}
