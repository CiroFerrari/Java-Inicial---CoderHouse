package com.ferrari.FacturacionSegundaEntrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferrari.FacturacionSegundaEntrega.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
  
}
