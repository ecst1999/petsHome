package com.uisrael.petsHome.services;

import java.util.List;

import com.uisrael.petsHome.model.entity.Direccion;

public interface IDireccionServicio {

	public void insertarDirecciones(Direccion nuevaDireccion);
	
	public List<Direccion> listarDirecciones();
}
