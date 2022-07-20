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

import com.ec3.andrea.herrera.dto.DoctorDTORequest;
import com.ec3.andrea.herrera.dto.DoctorDTOResponse;
import com.ec3.andrea.herrera.service.DoctorService;


@Controller
@RequestMapping( path = "/doctor/v1")
public class DoctorController {

	@Autowired
	private DoctorService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<DoctorDTOResponse>>  listar() {
		
		return new ResponseEntity<List<DoctorDTOResponse>>(service.listarDoctors(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody DoctorDTORequest Doctors) {
		service.guardarDoctor(Doctors);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		DoctorDTOResponse d =service.obtenerDoctorId(id);
		if(d != null) {
			service.eliminarDoctor(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody DoctorDTORequest Doctors) {
		DoctorDTOResponse d =service.obtenerDoctorId(Doctors.getId());
		if(d != null) {
			service.actualizarDoctor(Doctors);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<DoctorDTOResponse> obtenerId(@PathVariable Integer id) {
		DoctorDTOResponse d =service.obtenerDoctorId(id);
		if(d != null) {
			return  new ResponseEntity<DoctorDTOResponse>(service.obtenerDoctorId(id),HttpStatus.OK);
		}
		return  new ResponseEntity<DoctorDTOResponse>(HttpStatus.NOT_FOUND);
	}
}
