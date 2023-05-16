package com.coderhouse.Clase8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coderhouse.Clase8.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
  
}
