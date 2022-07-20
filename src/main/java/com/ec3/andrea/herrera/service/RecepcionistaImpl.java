package com.ec3.andrea.herrera.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec3.andrea.herrera.dto.RecepcionistaDTORequest;
import com.ec3.andrea.herrera.dto.RecepcionistaDTOResponse;
import com.ec3.andrea.herrera.model.Recepcionista;
import com.ec3.andrea.herrera.repository.RecepcionistaRepository;

@Service
public class RecepcionistaImpl implements RecepcionistaService {

	@Autowired
	private RecepcionistaRepository repository;
	
	@Override
	public void guardarRecepcionista(RecepcionistaDTORequest Recepcionista) {
		Recepcionista r = new Recepcionista();
		r.setNombre(Recepcionista.getNombreRecepcionista());
		r.setCelular(Recepcionista.getCelularRecepcionista());
		repository.save(r);
	}

	@Override
	public void actualizarRecepcionista(RecepcionistaDTORequest Recepcionista) {
		Recepcionista r = new Recepcionista();
		r.setNombre(Recepcionista.getNombreRecepcionista());
		r.setCelular(Recepcionista.getCelularRecepcionista());

		repository.saveAndFlush(r);
		
	}

	@Override
	public void eliminarRecepcionista(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<RecepcionistaDTOResponse> listarRecepcionistas() {
		List<RecepcionistaDTOResponse> listar = new ArrayList<>();
		
		RecepcionistaDTOResponse dto = null;
		
		List<Recepcionista> r = repository.findAll();
		
		for (Recepcionista Recepcionista : r) {
			
			dto = new RecepcionistaDTOResponse();
			
			dto.setNombreRecepcionista(Recepcionista.getNombre());
			dto.setCelularRecepcionista(Recepcionista.getCelular());
			dto.setId(Recepcionista.getIdRecepcionista());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public RecepcionistaDTOResponse obtenerRecepcionistaId(Integer id) {
		Recepcionista Recepcionista = repository.findById(id).orElse(null);
		RecepcionistaDTOResponse dto = new RecepcionistaDTOResponse();
		
		dto.setNombreRecepcionista(Recepcionista.getNombre());
		dto.setCelularRecepcionista(Recepcionista.getCelular());
		dto.setId(Recepcionista.getIdRecepcionista());
		
		return dto;
	}

}
