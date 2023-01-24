package com.uisrael.petsHome.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uisrael.petsHome.model.entity.Usuario;
import com.uisrael.petsHome.services.IUsuarioServicio;

@Controller
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@GetMapping("/listarusuarios")
	public String listarUsuarios(Model model) {
		List<Usuario> listaUsuarios = usuarioServicio.listarUsuarios();
		model.addAttribute("usuarios", listaUsuarios);
		return "/usuario/listaUsuarios";
	}
	
	@GetMapping("/agregarusuario")
	public String agregarUsuario() {
		return "/usuario/agregarUsuario";
	}

}
