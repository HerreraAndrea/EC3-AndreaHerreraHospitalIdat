package com.ec3.andrea.herrera.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "Especialidades")
@Entity
public class Especialidades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEspecialidades;
	private String especialidad;
	private String diasAtiende;
	
	// RELATION N:M Hospital - Especialidades
	@ManyToMany(mappedBy = "especialidades", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Hospital> hospital = new ArrayList<>();
	
	// RELATION 1:N RECEPCIONISTA - ESPECIALIDADES
	// mapped aqui - cliente
	@OneToMany(mappedBy = "especialidades")
	private List<Recepcionista> recepcionista = new ArrayList<>();
	
	
	public Integer getIdEspecialidades() {
		return idEspecialidades;
	}
	public void setIdEspecialidades(Integer idEspecialidades) {
		this.idEspecialidades = idEspecialidades;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getDiasAtiende() {
		return diasAtiende;
	}
	public void setDiasAtiende(String diasAtiende) {
		this.diasAtiende = diasAtiende;
	}
	
	
}
