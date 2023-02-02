package com.uisrael.petsHome.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uisrael.petsHome.model.entity.Servicio;

import jakarta.transaction.Transactional;

@Repository
public interface IServicioRepositorio extends JpaRepository<Servicio, Integer> {

	//Consultas personalizadas
	
	@Query("Select s from Servicio s where s.consultorio like %:consultorio%")
	public List<Servicio> buscarServicioPorConsultorio(String consultorio);
	
	@Query("Select s from Servicio s where s.nombreServicio like %:nombre%")
	public List<Servicio> buscarServicioPorNombre(String nombre);
	
	@Query("Select s from Servicio s where s.tipoServicio like %:tipoServicio%")
	public List<Servicio> buscarServicioPorTipo(String tipoServicio);
	
	@Query("Select s From Servicio s where s.estadoServicio = ?1")
	public List<Servicio> buscarServicioPorEstado(Boolean estado);
	
	@Query("Select s From Servicio s where s.idServicio = ?1")
	public Servicio buscarServicioPorId(int idServ);
	
	@Transactional
	@Modifying
	@Query("UPDATE Servicio s SET s.estadoServicio = false where s.idServicio = ?1")
	public void eliminarServicioPorId(int idServ);
}
