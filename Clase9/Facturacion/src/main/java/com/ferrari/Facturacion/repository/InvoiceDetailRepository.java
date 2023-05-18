package com.ferrari.Facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferrari.Facturacion.model.InvoiceDetail;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {
  
}
