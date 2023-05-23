package com.ferrari.Cliente.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferrari.Cliente.model.Client;
import com.ferrari.Cliente.model.ClientDTO;
import com.ferrari.Cliente.repository.ClientRepository;

@Service
public class ClientService {
  @Autowired
  private ClientRepository clientRepository;

  public Client postClient(Client client) throws Exception {
    return clientRepository.save(client);
  }

  public ClientDTO getClient(int id) throws Exception {
    Optional<Client> cliente = clientRepository.findById(id);
    if (cliente.isEmpty()) {
      return null;
    } else {

      // Creamos un cliente para obtener sus datos
      Client client = cliente.get();

      // Calculamos la edad en base a la fecha de nacimiento del cliente
      LocalDate birthday = LocalDate.of(client.getBirthyear(), client.getBirthmonth(), client.getBirthday());
      int age = calculateAge(birthday);

      // Creamos un ClientDTO con los datos del cliente, para retornar sólo los campos
      // solicitados: nombre, apellido y edad
      ClientDTO clientDTO = new ClientDTO(client.getName(), client.getLastname(), age);
      return clientDTO;
    }
  }

  // Función para calcular la edad
  public static int calculateAge(LocalDate birthday) {
    LocalDate currentDate = LocalDate.now();
    Period period = Period.between(birthday, currentDate);
    return period.getYears();
  }
}
