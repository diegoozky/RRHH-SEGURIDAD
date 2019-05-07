package com.example.demo.model;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.lang.NonNull;

@Entity
public class Candidato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ID;
	
	@NonNull
	private String Nombre;
	
	private String Primer_Apellido;
	
	private String Segundo_Apellido;
	
	private String dni;
	
	private String telefono;
	
	private String correo;
	
	private String poblacion;
	
	private String CP;
	
	private String direccion;
	
	private Date fecha_nacimiento;
	
	private Date fecha_alta;
	
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String cP) {
		CP = cP;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	

	public String getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(String fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	private String fecha_baja;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getPrimer_Apellido() {
		return Primer_Apellido;
	}

	public void setPrimer_Apellido(String primer_Apellido) {
		Primer_Apellido = primer_Apellido;
	}

	public String getSegundo_Apellido() {
		return Segundo_Apellido;
	}

	public void setSegundo_Apellido(String segundo_Apellido) {
		Segundo_Apellido = segundo_Apellido;
	}


	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
}

