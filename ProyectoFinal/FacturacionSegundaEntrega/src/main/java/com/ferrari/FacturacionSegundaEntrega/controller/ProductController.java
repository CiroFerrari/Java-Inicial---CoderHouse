package com.ferrari.FacturacionSegundaEntrega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferrari.FacturacionSegundaEntrega.middleware.ResponseHandler;
import com.ferrari.FacturacionSegundaEntrega.model.Product;
import com.ferrari.FacturacionSegundaEntrega.service.ProductService;

@RestController
@RequestMapping(path = "/api/v1/product")
public class ProductController {

  @Autowired
  private ProductService productService;

  // CRUD Product

  // Create Product
  @PostMapping
  public ResponseEntity<Object> postProduct (@RequestBody Product product) {
    try {
      System.out.println(product);
      Product productSaved = productService.postProduct(product);
      return ResponseHandler.generateResponse(
        "Product saved successfully",
        HttpStatus.OK,
        productSaved
      );
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
        e.getMessage(),
        HttpStatus.INTERNAL_SERVER_ERROR,
        null
      );
    }
  }

  // Get product
  @GetMapping(path = "{id}")
  public ResponseEntity<Object> getProduct (@PathVariable() int id) {
    try {
      System.out.println("Product ID: " + id);
      Product productFound = productService.getProduct(id);
      System.out.println("PRODUCT FOUND");
      System.out.println(productFound);
      return ResponseHandler.generateResponse(
        "Product found successfully",
        HttpStatus.OK,
        productFound
      );
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
        e.getMessage(),
        HttpStatus.INTERNAL_SERVER_ERROR,
        null
      );
    }
  }
  
}
