package com.ferrari.FacturacionEntrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferrari.FacturacionEntrega.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
