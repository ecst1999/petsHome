package com.uisrael.petsHome.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.uisrael.petsHome.model.entity.Direccion;
import com.uisrael.petsHome.model.repository.IDireccionRepositorio;
import com.uisrael.petsHome.services.IDireccionServicio;

@Service
@Component
public class DireccionServicioImpl implements IDireccionServicio {

	@Autowired
	private IDireccionRepositorio direccionRepositorio;
	
	@Override
	public void insertarDirecciones(Direccion nuevaDireccion) {		
		
		try {
			direccionRepositorio.save(nuevaDireccion);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
	}

	@Override
	public List<Direccion> listarDirecciones() {

		return direccionRepositorio.findAll();
	}

	
	
}
