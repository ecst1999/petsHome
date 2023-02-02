package com.uisrael.petsHome.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uisrael.petsHome.model.entity.Duenio;
import com.uisrael.petsHome.model.entity.Mascota;

import jakarta.transaction.Transactional;

@Repository
public interface IMascotaRepositorio extends JpaRepository<Mascota, Integer> {

	//Consultas personalizadas
	
	@Query("Select m from Mascota m where m.especie like %:especie%")
	public List<Mascota> buscarMascotaPorEspecie(String especie);
	
	@Query("Select m from Mascota m where m.fkDuenio = ?1")
	public List<Mascota> buscarMascotaPorDuenio(Duenio duenio);
	
	@Query("Select m from Mascota m where m.nombreMascota like %:nombre%")
	public List<Mascota> buscarMascotaPorNombre(String nombre);
	
	@Query("Select m from Mascota m where m.estadoMascota = ?1")
	public List<Mascota> buscarMascotaPorEstado(Boolean estado);
	
	@Query("Select m from Mascota m where m.idMascota = ?1")
	public Mascota buscarMascotaPorId(int idMascota);
	
	@Transactional
	@Modifying
	@Query("UPDATE Mascota m SET m.estadoMascota = false WHERE m.idMascota = ?1")
	public void eliminarMascotaPorId(int idMascota);
}
