package com.example.demo.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Candidato;

public interface CandidatosRepositorio extends CrudRepository<Candidato, Integer> {

}
