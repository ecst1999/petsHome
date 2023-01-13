package com.uisrael.petsHome.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.uisrael.petsHome.model.entity.Duenio;
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

	@Override
	public List<Mascota> buscarMascotaPorEspecie(String especie) {
		// TODO Auto-generated method stub
		return mascotaRepositorio.buscarMascotaPorEspecie(especie);
	}

	@Override
	public List<Mascota> buscarMascotaPorDuenio(Duenio duenio) {
		// TODO Auto-generated method stub
		return mascotaRepositorio.buscarMascotaPorDuenio(duenio);
	}

	@Override
	public List<Mascota> buscarMascotaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return mascotaRepositorio.buscarMascotaPorNombre(nombre);
	}

}
