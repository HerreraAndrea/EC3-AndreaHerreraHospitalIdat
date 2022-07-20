package com.ec3.andrea.herrera.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec3.andrea.herrera.dto.EspecialidadesDTORequest;
import com.ec3.andrea.herrera.dto.EspecialidadesDTOResponse;
import com.ec3.andrea.herrera.model.Especialidades;
import com.ec3.andrea.herrera.repository.EspecialidadesRepository;


@Service
public class EspecialidadesImpl implements EspecialidadesService{

	@Autowired
	private EspecialidadesRepository repository;
	
	@Override
	public void guardarEspecialidades(EspecialidadesDTORequest Especialidades) {
		Especialidades e = new Especialidades();
		e.setEspecialidad(Especialidades.getEspecialidadEspecialidades());
		e.setDiasAtiende(Especialidades.getDiasAtiendeEspecialidades());
		repository.save(e);
		
	}

	@Override
	public void actualizarEspecialidades(EspecialidadesDTORequest Especialidades) {
		
		Especialidades e = new Especialidades();
		e.setEspecialidad(Especialidades.getEspecialidadEspecialidades());
		e.setDiasAtiende(Especialidades.getDiasAtiendeEspecialidades());
		repository.saveAndFlush(e);
	}

	@Override
	public void eliminarEspecialidades(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<EspecialidadesDTOResponse> listarEspecialidadess() {
List<EspecialidadesDTOResponse> listar = new ArrayList<>();
		
		EspecialidadesDTOResponse dto = null;
		
		List<Especialidades> e = repository.findAll();
		
		for (Especialidades Especialidades : e) {
			
			dto = new EspecialidadesDTOResponse();
			
			dto.setEspecialidadEspecialidades(Especialidades.getEspecialidad());
			dto.setDiasAtiendeEspecialidades(Especialidades.getDiasAtiende());
			dto.setId(Especialidades.getIdEspecialidades());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public EspecialidadesDTOResponse obtenerEspecialidadesId(Integer id) {
		Especialidades Especialidades = repository.findById(id).orElse(null);
		EspecialidadesDTOResponse dto = new EspecialidadesDTOResponse();
		
		dto.setEspecialidadEspecialidades(Especialidades.getEspecialidad());
		dto.setDiasAtiendeEspecialidades(Especialidades.getDiasAtiende());
		dto.setId(Especialidades.getIdEspecialidades());
		
		
		return dto;
	}

}
