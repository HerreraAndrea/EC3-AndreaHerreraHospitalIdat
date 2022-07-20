package com.ec3.andrea.herrera.service;

import java.util.List;

import com.ec3.andrea.herrera.dto.RecepcionistaDTORequest;
import com.ec3.andrea.herrera.dto.RecepcionistaDTOResponse;

public interface RecepcionistaService {
	
	void guardarRecepcionista(RecepcionistaDTORequest Recepcionista);
	void actualizarRecepcionista(RecepcionistaDTORequest Recepcionista);
	void eliminarRecepcionista(Integer id);
	List<RecepcionistaDTOResponse> listarRecepcionistas();
	RecepcionistaDTOResponse obtenerRecepcionistaId(Integer id);
}
