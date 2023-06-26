package com.ferrari.FacturacionEntrega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferrari.FacturacionEntrega.model.InvoiceDetail;
import com.ferrari.FacturacionEntrega.model.InvoiceDetailDTO;
import com.ferrari.FacturacionEntrega.repository.InvoiceDetailRepository;

import java.util.List;

@Service
public class InvoiceDetailService {
  @Autowired
  private InvoiceDetailRepository invoiceDetailRepository;

  public void saveInvoiceDetail(InvoiceDetail invoiceDetail) throws Exception {
    invoiceDetailRepository.save(invoiceDetail);
  }

  public List<InvoiceDetailDTO> getInvoiceDetailsByInvoiceId(int invoice_id) throws Exception {
    System.out.println(invoiceDetailRepository.getInvoiceDetailsByInvoiceId(invoice_id));
    return invoiceDetailRepository.getInvoiceDetailsByInvoiceId(invoice_id);
  }
}