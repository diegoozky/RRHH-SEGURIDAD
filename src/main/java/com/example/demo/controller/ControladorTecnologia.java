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

import com.example.demo.model.Tecnologia;
import com.example.demo.repositorios.TecnologiasRepositorio;

@RestController
@RequestMapping(path="/tecnologias")
public class ControladorTecnologia {
	
	@Autowired
	TecnologiasRepositorio tecnoRepositorio;
	
	@GetMapping(path="/ver")
	@CrossOrigin
	public @ResponseBody Iterable<Tecnologia> getAllCandidatos() {
		// This returns a JSON or XML with the candidatos 
		return tecnoRepositorio.findAll();
	}
	
	@PostMapping(path="/add")
	@CrossOrigin
	public @ResponseBody Object anadirTecnologia(@RequestBody Tecnologia t) {
		t.setID(null);
		
		return tecnoRepositorio.save(t);
	}
	@DeleteMapping(path="/borrar")
	@CrossOrigin
	public @ResponseBody String borrar(@RequestParam Integer id) {
		if(tecnoRepositorio.existsById(id)) {
			tecnoRepositorio.deleteById(id);
			return "Se ha eliminado correctamente el ID";

		}
		else {
			return "No se encuentra el Registro a borrar";
		}
	}
	
	@PutMapping(path="/actualizar")
	@CrossOrigin
	public @ResponseBody String actualizar(@RequestBody Tecnologia t) {
		
		
		
		if(tecnoRepositorio.findById(t.getID()).get() != null){
			
			tecnoRepositorio.save(t);
			return "Bien";
		}
		return"Error";
	}
}
