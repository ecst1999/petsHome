package com.uisrael.petsHome.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uisrael.petsHome.model.entity.Direccion;

import jakarta.transaction.Transactional;

@Repository
public interface IDireccionRepositorio extends JpaRepository<Direccion, Integer> {

	//Consultas personalizadas
	
	@Query("Select d from Direccion d where d.ciudad like %:ciudad%")
	public List<Direccion> buscarPorCiudad(String ciudad);	
	
	@Query("Select d from Direccion d where d.codigoPostal = ?1")
	public List<Direccion> buscarPorCodigoPostal(String codigoPostal);
	
	@Query("Select d From Direccion d where d.callePrincipal like %:callePrincipal%")
	public List<Direccion> buscarPorCallePrincipal(String callePrincipal);
	
	@Query("Select d From Direccion d where d.estadoDireccion = ?1")
	public List<Direccion> buscarDireccionPorEstado(Boolean estadoDireccion);
	
	@Query("Select d From Direccion d where d.idDireccion = ?1")
	public Direccion buscarDireccionPorId(int idDireccion);	
	
	@Transactional
	@Modifying
	@Query("UPDATE Direccion d SET d.estadoDireccion = false WHERE d.idDireccion = :idDir")
	public void eliminarDireccionPorId(@Param("idDir") int idDir);
}

