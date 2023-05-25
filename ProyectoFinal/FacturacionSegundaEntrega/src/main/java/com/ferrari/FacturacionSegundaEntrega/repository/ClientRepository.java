package com.ferrari.FacturacionSegundaEntrega.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferrari.FacturacionSegundaEntrega.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
