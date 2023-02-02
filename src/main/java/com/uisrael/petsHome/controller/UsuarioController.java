package com.uisrael.petsHome.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.petsHome.model.entity.Usuario;
import com.uisrael.petsHome.services.IUsuarioServicio;

@Controller
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@GetMapping("/listarusuarios")
	public String listarUsuarios(Model model) {
		List<Usuario> listaUsuarios = usuarioServicio.buscarUsuariosPorEstado(true);
		model.addAttribute("usuarios", listaUsuarios);
		return "/usuario/listaUsuarios";
	}
	
	@GetMapping("/agregarusuario")
	public String agregarUsuario(Model model) {
		Usuario nuevoUsuario = new Usuario();
		model.addAttribute("usuario", nuevoUsuario);
		return "/usuario/agregarUsuario";
	}
	
	@PostMapping("/guardarusuario")
	public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		usuarioServicio.insertarUsuario(usuario);
		return "redirect:/listarusuarios";
	}
	
	@GetMapping("/editarusuario/{idUsuario}")
	public String editarUsuario(@PathVariable int idUsuario, Model model) {
		model.addAttribute("usuario", usuarioServicio.buscarUsuarioPorId(idUsuario));
		return "/usuario/agregarUsuario";
	}
	
	@GetMapping("/eliminarusuario/{idUsuario}")
	public String eliminarUsuario(@PathVariable int idUsuario) {
		usuarioServicio.eliminarUsuarioPorId(idUsuario);
		return "redirect:/listarusuarios";
	}

}
