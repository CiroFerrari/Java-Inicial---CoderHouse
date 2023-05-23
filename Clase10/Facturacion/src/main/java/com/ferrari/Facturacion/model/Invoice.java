package com.ferrari.Facturacion.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "invoice")
public class Invoice {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  private Client client;

  @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER)
  private List<InvoiceDetail> invoiceDetail;

  private String created_at;

  private double total;

  // Getters and setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public String getCreated_at() {
    return created_at;
  }

  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public List<InvoiceDetail> getInvoiceDetail() {
    return invoiceDetail;
  }

  // Override toString
  @Override
  public String toString() {
    return "Invoice{" +
        "id=" + id +
        ", client=" + client +
        ", created_at='" + created_at + '\'' +
        ", total=" + total +
        '}';
  }

  // Override equals
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Invoice))
      return false;
    Invoice invoice = (Invoice) o;
    return getId() == invoice.getId() && Double.compare(invoice.getTotal(), getTotal()) == 0
        && getClient().equals(invoice.getClient()) && getCreated_at().equals(invoice.getCreated_at());
  }

  // Override hashCode
  @Override
  public int hashCode() {
    return Objects.hash(getId(), getClient(), getCreated_at(), getTotal());
  }
}
