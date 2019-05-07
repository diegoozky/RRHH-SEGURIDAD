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

import com.example.demo.model.OtrosTitulos;
import com.example.demo.repositorios.OtrosTitulosRepositorio;

@RestController
@RequestMapping("/otrosTitulos")
public class ControladorOtrosTitulos {

	@Autowired
	OtrosTitulosRepositorio repositorioOtrosTitulos;
	
	@GetMapping(path="/listarTitulos")
	@CrossOrigin
	public @ResponseBody Iterable<OtrosTitulos> listar(){
		
		//Te devuelve una lista con todos los otros titulos
		return repositorioOtrosTitulos.findAll();
	}
	
	@PostMapping(path="/add")
	@CrossOrigin
	public @ResponseBody Object anadir(@RequestBody OtrosTitulos ot) {
		ot.setId(null);
		return repositorioOtrosTitulos.save(ot);
	}
	
	@PutMapping(path="/actualizar")
	@CrossOrigin
	public @ResponseBody Object actualizar(@RequestBody OtrosTitulos ot) {
		Integer id = ot.getId();
		if(repositorioOtrosTitulos.findById(id).get().getId() == id) {
			return repositorioOtrosTitulos.save(ot);
		}
		else {
			return "No encontrado";
		}
		
	}
	
	@DeleteMapping(path="/eliminar")
	@CrossOrigin
	public @ResponseBody String eliminar(@RequestParam Integer id) {
		if(repositorioOtrosTitulos.existsById(id)) {
			repositorioOtrosTitulos.deleteById(id);
			return "Eliminado con exito";
		}
		else {
			return "No se ha encontrado un ningun registro con este id";
		}
	}
}
