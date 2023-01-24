package com.uisrael.petsHome.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uisrael.petsHome.model.entity.Direccion;
import com.uisrael.petsHome.services.IDireccionServicio;

@Controller
public class DireccionController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IDireccionServicio direccionServicio;
	
	@GetMapping("/listardirecciones")
	public String listadoDirecciones(Model model) {
		List<Direccion> listadoDirecciones = direccionServicio.listarDirecciones();
		model.addAttribute("direcciones", listadoDirecciones);
		
		return "/direccion/listaDirecciones";
	}
	
	@GetMapping("/agregardireccion")
	public String agregarDireccion() {
		return "/direccion/agregarDireccion";
	}

}
