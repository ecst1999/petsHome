package com.uisrael.petsHome.services;

import java.time.LocalDate;
import java.util.List;

import com.uisrael.petsHome.model.entity.Cita;
import com.uisrael.petsHome.model.entity.Mascota;

public interface ICitaServicio {

	public void insertarCita(Cita nuevaCita);
	
	public List<Cita> listarCitas();
	
	public List<Cita> buscarCitaPorFecha(LocalDate fecha);
	
	public List<Cita> buscarCitaPorEstado(Boolean estado);
	
	public List<Cita> buscarCitaPorMotivo(String motivo);
}
