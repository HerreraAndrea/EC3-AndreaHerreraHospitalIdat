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

import com.ec3.andrea.herrera.dto.RecepcionistaDTORequest;
import com.ec3.andrea.herrera.dto.RecepcionistaDTOResponse;
import com.ec3.andrea.herrera.service.RecepcionistaService;


@Controller
@RequestMapping( path = "/recepcionista/v1")
public class RecepcionistaController {
	@Autowired
	private RecepcionistaService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<RecepcionistaDTOResponse>>  listar() {
		
		return new ResponseEntity<List<RecepcionistaDTOResponse>>(service.listarRecepcionistas(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody RecepcionistaDTORequest Recepcionistas) {
		service.guardarRecepcionista(Recepcionistas);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		RecepcionistaDTOResponse r =service.obtenerRecepcionistaId(id);
		if(r != null) {
			service.eliminarRecepcionista(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody RecepcionistaDTORequest Recepcionistas) {
		RecepcionistaDTOResponse r =service.obtenerRecepcionistaId(Recepcionistas.getId());
		if(r != null) {
			service.actualizarRecepcionista(Recepcionistas);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<RecepcionistaDTOResponse> obtenerId(@PathVariable Integer id) {
		RecepcionistaDTOResponse r =service.obtenerRecepcionistaId(id);
		if(r != null) {
			return  new ResponseEntity<RecepcionistaDTOResponse>(service.obtenerRecepcionistaId(id),HttpStatus.OK);
		}
		return  new ResponseEntity<RecepcionistaDTOResponse>(HttpStatus.NOT_FOUND);
	}
}
