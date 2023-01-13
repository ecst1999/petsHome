package com.uisrael.petsHome.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.petsHome.model.entity.Duenio;
import com.uisrael.petsHome.model.entity.Mascota;

public interface IMascotaRepositorio extends JpaRepository<Mascota, Integer> {

	//Consultas personalizadas
	
	@Query("Select m from Mascota m where m.especie like %:especie%")
	public List<Mascota> buscarMascotaPorEspecie(String especie);
	
	@Query("Select m from Mascota m where m.fkDuenio = ?1")
	public List<Mascota> buscarMascotaPorDuenio(Duenio duenio);
	
	@Query("Select m from Mascota m where m.nombreMascota like %:nombre%")
	public List<Mascota> buscarMascotaPorNombre(String nombre);
}
