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

	@Override
	public List<Direccion> buscarPorCiudad(String ciudad) {
		// TODO Auto-generated method stub
		return direccionRepositorio.buscarPorCiudad(ciudad);
	}

	@Override
	public List<Direccion> buscarPorCodigoPostal(String codigoPostal) {
		// TODO Auto-generated method stub
		return direccionRepositorio.buscarPorCodigoPostal(codigoPostal);
	}

	@Override
	public List<Direccion> buscarPorCallePrincipal(String callePrincipal) {
		// TODO Auto-generated method stub
		return direccionRepositorio.buscarPorCallePrincipal(callePrincipal);
	}

	
	
}
