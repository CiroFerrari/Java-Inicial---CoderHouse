package com.ferrari.FacturacionSegundaEntrega.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferrari.FacturacionSegundaEntrega.model.Client;
import com.ferrari.FacturacionSegundaEntrega.repository.ClientRepository;

@Service
public class ClientService {
  @Autowired
  private ClientRepository clientRepository;

  public Client postClient(Client client) throws Exception {
    return clientRepository.save(client);
  }

  public Client getClient(int id) throws Exception {
    Optional<Client> cliente = clientRepository.findById(id);
    if (cliente.isEmpty()) {
      return null;
    } else {
      return cliente.get();
    }
  }
}
