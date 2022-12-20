package com.uisrael.petsHome.services;

import java.util.List;

import com.uisrael.petsHome.model.entity.Duenio;

public interface IDuenioServicio {

	public void insertarDuenios(Duenio nuevoDuenio);
	
	public List<Duenio> listarDuenios();
}
