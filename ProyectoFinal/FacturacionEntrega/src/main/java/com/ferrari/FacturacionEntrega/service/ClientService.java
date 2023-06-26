package com.ferrari.FacturacionEntrega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferrari.FacturacionEntrega.model.Client;
import com.ferrari.FacturacionEntrega.repository.ClientRepository;

import java.util.Optional;

@Service
public class ClientService {
  @Autowired
  private ClientRepository clientRepository;

  // POST client
  public Client postClient(Client client) throws Exception {
    try {
      client.setUserData(client.getName(), client.getLastname(), client.getDocnumber());
    } catch (IllegalArgumentException e) {
      throw new Exception("Error saving client: " + e.getMessage());
    }
    return clientRepository.save(client);
  }

  // GET client by id
  public Client getClient(int id) throws Exception {
    Optional<Client> cliente = clientRepository.findById(id);
    if (cliente.isEmpty()) {
      throw new Exception("Client with id: " + id + ", not found");
    } else {
      return cliente.get();
    }
  }

  // Función que verifica si existe un cliente según su id
  public boolean clientExist(int id) throws Exception {
    Optional<Client> cliente = clientRepository.findById(id);
    return cliente.isPresent();
  }

  // PUT client by id: puede recibir un objeto incompleto
  public Client putClient(int id, Client client) throws Exception {
    if (!clientExist(id)) {
      throw new Exception("Client with id: " + id + ", not found");
    }
    try {
      Client existingClient = clientRepository.findById(id).get();
      if (client.getName() != null) {
        existingClient.setName(client.getName());
      }
      if (client.getLastname() != null) {
        existingClient.setLastname(client.getLastname());
      }
      if (client.getDocnumber() != null) {
        existingClient.setDocnumber(client.getDocnumber());
      }
      return clientRepository.save(existingClient);
    } catch (IllegalArgumentException e) {
      throw new Exception("Error saving client: " + e.getMessage());
    }
  }

  // DELETE client by id
  public void deleteClient(int id) throws Exception {
    if (!clientExist(id)) {
      throw new Exception("Client with id: " + id + ", not found");
    }
    clientRepository.deleteById(id);
  }

}
