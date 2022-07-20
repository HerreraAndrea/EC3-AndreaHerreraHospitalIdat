package com.ec3.andrea.herrera.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "Recepcionista")
@Entity
public class Recepcionista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRecepcionista;
	private String nombre;
	private String celular;
	
	// RELATION 1:N RECEPCIONISTA - ESPECIALIDADES
	// join aqui
	@ManyToOne
	@JoinColumn(
			name = "id_especialidades",
			nullable = false,
			unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_especialidades) references Especialidades(id_especialidades)")
			)
	private Especialidades especialidades;
	
	public Integer getIdRecepcionista() {
		return idRecepcionista;
	}
	public void setIdRecepcionista(Integer idRecepcionista) {
		this.idRecepcionista = idRecepcionista;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
}
