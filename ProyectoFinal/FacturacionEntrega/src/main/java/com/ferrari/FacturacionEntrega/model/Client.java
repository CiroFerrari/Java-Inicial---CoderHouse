package com.ferrari.FacturacionEntrega.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "client")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private String name;
  @Column(nullable = false)

  private String lastname;
  @Column(nullable = false, unique = true)

  private String docnumber;

  @OneToMany(mappedBy = "client")
  private List<Invoice> invoice;

  // Validar que los datos del cliente sean correctos
  public void setUserData(String name, String surname, String docNumber) throws IllegalArgumentException {
    if (name == null || name.isEmpty()) {
        throw new IllegalArgumentException("Name cannot be empty");
    }
    if (surname == null || surname.isEmpty()) {
        throw new IllegalArgumentException("Surname cannot be empty");
    }
    try {
        Integer.parseInt(docNumber);
    } catch (NumberFormatException e) {
        throw new IllegalArgumentException("Document number must be a number");
    }
    this.name = name;
    this.lastname = surname;
    this.docnumber = docNumber;
}

  // Getters y Setters
  public List<Invoice> getInvoice() {
    return invoice;
  }

  public void setInvoice(List<Invoice> invoice) {
    this.invoice = invoice;
  }

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

  // toString 
  @Override
  public String toString() {
    return "Client [id=" + id + ", name=" + name + ", lastname=" + lastname + ", docnumber=" + docnumber + "]";
  }
}