package com.ferrari.Facturacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ferrari.Facturacion.model.InvoiceDetail;
import com.ferrari.Facturacion.model.InvoiceDetailDTO;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {
  @Query("SELECT new com.ferrari.Facturacion.model.InvoiceDetailDTO(" +
      "p.description, " +
      "p.code, " +
      "d.price, " +
      "d.quantity" +
      ") FROM Invoice i JOIN i.invoiceDetails d JOIN d.product p WHERE i.id = :id")
  List<InvoiceDetailDTO> getInvoiceDetailsByInvoiceId(@Param("id") int invoice_id);
}
