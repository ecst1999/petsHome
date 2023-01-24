package com.uisrael.petsHome.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uisrael.petsHome.model.entity.Mascota;
import com.uisrael.petsHome.services.IMascotaServicio;

@Controller
public class MascotaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IMascotaServicio mascotaServicio;
	
	@GetMapping("/listarmascotas")
	public String listarMascotas(Model model) {
		List<Mascota> listaMascotas = mascotaServicio.listarMascotas();
		model.addAttribute("mascotas", listaMascotas);
		return "/mascota/listaMascotas";
	}
	
	@GetMapping("/agregarmascota")
	public String agregarMascota() {
		return "/mascota/agregarMascota";
	}

}
