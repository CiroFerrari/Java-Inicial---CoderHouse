package com.ferrari.FacturacionSegundaEntrega.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferrari.FacturacionSegundaEntrega.model.Product;
import com.ferrari.FacturacionSegundaEntrega.repository.ProductRepository;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public Product postProduct(Product product) throws Exception {
    try {
      System.out.println(product);
      if (product.getPrice() == 0) {
        throw new Exception("Price is required");
      }
      if (product.getStock() == 0) {
        throw new Exception("Stock is required");
      }
      if (product.getCode().isEmpty()) {
        throw new Exception("Code is required");
      }
      if (product.getDescription().isEmpty()) {
        throw new Exception("Description is required");
      }
      return productRepository.save(product);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public Product getProduct(int id) throws Exception {
    Optional<Product> producto = productRepository.findById(id);
    if (producto.isEmpty()) {
      return null;
    } else {
      return producto.get();
    }
  }
  
}
