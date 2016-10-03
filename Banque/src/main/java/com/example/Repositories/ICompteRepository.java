package com.example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Compte;

public interface ICompteRepository extends JpaRepository<Compte, String> {

}
