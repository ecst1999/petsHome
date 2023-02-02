package com.uisrael.petsHome.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.uisrael.petsHome.model.entity.Cita;
import com.uisrael.petsHome.model.entity.Mascota;
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

	@Override
	public List<Cita> buscarCitaPorFecha(LocalDate fecha) {
		// TODO Auto-generated method stub
		return citaRepositorio.buscarCitaPorFecha(fecha);
	}

	@Override
	public List<Cita> buscarCitaPorEstado(Boolean estado) {
		// TODO Auto-generated method stub
		return citaRepositorio.buscarCitaPorEstado(estado);
	}

	@Override
	public List<Cita> buscarCitaPorMotivo(String motivo) {
		// TODO Auto-generated method stub
		return citaRepositorio.buscarCitaPorMotivo(motivo);
	}

	@Override
	public Cita buscarCitaPorId(int id) {
		// TODO Auto-generated method stub
		return citaRepositorio.buscarCitaPorId(id);
	}

	@Override
	public void eliminarCitaPorId(int id) {
		// TODO Auto-generated method stub
		try {			
			citaRepositorio.eliminarCitaPorId(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
