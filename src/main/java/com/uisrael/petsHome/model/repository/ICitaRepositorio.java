package com.uisrael.petsHome.model.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uisrael.petsHome.model.entity.Cita;
import com.uisrael.petsHome.model.entity.Mascota;

import jakarta.transaction.Transactional;

@Repository
public interface ICitaRepositorio extends JpaRepository<Cita, Integer> {

	//consultas personalizadas 
	
	@Query("Select c From Cita c where c.fechaCita = ?1 ")
	public List<Cita> buscarCitaPorFecha(LocalDate fecha);
	
	@Query("Select c From Cita c where c.estadoCita = ?1")
	public List<Cita> buscarCitaPorEstado(Boolean estado);
	
	@Query("Select c From Cita c where c.motivo like %:motivo%")
	public List<Cita> buscarCitaPorMotivo(String motivo);
	
	@Query("Select c From Cita c where c.idCita = ?1")
	public Cita buscarCitaPorId(int id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Cita c SET c.estadoCita = false WHERE c.idCita = :idCita")
	public void eliminarCitaPorId(@Param("idCita") int cita);
}
