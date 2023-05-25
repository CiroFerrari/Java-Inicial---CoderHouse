package com.ferrari.FacturacionSegundaEntrega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferrari.FacturacionSegundaEntrega.middleware.ResponseHandler;
import com.ferrari.FacturacionSegundaEntrega.model.Client;
import com.ferrari.FacturacionSegundaEntrega.service.ClientService;

@RestController
@RequestMapping(path = "/api/v1/client")
public class ClientController {

  @Autowired
  private ClientService clientService;

  // CRUD Client
  
  // Create a client
  @PostMapping
  public ResponseEntity<Object> postClient (@RequestBody Client client) {
    try {
      System.out.println(client);
      Client clientSaved = clientService.postClient(client);
      return ResponseHandler.generateResponse(
        "Client saved successfully",
        HttpStatus.OK,
        clientSaved
      );
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
        e.getMessage(),
        HttpStatus.INTERNAL_SERVER_ERROR,
        null
      );
    }
  }

  @GetMapping(path = "{id}")
    public ResponseEntity<Object> getClient (@PathVariable() int id) {
        try {
            System.out.println(id);
            Client clientFound = clientService.getClient(id);
            System.out.println("CLIENT FOUND");
            System.out.println(clientFound);
            return ResponseHandler.generateResponse(
                    "Client found successfully",
                    HttpStatus.OK,
                    clientFound
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }
  
}
