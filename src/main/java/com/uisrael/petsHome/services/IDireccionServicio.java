package com.uisrael.petsHome.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.uisrael.petsHome.model.entity.Direccion;

public interface IDireccionServicio {

	public void insertarDirecciones(Direccion nuevaDireccion);
	
	public List<Direccion> listarDirecciones();
	
	public List<Direccion> buscarPorCiudad(String ciudad);
	
	public List<Direccion> buscarPorCodigoPostal(String codigoPostal);
	
	public List<Direccion> buscarPorCallePrincipal(String callePrincipal);
	
	public List<Direccion> buscarDireccionPorEstado(Boolean estadoDireccion);
	
	public Direccion buscarDireccionPorId(int idDireccion);
	
	public void eliminarDireccionPorId(int idDir);
}
