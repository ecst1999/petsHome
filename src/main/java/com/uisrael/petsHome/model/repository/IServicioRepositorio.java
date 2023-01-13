package com.uisrael.petsHome.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.petsHome.model.entity.Servicio;

public interface IServicioRepositorio extends JpaRepository<Servicio, Integer> {

	//Consultas personalizadas
	
	@Query("Select s from Servicio s where s.consultorio like %:consultorio%")
	public List<Servicio> buscarServicioPorConsultorio(String consultorio);
	
	@Query("Select s from Servicio s where s.nombreServicio like %:nombre%")
	public List<Servicio> buscarServicioPorNombre(String nombre);
	
	@Query("Select s from Servicio s where s.tipoServicio like %:tipoServicio%")
	public List<Servicio> buscarServicioPorTipo(String tipoServicio);
}
