package com.example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {

}
