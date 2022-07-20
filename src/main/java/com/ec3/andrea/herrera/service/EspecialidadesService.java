package com.ec3.andrea.herrera.service;

import java.util.List;

import com.ec3.andrea.herrera.dto.EspecialidadesDTORequest;
import com.ec3.andrea.herrera.dto.EspecialidadesDTOResponse;

public interface EspecialidadesService {
	
	void guardarEspecialidades(EspecialidadesDTORequest Especialidades);
	void actualizarEspecialidades(EspecialidadesDTORequest Especialidades);
	void eliminarEspecialidades(Integer id);
	List<EspecialidadesDTOResponse> listarEspecialidadess();
	EspecialidadesDTOResponse obtenerEspecialidadesId(Integer id);

}
