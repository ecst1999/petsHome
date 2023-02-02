package com.uisrael.petsHome.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.uisrael.petsHome.model.entity.Duenio;

public interface IDuenioServicio {

	public void insertarDuenios(Duenio nuevoDuenio);
	
	public List<Duenio> listarDuenios();
	
	public List<Duenio> buscarDuenioPorCedula(String cedula);
	
	public List<Duenio> buscarDuenioPorTelefono(String telefono);
	
	public List<Duenio> buscarDuenioPorApellido(String apellido);
	
	public Duenio buscarDuenioPorId(int idDuenio);
	
	public List<Duenio> buscarDuenioPorEstado(Boolean estado);
	
	public void eliminarDuenioPorId(@Param("idDuenio") int idDuenio);
}
