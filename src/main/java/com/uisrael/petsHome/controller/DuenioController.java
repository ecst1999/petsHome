package com.uisrael.petsHome.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uisrael.petsHome.model.entity.Duenio;
import com.uisrael.petsHome.services.IDuenioServicio;

@Controller
public class DuenioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IDuenioServicio duenioServicio;
	
	@GetMapping("/listarduenios")
	public String listarDuenios(Model model){
		List<Duenio> listadoDuenios = duenioServicio.listarDuenios();
		model.addAttribute("duenios", listadoDuenios);
		return "/duenio/listaDuenios";
	}
	
	@GetMapping("/agregarduenio")
	public String agregarDuenio() {
		return "/duenio/agregarDuenio";
	}

}
