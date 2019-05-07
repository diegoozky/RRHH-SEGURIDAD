package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ExperienciaLaboral;
import com.example.demo.repositorios.ExperienciaLaboralRepositorio;



@RestController
@RequestMapping("/exp")
public class ControladorExperienca {
	
	@Autowired
	  ExperienciaLaboralRepositorio repositorioExp;
	
	
	@GetMapping(path="/listar")
	@CrossOrigin
	public @ResponseBody Iterable<ExperienciaLaboral> ver() {
		return repositorioExp.findAll();
	}
	
	@PostMapping(path="/add")
	@CrossOrigin
	public @ResponseBody Object añadir(@RequestBody ExperienciaLaboral exp) {
		exp.setId(null);
		return repositorioExp.save(exp);
	}
	
	@PutMapping(path="/actualizar")
	@CrossOrigin
	public @ResponseBody String actualizar(@RequestBody ExperienciaLaboral exp) {
		Integer id = exp.getId();
		if(repositorioExp.findById(id).get() != null) {
			repositorioExp.save(exp);
			
		}
		
		return "Actualizado";
	}
	
	@DeleteMapping(path="/borrar")
	@CrossOrigin
	public @ResponseBody String borrar(@RequestParam Integer id) {
		if(repositorioExp.existsById(id)) {
			repositorioExp.deleteById(id);
			return "eliminado";
		}
		else {
			return "No se encuentra en la base de datos este id";
			}
		}
}
