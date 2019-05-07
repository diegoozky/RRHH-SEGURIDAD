package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class TitulosOficiales {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	private String centro;
	
	private Date fecha_expedicion;
	
	@Lob
	private Byte[] imagen;
	
	@ManyToOne
	@JoinColumn(name="FK_CANDIDATO")
	private Candidato id_candidato;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCentro() {
		return centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	public Date getFecha_expedicion() {
		return fecha_expedicion;
	}

	public void setFecha_expedicion(Date fecha_expedicion) {
		this.fecha_expedicion = fecha_expedicion;
	}

	public Byte[] getImagen() {
		return imagen;
	}

	public void setImagen(Byte[] imagen) {
		this.imagen = imagen;
	}

	public Candidato getId_candidato() {
		return id_candidato;
	}

	public void setId_candidato(Candidato id_candidato) {
		this.id_candidato = id_candidato;
	}

	


}
