package com.uisrael.petsHome.services;

import java.util.List;

import com.uisrael.petsHome.model.entity.Servicio;

public interface IServicioServicio {

	public void insertarServicios(Servicio nuevoServicio);
	
	public List<Servicio> listarServicios();
}
