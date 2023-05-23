package com.ferrari.Facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferrari.Facturacion.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
