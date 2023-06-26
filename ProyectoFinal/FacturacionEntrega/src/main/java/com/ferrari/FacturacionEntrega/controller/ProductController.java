package com.ferrari.FacturacionEntrega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferrari.FacturacionEntrega.middleware.ResponseHandler;
import com.ferrari.FacturacionEntrega.model.Product;
import com.ferrari.FacturacionEntrega.service.ProductService;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
  @Autowired
  private ProductService productService;

  // POST product
  @PostMapping
  public ResponseEntity<Object> postProduct(@RequestBody Product product) {
    try {
      System.out.println(product);
      Product productSaved = productService.postProduct(product);
      return ResponseHandler.generateResponse(
          "Data retrieved successfully",
          HttpStatus.OK,
          productSaved);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  // GET product by id
  @GetMapping(path = "{id}")
  public ResponseEntity<Object> getProduct(@PathVariable() int id) {
    try {
      System.out.println("Product ID: " + id);
      Product productFound = productService.getProduct(id);
      System.out.println("PRODUCT FOUND");
      System.out.println(productFound);
      return ResponseHandler.generateResponse(
          "Product found successfully",
          HttpStatus.OK,
          productFound);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  // GET all products
  @GetMapping
  public ResponseEntity<Object> getAllProducts() {
    try {
      return ResponseHandler.generateResponse(
          "Data retrieved successfully",
          HttpStatus.OK,
          productService.getAllProducts());
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  // PUT product by id
  @PutMapping(path = "{id}")
  public ResponseEntity<Object> putProduct(@PathVariable() int id, @RequestBody Product product) {
    try {
      System.out.println(id);
      Product productUpdated = productService.putProduct(id, product);
      return ResponseHandler.generateResponse(
          "Product updated successfully",
          HttpStatus.OK,
          productUpdated);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  // DELETE product by id
  @DeleteMapping(path = "{id}")
  public ResponseEntity<Object> deleteProduct(@PathVariable() int id) {
    try {
      System.out.println(id);
      Product productDeleted = productService.deleteProduct(id);
      return ResponseHandler.generateResponse(
          "Product deleted successfully",
          HttpStatus.OK,
          productDeleted);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

}
