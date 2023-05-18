package com.ferrari.Facturacion.model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "invoiceDetail")
public class InvoiceDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  private Invoice invoice;

  @ManyToOne
  private Product product;

  private int quantity;

  private double price;

  // Getters and setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Invoice getInvoice() {
    return invoice;
  }

  public void setInvoice(Invoice invoice) {
    this.invoice = invoice;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  // Override toString
  @Override
  public String toString() {
    return "InvoiceDetail{" +
        "id=" + id +
        ", invoice=" + invoice +
        ", product=" + product +
        ", quantity=" + quantity +
        ", price=" + price +
        '}';
  }

  // Override equals
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof InvoiceDetail))
      return false;
    InvoiceDetail invoiceDetail = (InvoiceDetail) o;
    return getId() == invoiceDetail.getId() && getQuantity() == invoiceDetail.getQuantity()
        && Double.compare(invoiceDetail.getPrice(), getPrice()) == 0
        && Objects.equals(getProduct(), invoiceDetail.getProduct())
        && Objects.equals(getInvoice(), invoiceDetail.getInvoice());
  }

  // Override hashCode
  @Override
  public int hashCode() {
    return Objects.hash(getId(), getProduct(), getInvoice(), getQuantity(), getPrice());
  }

}
