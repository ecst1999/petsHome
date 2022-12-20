package com.uisrael.petsHome.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.uisrael.petsHome.model.entity.Mascota;
import com.uisrael.petsHome.model.repository.IMascotaRepositorio;
import com.uisrael.petsHome.services.IMascotaServicio;

@Service
@Component
public class MascotaServicioImpl implements IMascotaServicio {

	@Autowired
	private IMascotaRepositorio mascotaRepositorio;

	@Override
	public void insertarMascotas(Mascota nuevaMascota) {		
		
		try {
			mascotaRepositorio.save(nuevaMascota);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

	}

	@Override
	public List<Mascota> listarMascotas() {

		return mascotaRepositorio.findAll();
	}

}
