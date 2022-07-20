package com.ec3.andrea.herrera.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "Doctor")
@Entity
public class Doctor {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer idDoctor;
		private String doctor;
		private Integer numero;
		
		// RELATION N:M Hospital - Doctor
		@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
		@JoinTable(
				name = "hospital_doctor",
						joinColumns = @JoinColumn(
								name = "id_doctor", 
								nullable = false, 
								unique = true, 
								foreignKey = @ForeignKey(foreignKeyDefinition = 
						"foreign key (id_doctor) references Doctor(id_doctor)")
						),
						inverseJoinColumns = @JoinColumn(
								name = "id_hospital", 
								nullable = false, 
								unique = true, 
								foreignKey = @ForeignKey(foreignKeyDefinition = 
						"foreign key (id_hospital) references Hospital(id_hospital)")
						)
				)
		private List<Hospital> hospital = new ArrayList<>();
		
		
		
		public Integer getIdDoctor() {
			return idDoctor;
		}
		public void setIdDoctor(Integer idDoctor) {
			this.idDoctor = idDoctor;
		}
		public String getDoctor() {
			return doctor;
		}
		public void setDoctor(String doctor) {
			this.doctor = doctor;
		}
		public Integer getNumero() {
			return numero;
		}
		public void setNumero(Integer numero) {
			this.numero = numero;
		}
		
		
}
