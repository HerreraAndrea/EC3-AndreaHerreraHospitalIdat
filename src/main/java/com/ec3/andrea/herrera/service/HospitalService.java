package com.ec3.andrea.herrera.service;

import java.util.List;

import com.ec3.andrea.herrera.dto.HospitalDTORequest;
import com.ec3.andrea.herrera.dto.HospitalDTOResponse;


public interface HospitalService {
	
	void guardarHospital(HospitalDTORequest Hospital);
	void actualizarHospital(HospitalDTORequest Hospital);
	void eliminarHospital(Integer id);
	List<HospitalDTOResponse> listarHospitals();
	HospitalDTOResponse obtenerHospitalId(Integer id);

}
