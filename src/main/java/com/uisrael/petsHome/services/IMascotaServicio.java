package com.uisrael.petsHome.services;

import java.util.List;

import com.uisrael.petsHome.model.entity.Mascota;

public interface IMascotaServicio {

	public void insertarMascotas(Mascota nuevaMascota);
	
	public List<Mascota> listarMascotas();
}
