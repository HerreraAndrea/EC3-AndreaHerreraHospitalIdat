package com.ec3.andrea.herrera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ec3.andrea.herrera.dto.EspecialidadesDTORequest;
import com.ec3.andrea.herrera.dto.EspecialidadesDTOResponse;
import com.ec3.andrea.herrera.service.EspecialidadesService;

@Controller
@RequestMapping( path = "/especialidades/v1")
public class EspecialidadesController {
	
	@Autowired
	private EspecialidadesService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<EspecialidadesDTOResponse>>  listar() {
		
		return new ResponseEntity<List<EspecialidadesDTOResponse>>(service.listarEspecialidadess(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody EspecialidadesDTORequest Especialidadess) {
		service.guardarEspecialidades(Especialidadess);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		EspecialidadesDTOResponse e =service.obtenerEspecialidadesId(id);
		if(e != null) {
			service.eliminarEspecialidades(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody EspecialidadesDTORequest Especialidadess) {
		EspecialidadesDTOResponse e =service.obtenerEspecialidadesId(Especialidadess.getId());
		if(e != null) {
			service.actualizarEspecialidades(Especialidadess);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<EspecialidadesDTOResponse> obtenerId(@PathVariable Integer id) {
		EspecialidadesDTOResponse e =service.obtenerEspecialidadesId(id);
		if(e != null) {
			return  new ResponseEntity<EspecialidadesDTOResponse>(service.obtenerEspecialidadesId(id),HttpStatus.OK);
		}
		return  new ResponseEntity<EspecialidadesDTOResponse>(HttpStatus.NOT_FOUND);
	}
}
