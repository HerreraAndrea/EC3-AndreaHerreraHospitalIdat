package com.ec3.andrea.herrera.dto;

public class RecepcionistaDTORequest {
	
	private Integer id;
	private String nombreRecepcionista;
	private String celularRecepcionista;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombreRecepcionista() {
		return nombreRecepcionista;
	}
	public void setNombreRecepcionista(String nombreRecepcionista) {
		this.nombreRecepcionista = nombreRecepcionista;
	}
	public String getCelularRecepcionista() {
		return celularRecepcionista;
	}
	public void setCelularRecepcionista(String celularRecepcionista) {
		this.celularRecepcionista = celularRecepcionista;
	}
	
	
}
