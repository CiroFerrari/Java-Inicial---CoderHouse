package com.ferrari.Facturacion.service;

import com.ferrari.Facturacion.model.Product;
import com.ferrari.Facturacion.model.RequestProductDetail;
import com.ferrari.Facturacion.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public Product postProduct(Product product) throws Exception {
    return productRepository.save(product);
  }

  public List<Product> getProductsById(List<RequestProductDetail> productListId) throws Exception {
    List<Product> productList = new ArrayList<>();
    for (RequestProductDetail requestProduct : productListId) {
      Optional<Product> productFound = productRepository.findById(requestProduct.getProductId());
      if (productFound.isEmpty()) {
        throw new Exception("Product with id: " + requestProduct.getProductId() + " not found.");
      }
      productList.add(productFound.get());
    }
    return productList;
  }
}
