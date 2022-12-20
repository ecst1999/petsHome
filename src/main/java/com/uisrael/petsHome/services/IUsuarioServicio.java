package com.uisrael.petsHome.services;

import java.util.List;

import com.uisrael.petsHome.model.entity.Usuario;

public interface IUsuarioServicio {

	public void insertarUsuario(Usuario nuevoUsuario);
	
	public List<Usuario> listarUsuarios();
}
