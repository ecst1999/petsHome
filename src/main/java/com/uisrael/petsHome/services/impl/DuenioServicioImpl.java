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

}
