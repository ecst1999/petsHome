package com.uisrael.petsHome.services;

import java.util.List;

import com.uisrael.petsHome.model.entity.Servicio;

public interface IServicioServicio {

	public void insertarServicios(Servicio nuevoServicio);
	
	public List<Servicio> listarServicios();
	
	public List<Servicio> buscarServicioPorConsultorio(String consultorio);
	
	public List<Servicio> buscarServicioPorNombre(String nombre);
	
	public List<Servicio> buscarServicioPorTipo(String tipoServicio);
	
	public List<Servicio> buscarServicioPorEstado(Boolean estado);
	
	public Servicio buscarServicioPorId(int idServ);
	
	public void eliminarServicioPorId(int idServ);
}
