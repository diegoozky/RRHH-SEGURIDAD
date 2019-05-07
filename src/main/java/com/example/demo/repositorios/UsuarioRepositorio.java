package com.example.demo.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Usuarios;

public interface UsuarioRepositorio extends CrudRepository<Usuarios, Integer>{

}
