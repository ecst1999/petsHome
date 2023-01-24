package com.uisrael.petsHome.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CitaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@GetMapping("/listarcitas")
	public String listadoCitas() {
		return "/cita/listaCitas";
	}

}
