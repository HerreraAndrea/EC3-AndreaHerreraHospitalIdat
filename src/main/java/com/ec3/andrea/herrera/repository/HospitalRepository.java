package com.ec3.andrea.herrera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ec3.andrea.herrera.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer>{

}
