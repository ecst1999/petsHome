package com.uisrael.petsHome.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.petsHome.model.entity.Direccion;

public interface IDireccionRepositorio extends JpaRepository<Direccion, Integer> {

	//Consultas personalizadas
	
	@Query("Select d from Direccion d where d.ciudad like %:ciudad%")
	public List<Direccion> buscarPorCiudad(String ciudad);
	
	
	@Query("Select d from Direccion d where d.codigoPostal = ?1")
	public List<Direccion> buscarPorCodigoPostal(String codigoPostal);
	
	@Query("Select d From Direccion d where d.callePrincipal like %:callePrincipal%")
	public List<Direccion> buscarPorCallePrincipal(String callePrincipal);
}
