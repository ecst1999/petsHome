package com.uisrael.petsHome.services;

import java.util.List;

import com.uisrael.petsHome.model.entity.Cita;

public interface ICitaServicio {

	public void insertarCita(Cita nuevaCita);
	
	public List<Cita> listarCitas();
}
