package com.example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Employe;

public interface IEmployeRepository extends JpaRepository<Employe, Long> {

}
