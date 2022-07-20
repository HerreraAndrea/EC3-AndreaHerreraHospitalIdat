package com.ec3.andrea.herrera.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec3.andrea.herrera.dto.DoctorDTORequest;
import com.ec3.andrea.herrera.dto.DoctorDTOResponse;
import com.ec3.andrea.herrera.model.Doctor;
import com.ec3.andrea.herrera.repository.DoctorRepository;

@Service
public class DoctorImpl implements DoctorService{
	
	@Autowired
	private DoctorRepository repository;

	@Override
	public void guardarDoctor(DoctorDTORequest Doctor) {
		Doctor d = new Doctor();
		d.setNumero(Doctor.getNumeroDoctor());
		d.setDoctor(Doctor.getDoctorDoctor());
		repository.save(d);
		
	}

	@Override
	public void actualizarDoctor(DoctorDTORequest Doctor) {
		Doctor d = new Doctor();
		d.setNumero(Doctor.getNumeroDoctor());
		d.setDoctor(Doctor.getDoctorDoctor());
		repository.saveAndFlush(d);
		
	}

	@Override
	public void eliminarDoctor(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<DoctorDTOResponse> listarDoctors() {
List<DoctorDTOResponse> listar = new ArrayList<>();
		
		DoctorDTOResponse dto = null;
		
		List<Doctor> d = repository.findAll();
		
		for (Doctor Doctor : d) {
			
			dto = new DoctorDTOResponse();
			
			dto.setNumeroDoctor(Doctor.getNumero());
			dto.setDoctorDoctor(Doctor.getDoctor());
			dto.setId(Doctor.getIdDoctor());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public DoctorDTOResponse obtenerDoctorId(Integer id) {
		Doctor Doctor = repository.findById(id).orElse(null);
		DoctorDTOResponse dto = new DoctorDTOResponse();
		
		dto.setNumeroDoctor(Doctor.getNumero());
		dto.setDoctorDoctor(Doctor.getDoctor());
		dto.setId(Doctor.getIdDoctor());
		
		return dto;
	}

}
