package com.ferrari.FacturacionEntrega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ferrari.FacturacionEntrega.middleware.ResponseHandler;
import com.ferrari.FacturacionEntrega.model.Client;
import com.ferrari.FacturacionEntrega.service.ClientService;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {
  @Autowired
  private ClientService clientService;

  // CRUD cliente

  // POST client
  @PostMapping
  public ResponseEntity<Object> postClient(@RequestBody Client client) {
    try {
      System.out.println(client);
      Client clientSaved = clientService.postClient(client);
      return ResponseHandler.generateResponse(
          "Data retrieved successfully",
          HttpStatus.OK,
          clientSaved);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  // GET client by id
  @GetMapping(path = "{id}")
  public ResponseEntity<Object> getClient(@PathVariable() int id) {
    try {
      System.out.println(id);
      Client clientFound = clientService.getClient(id);
      return ResponseHandler.generateResponse(
          "Client get successfully",
          HttpStatus.OK,
          clientFound);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  // PUT client by id
  @PutMapping(path = "{id}")
  public ResponseEntity<Object> putClient(@PathVariable() int id, @RequestBody Client client) {
    try {
      System.out.println(id);
      Client clientUpdated = clientService.putClient(id, client);
      return ResponseHandler.generateResponse(
          "Client updated successfully",
          HttpStatus.OK,
          clientUpdated);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

  // DELETE client by id
  @DeleteMapping(path = "{id}")
  public ResponseEntity<Object> deleteClient(@PathVariable() int id) {
    try {
      System.out.println(id);
      clientService.deleteClient(id);
      return ResponseHandler.generateResponse(
          "Client deleted successfully",
          HttpStatus.OK,
          null);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
          e.getMessage(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          null);
    }
  }

}
