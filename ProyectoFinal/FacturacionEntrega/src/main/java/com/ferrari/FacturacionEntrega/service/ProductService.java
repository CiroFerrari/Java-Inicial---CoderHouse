package com.ferrari.FacturacionEntrega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferrari.FacturacionEntrega.model.Product;
import com.ferrari.FacturacionEntrega.model.RequestProductDetail;
import com.ferrari.FacturacionEntrega.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  // POST product
  public Product postProduct(Product product) throws Exception {
    try {
      product.setProductData(product.getTitle(), product.getDescription(), product.getStock(), product.getPrice(),
          product.getCode());
    } catch (IllegalArgumentException e) {
      throw new Exception("Error saving product: " + e.getMessage());
    }
    return productRepository.save(product);
  }

  // GET product by id
  public Product getProduct(int id) throws Exception {
    Optional<Product> producto = productRepository.findById(id);
    if (producto.isEmpty()) {
      return null;
    } else {
      return producto.get();
    }
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

  // Save product
  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  // GET all products
  public List<Product> getAllProducts() throws Exception {
    List<Product> productList = productRepository.findAll();
    if (productList.isEmpty()) {
      throw new Exception("No products found.");
    }
    return productList;
  }

  // PUT product by id: Puede recibir un objeto incompleto
  public Product putProduct(int id, Product product) throws Exception {
    Product existingProduct = getProduct(id);
    if (existingProduct == null) {
      throw new Exception("Product with id: " + id + ", not found");
    }
    if (product.getTitle() != null && !product.getTitle().isEmpty()) {
      existingProduct.setTitle(product.getTitle());
    }
    if (product.getDescription() != null && !product.getDescription().isEmpty()) {
      existingProduct.setDescription(product.getDescription());
    }
    if (product.getStock() != null) {
      existingProduct.setStock(product.getStock());
    }
    if (product.getPrice() != null) {
      existingProduct.setPrice(product.getPrice());
    }
    if (product.getCode() != null && !product.getCode().isEmpty()) {
      existingProduct.setCode(product.getCode());
    }
    try {
      existingProduct.setProductData(existingProduct.getTitle(), existingProduct.getDescription(),
          existingProduct.getStock(), existingProduct.getPrice(),
          existingProduct.getCode());
    } catch (IllegalArgumentException e) {
      throw new Exception("Error saving product: " + e.getMessage());
    }
    return productRepository.save(existingProduct);
  }

  // DELETE product by id: Retorna el producto eliminado para verificar
  public Product deleteProduct(int id) throws Exception {
    Product product = getProduct(id);
    if (product == null) {
      throw new Exception("Product with id: " + id + ", not found");
    }
    productRepository.deleteById(id);
    return product;
  }

}
