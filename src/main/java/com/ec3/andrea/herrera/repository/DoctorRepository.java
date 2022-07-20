package com.ec3.andrea.herrera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ec3.andrea.herrera.model.Doctor;

@RepositoryRestResource(path = "doctor")
public interface DoctorRepository extends JpaRepository<Doctor,Integer>{

}
