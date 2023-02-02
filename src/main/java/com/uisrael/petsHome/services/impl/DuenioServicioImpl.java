package com.uisrael.petsHome.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.uisrael.petsHome.model.entity.Duenio;
import com.uisrael.petsHome.model.repository.IDuenioRepositorio;
import com.uisrael.petsHome.services.IDuenioServicio;

@Service
@Component
public class DuenioServicioImpl implements IDuenioServicio {

	@Autowired
	private IDuenioRepositorio duenioRepositorio;

	@Override
	public void insertarDuenios(Duenio nuevoDuenio) {		
		
		try {
			duenioRepositorio.save(nuevoDuenio);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

	}

	@Override
	public List<Duenio> listarDuenios() {

		return duenioRepositorio.findAll();
	}

	@Override
	public List<Duenio> buscarDuenioPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return duenioRepositorio.buscarDuenioPorCedula(cedula);
	}

	@Override
	public List<Duenio> buscarDuenioPorTelefono(String telefono) {
		// TODO Auto-generated method stub
		return duenioRepositorio.buscarDuenioPorTelefono(telefono);
	}

	@Override
	public List<Duenio> buscarDuenioPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return duenioRepositorio.buscarDuenioPorApellido(apellido);
	}

	@Override
	public Duenio buscarDuenioPorId(int idDuenio) {
		// TODO Auto-generated method stub
		return duenioRepositorio.buscarDuenioPorId(idDuenio);
	}

	@Override
	public void eliminarDuenioPorId(int idDuenio) {
		// TODO Auto-generated method stub
		duenioRepositorio.eliminarDuenioPorId(idDuenio);
	}

	@Override
	public List<Duenio>  buscarDuenioPorEstado(Boolean estado) {
		// TODO Auto-generated method stub
		return duenioRepositorio.buscarDuenioPorEstado(estado);
	}

}
