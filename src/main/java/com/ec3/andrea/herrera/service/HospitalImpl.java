package com.ec3.andrea.herrera.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec3.andrea.herrera.dto.HospitalDTORequest;
import com.ec3.andrea.herrera.dto.HospitalDTOResponse;
import com.ec3.andrea.herrera.model.Hospital;
import com.ec3.andrea.herrera.repository.HospitalRepository;

@Service
public class HospitalImpl implements HospitalService{

	@Autowired
	private HospitalRepository repository;
	
	@Override
	public void guardarHospital(HospitalDTORequest Hospital) {
		Hospital h = new Hospital();
		h.setNombre(Hospital.getNombreHospital());
		h.setDescripcion(Hospital.getDescripcionHospital());
		h.setDistrito(Hospital.getDistritoHospital());
		repository.save(h);
	}

	@Override
	public void actualizarHospital(HospitalDTORequest Hospital) {
		Hospital h = new Hospital();
		h.setNombre(Hospital.getNombreHospital());
		h.setDescripcion(Hospital.getDescripcionHospital());
		h.setDistrito(Hospital.getDistritoHospital());
		repository.saveAndFlush(h);
	}

	@Override
	public void eliminarHospital(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<HospitalDTOResponse> listarHospitals() {
List<HospitalDTOResponse> listar = new ArrayList<>();
		
		HospitalDTOResponse dto = null;
		
		List<Hospital> h = repository.findAll();
		
		for (Hospital Hospital : h) {
			
			dto = new HospitalDTOResponse();
			
			dto.setDescripcionHospital(Hospital.getDescripcion());
			dto.setNombreHospital(Hospital.getNombre());
			dto.setDistritoHospital(Hospital.getDistrito());
			dto.setId(Hospital.getIdHospital());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public HospitalDTOResponse obtenerHospitalId(Integer id) {
		Hospital Hospital = repository.findById(id).orElse(null);
		HospitalDTOResponse dto = new HospitalDTOResponse();
		
		dto.setDescripcionHospital(Hospital.getDescripcion());
		dto.setNombreHospital(Hospital.getNombre());
		dto.setDistritoHospital(Hospital.getDistrito());
		dto.setId(Hospital.getIdHospital());
		
		return dto;
	}

}
