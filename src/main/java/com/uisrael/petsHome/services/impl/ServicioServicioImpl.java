package com.uisrael.petsHome.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.uisrael.petsHome.model.entity.Servicio;
import com.uisrael.petsHome.model.repository.IServicioRepositorio;
import com.uisrael.petsHome.services.IServicioServicio;

@Service
@Component
public class ServicioServicioImpl implements IServicioServicio {

	@Autowired
	private IServicioRepositorio servicioRepositorio;

	@Override
	public void insertarServicios(Servicio nuevoServicio) {		
		
		try {
			servicioRepositorio.save(nuevoServicio);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

	}

	@Override
	public List<Servicio> listarServicios() {

		return servicioRepositorio.findAll();
		
	}

}
