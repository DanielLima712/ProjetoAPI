package com.matera.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matera.api.model.Veiculos;

@Repository //Define a classe como um bean do Spring
public interface VeiculosRepository extends JpaRepository<Veiculos, String> { }
//Deve estender JpaRepository e declarar a entidade (Veiculos) e o tipo de chave primária (String)
