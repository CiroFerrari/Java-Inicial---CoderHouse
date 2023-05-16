package com.ferrari.Facturacion.model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String lastname;
  private String docnumber;
  
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
    if (this == o) return true;
    if (!(o instanceof Cliente)) return false;
    Cliente cliente = (Cliente) o;
    return getId() == cliente.getId() && getName().equals(cliente.getName()) && getLastname().equals(cliente.getLastname()) && getDocnumber().equals(cliente.getDocnumber());
  }

  // Override hashCode
  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getLastname(), getDocnumber());
  }
  
}
