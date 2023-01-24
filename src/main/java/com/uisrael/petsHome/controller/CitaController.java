package com.uisrael.petsHome.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uisrael.petsHome.model.entity.Cita;
import com.uisrael.petsHome.services.ICitaServicio;

@Controller
public class CitaController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private ICitaServicio citaServicio;
	
	@GetMapping("/listarcitas")
	public String listadoCitas(Model model) {
		List<Cita> listaCitas = citaServicio.listarCitas();		
		model.addAttribute("citas", listaCitas);
		return "/cita/listaCitas";
	}
	
	@GetMapping("/agregarcita")
	public String agregarCita() {
		return "/cita/agregarCita";
	}

}
