package com.example.demo.controller;


import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Candidato;
import com.example.demo.model.Candidato_Tecnologia;
import com.example.demo.model.Tecnologia;
import com.example.demo.repositorios.CandidatosRepositorio;
import com.example.demo.repositorios.RelacionRepositorio;
import com.example.demo.repositorios.TecnologiasRepositorio;

@RestController
@RequestMapping(path="/relacion")
public class ControladorRelacion {

	@Autowired
	RelacionRepositorio relRepositorio;
	
	@Autowired
	CandidatosRepositorio candidatosRepositorio;
	
	@Autowired
	TecnologiasRepositorio tecnoRepositorio;
	
	@PostMapping(path="/relacionar")
	@CrossOrigin
	public @ResponseBody Object anadirRelacion(@RequestParam Integer id_candidato, @RequestParam Integer id_tecnologia, @RequestParam String experiencia, @RequestParam String nivel) {
		
		Candidato c = candidatosRepositorio.findById(id_candidato).get();
		Tecnologia t= tecnoRepositorio.findById(id_tecnologia).get();
		
		Candidato_Tecnologia relacion = new Candidato_Tecnologia();
		relacion.setID(null);
		relacion.setID_CANDIDATO(c);
		relacion.setID_TECNOLOGIA(t);
		relacion.setExperiencia(experiencia);
		relacion.setNivel(nivel);
		
		return relRepositorio.save(relacion);
	}
	
	@GetMapping(path="/verLista")
	@CrossOrigin
	public @ResponseBody Iterable<Candidato_Tecnologia> getAllCandidatos() {
		// This returns a JSON or XML with the candidatos 
		return relRepositorio.findAll();
	}
	
	@DeleteMapping(path="/borrar")
	@CrossOrigin
	public @ResponseBody String borrar(@RequestParam Integer id) {
		relRepositorio.deleteById(id);
		return"Se ha eliminado correctamente";
	}
		@GetMapping(path="/filtro")
	public @ResponseBody ArrayList<Candidato> filtrar(@RequestParam Integer id_tecnologia) {
		ArrayList<Candidato> Lista = new ArrayList<Candidato>();
		Iterable<Candidato_Tecnologia> iterableLista = relRepositorio.findAll();
		Iterator<Candidato_Tecnologia> iteratorLista = iterableLista.iterator();
		while(iteratorLista.hasNext()) {
			Candidato_Tecnologia c = iteratorLista.next();
			if(c.getID_TECNOLOGIA().getID() == id_tecnologia) {
				Lista.add(c.getID_CANDIDATO());
			}
		}
		return Lista;
	}

}