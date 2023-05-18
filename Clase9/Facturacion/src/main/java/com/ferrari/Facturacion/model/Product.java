package com.ferrari.Facturacion.model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String description;
  private String code;
  private double price;
  private int stock;

  // Getters y setters
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  public double getPrice() {
    return price;
  }
  public void setPrice(double price) {
    this.price = price;
  }

  public int getStock() {
    return stock;
  }
  public void setStock(int stock) {
    this.stock = stock;
  }

  // Override toString
  @Override
  public String toString() {
    return "Producto{" +
        "id=" + id +
        ", description='" + description + '\'' +
        ", code='" + code + '\'' +
        ", price=" + price +
        ", stock=" + stock +
        '}';
  }

  // Override equals
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Product)) return false;
    Product producto = (Product) o;
    return getId() == producto.getId() &&
        Double.compare(producto.getPrice(), getPrice()) == 0 &&
        getStock() == producto.getStock() &&
        getDescription().equals(producto.getDescription()) &&
        getCode().equals(producto.getCode());
  }

  // Override hashCode
  @Override
  public int hashCode() {
    return Objects.hash(getId(), getDescription(), getCode(), getPrice(), getStock());
  }

}
