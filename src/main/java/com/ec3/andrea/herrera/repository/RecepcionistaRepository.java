package com.ec3.andrea.herrera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ec3.andrea.herrera.model.Recepcionista;


@Repository
public interface RecepcionistaRepository extends JpaRepository<Recepcionista,Integer>{

}
