package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Candidato_Tecnologia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ID;
	
	@ManyToOne
	@JoinColumn(name="FK_Candidato")
	private Candidato ID_CANDIDATO;
	
	@ManyToOne
	@JoinColumn(name="FK_Tecno")
	private Tecnologia ID_TECNOLOGIA;
	
	private String Experiencia;

	private String Nivel;


	public Candidato getID_CANDIDATO() {
		return ID_CANDIDATO;
	}

	public void setID_CANDIDATO(Candidato iD_CANDIDATO) {
		ID_CANDIDATO = iD_CANDIDATO;
	}

	public Tecnologia getID_TECNOLOGIA() {
		return ID_TECNOLOGIA;
	}

	public void setID_TECNOLOGIA(Tecnologia iD_TECNOLOGIA) {
		ID_TECNOLOGIA = iD_TECNOLOGIA;
	}

	public String getNivel() {
		return Nivel;
	}

	public void setNivel(String nivel) {
		Nivel = nivel;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}






	public String getExperiencia() {
		return Experiencia;
	}

	public void setExperiencia(String experiencia) {
		Experiencia = experiencia;
	}
	
}