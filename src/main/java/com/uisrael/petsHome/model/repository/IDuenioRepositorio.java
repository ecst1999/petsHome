package com.uisrael.petsHome.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uisrael.petsHome.model.entity.Duenio;

import jakarta.transaction.Transactional;

@Repository
public interface IDuenioRepositorio extends JpaRepository<Duenio, Integer> {

	//Consultas personalizadas
	
	@Query("Select d from Duenio d where d.cedula = ?1")
	public List<Duenio> buscarDuenioPorCedula(String cedula);
	
	@Query("Select d from Duenio d where d.telefono = ?1")
	public List<Duenio> buscarDuenioPorTelefono(String telefono);
	
	@Query("Select d from Duenio d where d.apellido like %:apellido%")
	public List<Duenio> buscarDuenioPorApellido(String apellido);
	
	@Query("Select d from Duenio d where d.idDuenio = ?1")
	public Duenio buscarDuenioPorId(int idDuenio);
	
	@Query("Select d from Duenio d where d.estadoDuenio = ?1")
	public List<Duenio> buscarDuenioPorEstado(Boolean estado);
	
	@Transactional
	@Modifying
	@Query("UPDATE Duenio d SET d.estadoDuenio = false WHERE d.idDuenio = :idDuenio")	
	public void eliminarDuenioPorId(@Param("idDuenio") int idDuenio);
}
