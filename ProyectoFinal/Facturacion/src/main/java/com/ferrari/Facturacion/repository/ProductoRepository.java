package com.ferrari.Facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferrari.Facturacion.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
  
}
