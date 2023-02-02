package com.uisrael.petsHome.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uisrael.petsHome.model.entity.Usuario;

import jakarta.transaction.Transactional;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer> {

	@Query("Select u From Usuario u Where u.estadoUsuario = ?1")
	public List<Usuario> buscarUsuariosPorEstado(Boolean estado);
	
	@Query("Select u From Usuario u Where u.idUsuario = ?1")
	public Usuario buscarUsuarioPorId(int id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Usuario u SET u.estadoUsuario = false Where u.idUsuario = ?1")
	public void eliminarUsuarioPorId(int id);
}
