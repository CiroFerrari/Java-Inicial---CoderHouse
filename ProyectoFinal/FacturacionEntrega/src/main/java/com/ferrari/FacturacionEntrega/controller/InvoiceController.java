package com.ferrari.FacturacionEntrega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ferrari.FacturacionEntrega.middleware.ResponseHandler;
import com.ferrari.FacturacionEntrega.model.InvoiceDTO;
import com.ferrari.FacturacionEntrega.model.InvoiceWithDetailsDTO;
import com.ferrari.FacturacionEntrega.model.RequestInvoice;
import com.ferrari.FacturacionEntrega.service.InvoiceService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/invoice")
public class InvoiceController {
  @Autowired
  private InvoiceService invoiceService;

  // POST invoice
  @PostMapping
  public ResponseEntity<Object> postInvoice(@RequestBody RequestInvoice reqInvoice) {
    try {
      System.out.println(reqInvoice);
      // DTO Data transfer object
      InvoiceDTO data = invoiceService.postInvoice(reqInvoice);
      return ResponseHandler.generateResponse(
          "Invoice created successful",
          HttpStatus.OK,
          data);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  // GET invoice by id
  @GetMapping(path = "{invoice_id}")
  public ResponseEntity<Object> getInvoiceById(@PathVariable int invoice_id) {
    try {
      System.out.println(invoice_id);
      InvoiceWithDetailsDTO data = invoiceService.getInvoiceById(invoice_id);
      return ResponseHandler.generateResponse(
          "Get Invoice by Id succesful",
          HttpStatus.OK,
          data);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  // GET invoices by client id
  @GetMapping(path = "/getInvoicesByClientId/{clientId}")
  public ResponseEntity<Object> getInvoicesByClientId(@PathVariable int clientId) {
    try {
      List<InvoiceDTO> data = invoiceService.getInvoicesByClientId(clientId);
      return ResponseHandler.generateResponse(
          "Get Invoices by Client id successful",
          HttpStatus.OK,
          data);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }
}
