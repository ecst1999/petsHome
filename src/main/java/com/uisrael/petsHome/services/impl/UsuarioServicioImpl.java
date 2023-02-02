package com.uisrael.petsHome.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.uisrael.petsHome.model.entity.Usuario;
import com.uisrael.petsHome.model.repository.IUsuarioRepositorio;
import com.uisrael.petsHome.services.IUsuarioServicio;

@Service
@Component
public class UsuarioServicioImpl implements IUsuarioServicio {

	@Autowired
	private IUsuarioRepositorio usuarioRepositorio;
	
	@Override
	public void insertarUsuario(Usuario nuevoUsuario) {		
		
		try {
			usuarioRepositorio.save(nuevoUsuario);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
	}

	@Override
	public List<Usuario> listarUsuarios() {

		return usuarioRepositorio.findAll();
	}

	@Override
	public List<Usuario> buscarUsuariosPorEstado(Boolean estado) {
		// TODO Auto-generated method stub
		return usuarioRepositorio.buscarUsuariosPorEstado(estado);
	}

	@Override
	public Usuario buscarUsuarioPorId(int id) {
		// TODO Auto-generated method stub
		return usuarioRepositorio.buscarUsuarioPorId(id);
	}

	@Override
	public void eliminarUsuarioPorId(int id) {
		// TODO Auto-generated method stub
		try {
			usuarioRepositorio.eliminarUsuarioPorId(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
