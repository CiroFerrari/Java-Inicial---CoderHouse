package com.ferrari.Cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferrari.Cliente.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
