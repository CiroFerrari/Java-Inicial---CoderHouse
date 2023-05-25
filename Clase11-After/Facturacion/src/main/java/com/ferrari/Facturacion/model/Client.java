package com.ferrari.Facturacion.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String lastname;
  private String docnumber;

  @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
  private List<Invoice> invoice;

  // Getters and setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getDocnumber() {
    return docnumber;
  }

  public void setDocnumber(String docnumber) {
    this.docnumber = docnumber;
  }

  public List<Invoice> getInvoice() {
    return invoice;
  }

  public void setInvoice(List<Invoice> invoice) {
    this.invoice = invoice;
  }

  // Override toString
  @Override
  public String toString() {
    return "Cliente{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", lastname='" + lastname + '\'' +
        ", docnumber='" + docnumber + '\'' +
        '}';
  }

  // Override equals
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Client))
      return false;
    Client cliente = (Client) o;
    return getId() == cliente.getId() && getName().equals(cliente.getName())
        && getLastname().equals(cliente.getLastname()) && getDocnumber().equals(cliente.getDocnumber());
  }

  // Override hashCode
  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getLastname(), getDocnumber());
  }

}
