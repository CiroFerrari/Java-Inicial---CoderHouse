package com.ferrari.Facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferrari.Facturacion.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
  
}
