package com.ferrari.Cliente.model;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String lastname;
  private int birthday;
  private int birthmonth;
  private int birthyear;

  public int getBirthday() {
    return birthday;
  }

  public void setBirthday(int birthday) {
    this.birthday = birthday;
  }

  public int getBirthmonth() {
    return birthmonth;
  }

  public void setBirthmonth(int birthmonth) {
    this.birthmonth = birthmonth;
  }

  public int getBirthyear() {
    return birthyear;
  }

  public void setBirthyear(int birthyear) {
    this.birthyear = birthyear;
  }

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

  // Override toString
  @Override
  public String toString() {
    return "Client{" + 
    "id=" + id + 
    ", name='" + name + '\'' + 
    ", lastname='" + lastname + '\'' + 
    ", birthday='" + birthday + '\'' + 
    ", birthmonth='" + birthmonth + '\'' +
    ", birthyear='" + birthyear + '\'' +
    '}';
  }

  // Override hashCode
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
    result = prime * result + birthday;
    result = prime * result + birthmonth;
    result = prime * result + birthyear;
    return result;
  }

  // Override equals
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Client other = (Client) obj;
    if (id != other.id)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (lastname == null) {
      if (other.lastname != null)
        return false;
    } else if (!lastname.equals(other.lastname))
      return false;
    if (birthday != other.birthday)
      return false;
    if (birthmonth != other.birthmonth)
      return false;
    if (birthyear != other.birthyear)
      return false;
    return true;
  }

}