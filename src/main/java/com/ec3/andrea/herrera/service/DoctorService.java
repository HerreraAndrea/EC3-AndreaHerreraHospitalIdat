package com.ec3.andrea.herrera.service;

import java.util.List;

import com.ec3.andrea.herrera.dto.DoctorDTORequest;
import com.ec3.andrea.herrera.dto.DoctorDTOResponse;

public interface DoctorService {
	
	void guardarDoctor(DoctorDTORequest Doctor);
	void actualizarDoctor(DoctorDTORequest Doctor);
	void eliminarDoctor(Integer id);
	List<DoctorDTOResponse> listarDoctors();
	DoctorDTOResponse obtenerDoctorId(Integer id);
}
