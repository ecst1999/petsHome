package com.uisrael.petsHome.services;

import java.util.List;

import com.uisrael.petsHome.model.entity.Duenio;
import com.uisrael.petsHome.model.entity.Mascota;

public interface IMascotaServicio {

	public void insertarMascotas(Mascota nuevaMascota);
	
	public List<Mascota> listarMascotas();
	
	public List<Mascota> buscarMascotaPorEspecie(String especie);
	
	public List<Mascota> buscarMascotaPorDuenio(Duenio duenio);
	
	public List<Mascota> buscarMascotaPorNombre(String nombre);
}
