package com.ferrari.FacturacionEntrega.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String title;
  private String description;
  private int stock;
  private double price;
  private String code;

  // Validación de datos
  public void setProductData(String title, String description, int stock, double price, String code)
      throws IllegalArgumentException {
    if (title == null || title.isEmpty()) {
      throw new IllegalArgumentException("Title cannot be empty");
    }
    if (description == null || description.isEmpty()) {
      throw new IllegalArgumentException("Description cannot be empty");
    }
    if (code == null || code.isEmpty()) {
      throw new IllegalArgumentException("Code cannot be empty");
    }
    try {
      Integer.parseInt(String.valueOf(stock));
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Stock must be a number");
    }
    try {
      Double.parseDouble(String.valueOf(price));
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Price must be a number");
    }
    this.title = title;
    this.description = description;
    this.stock = stock;
    this.price = price;
    this.code = code;
  }

  // Getters y Setters
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  // toString
  @Override
  public String toString() {
    return "Product [code=" + code + ", description=" + description + ", price=" + price + ", stock=" + stock
        + ", title=" + title + "]";
  }
}