package com.uisrael.petsHome.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.petsHome.model.entity.Duenio;

public interface IDuenioRepositorio extends JpaRepository<Duenio, Integer> {

	//Consultas personalizadas
	
	@Query("Select d from Duenio d where d.cedula = ?1")
	public List<Duenio> buscarDuenioPorCedula(String cedula);
	
	@Query("Select d from Duenio d where d.telefono = ?1")
	public List<Duenio> buscarDuenioPorTelefono(String telefono);
	
	@Query("Select d from Duenio d where d.apellido like %:apellido%")
	public List<Duenio> buscarDuenioPorApellido(String apellido);
}
