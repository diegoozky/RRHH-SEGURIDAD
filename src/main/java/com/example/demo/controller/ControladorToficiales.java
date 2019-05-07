package com.example.demo.controller;



import java.io.IOException;


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
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.TitulosOficiales;
import com.example.demo.repositorios.TitulosOficialesRepositorio;

@RestController
@RequestMapping("/titulos")
public class ControladorToficiales {

	@Autowired
	TitulosOficialesRepositorio repositorioTituOficiales;
	
	@GetMapping(path="/listar")
	@CrossOrigin
	public @ResponseBody Iterable<TitulosOficiales> listar(){
		//listamos todos los titulos oficiales
		return repositorioTituOficiales.findAll();
	}
	
	@PostMapping(path="/add")
	@CrossOrigin
	public @ResponseBody Object anadir(@RequestBody TitulosOficiales to) {
		to.setId(null);
		return repositorioTituOficiales.save(to);
	
	}
	
	@PostMapping(path="/ponerImagen")
	@CrossOrigin
	public @ResponseBody String imagen(@RequestParam Integer id_title, @RequestParam("imagefile") MultipartFile file) {
		if (repositorioTituOficiales.existsById(id_title)) {
            TitulosOficiales t = repositorioTituOficiales.findById(id_title).get();
            Byte[] byteObject;
            try {
                byteObject = new Byte[file.getBytes().length];
                int i = 0;
                for(byte b : file.getBytes()) {
                    byteObject[i++] = b;
                }
                t.setImagen(byteObject);
                repositorioTituOficiales.save(t);
            } catch(IOException e) {
                e.printStackTrace();
            }
            return "Added";
        }
        else {
            return "Titulo no existe";
        }
		
	}
	
	@PutMapping (path="/actualizar")
	@CrossOrigin
	public @ResponseBody String actualizar(@RequestBody TitulosOficiales to) {
		if(repositorioTituOficiales.findById(to.getId()).get().getId() == to.getId()) {
			repositorioTituOficiales.save(to);
			return "Actualizado con exito";
		}
		else {
			return "No existe el registro con ese id";
		}
	}
	
	@DeleteMapping(path="/borrar")
	@CrossOrigin
	public @ResponseBody String eliminar(@RequestParam Integer id) {
		if(repositorioTituOficiales.existsById(id)) {
			repositorioTituOficiales.deleteById(id);
			return "Se ha eliminado con exito";
		}
		else {
			return "No existe un registro con ese ID";
		}
	}
}
