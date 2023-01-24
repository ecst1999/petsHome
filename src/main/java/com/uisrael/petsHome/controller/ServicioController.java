package com.uisrael.petsHome.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uisrael.petsHome.model.entity.Servicio;
import com.uisrael.petsHome.services.IServicioServicio;

@Controller
public class ServicioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IServicioServicio servicioServicio;
	
	@GetMapping("/listarservicios")
	public String listarServicios(Model model) {
		List<Servicio> listaServicios = servicioServicio.listarServicios();
		model.addAttribute("servicios", listaServicios);
		return "/servicio/listaServicios";
	}
	
	@GetMapping("/agregarservicio")
	public String agregarServicio() {
		return "/servicio/agregarServicio";
	}

}
