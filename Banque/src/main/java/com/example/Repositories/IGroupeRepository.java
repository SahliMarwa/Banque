package com.example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Groupe;

public interface IGroupeRepository extends JpaRepository<Groupe, Long> {

}
