package com.ferrari.Facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferrari.Facturacion.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
  
}
