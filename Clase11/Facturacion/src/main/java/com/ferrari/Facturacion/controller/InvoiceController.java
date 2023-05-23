package com.ferrari.Facturacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ferrari.Facturacion.middleware.ResponseHandler;
import com.ferrari.Facturacion.model.InvoiceDTO;
import com.ferrari.Facturacion.model.RequestInvoice;
import com.ferrari.Facturacion.service.InvoiceService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/invoice")
public class InvoiceController {
  @Autowired
  private InvoiceService invoiceService;

  @PostMapping
  public ResponseEntity<Object> postInvoice(@RequestBody RequestInvoice reqInvoice) {
    try {
      System.out.println(reqInvoice);
      // DTO = Data Transfer Object
      InvoiceDTO data = invoiceService.postInvoice(reqInvoice);
      return ResponseHandler.generateResponse(
          "Invoice created successfully",
          HttpStatus.OK,
          data);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.BAD_REQUEST,
          null);
    }
  }

  // Añadir getInvoice by ID
  @GetMapping(path = "{invoice_id}")
  public ResponseEntity<Object> getInvoiceById(@PathVariable int invoice_id) {
    try {
      System.out.println(invoice_id);
      InvoiceDTO data = invoiceService.getInvoiceById(invoice_id);
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
