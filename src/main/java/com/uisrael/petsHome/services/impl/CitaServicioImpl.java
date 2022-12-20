package com.uisrael.petsHome.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.uisrael.petsHome.model.entity.Cita;
import com.uisrael.petsHome.model.repository.ICitaRepositorio;
import com.uisrael.petsHome.services.ICitaServicio;

@Service
@Component
public class CitaServicioImpl implements ICitaServicio {

	@Autowired
	private ICitaRepositorio citaRepositorio;
	
	@Override
	public void insertarCita(Cita nuevaCita) {
		
		try {
			citaRepositorio.save(nuevaCita);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
		
	}

	@Override
	public List<Cita> listarCitas() {
		return citaRepositorio.findAll();
	}

}
