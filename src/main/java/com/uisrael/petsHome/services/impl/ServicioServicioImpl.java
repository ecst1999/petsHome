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

	@Override
	public List<Servicio> buscarServicioPorConsultorio(String consultorio) {
		// TODO Auto-generated method stub
		return servicioRepositorio.buscarServicioPorConsultorio(consultorio);
	}

	@Override
	public List<Servicio> buscarServicioPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return servicioRepositorio.buscarServicioPorNombre(nombre);
	}

	@Override
	public List<Servicio> buscarServicioPorTipo(String tipoServicio) {
		// TODO Auto-generated method stub
		return servicioRepositorio.buscarServicioPorTipo(tipoServicio);
	}

	@Override
	public List<Servicio> buscarServicioPorEstado(Boolean estado) {
		// TODO Auto-generated method stub
		return servicioRepositorio.buscarServicioPorEstado(estado);
	}

	@Override
	public Servicio buscarServicioPorId(int idServ) {
		// TODO Auto-generated method stub
		return servicioRepositorio.buscarServicioPorId(idServ);
	}

	@Override
	public void eliminarServicioPorId(int idServ) {
		// TODO Auto-generated method stub
		try {
			servicioRepositorio.eliminarServicioPorId(idServ);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
