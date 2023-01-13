package com.uisrael.petsHome.model.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.petsHome.model.entity.Cita;
import com.uisrael.petsHome.model.entity.Mascota;

public interface ICitaRepositorio extends JpaRepository<Cita, Integer> {

	//consultas personalizadas 
	
	@Query("Select c From Cita c where c.fechaCita = ?1 ")
	public List<Cita> buscarCitaPorFecha(LocalDate fecha);
	
	@Query("Select c From Cita c where c.estadoCita = ?1")
	public List<Cita> buscarCitaPorEstado(Boolean estado);
	
	@Query("Select c From Cita c where c.motivo like %:motivo%")
	public List<Cita> buscarCitaPorMotivo(String motivo);
}
