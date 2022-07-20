package com.ec3.andrea.herrera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ec3.andrea.herrera.model.Especialidades;

@Repository
public interface EspecialidadesRepository extends JpaRepository<Especialidades,Integer>{

}
