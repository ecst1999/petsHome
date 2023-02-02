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

import com.uisrael.petsHome.model.entity.Duenio;
import com.uisrael.petsHome.services.IDuenioServicio;

@Controller
public class DuenioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IDuenioServicio duenioServicio;
	
	@GetMapping("/listarduenios")
	public String listarDuenios(Model model){
		List<Duenio> listadoDuenios = duenioServicio.buscarDuenioPorEstado(true);
		model.addAttribute("duenios", listadoDuenios);
		return "/duenio/listaDuenios";
	}
	
	@GetMapping("/agregarduenio")
	public String agregarDuenio(Model model) {
		Duenio nuevoDuenio = new Duenio();
		model.addAttribute("duenio", nuevoDuenio);
		return "/duenio/agregarDuenio";
	}
	
	@PostMapping("/guardarduenio")
	public String guardarDuenio(@ModelAttribute("duenio") Duenio duenio) {
		duenioServicio.insertarDuenios(duenio);
		return "redirect:/listarduenios";
	}
	
	@GetMapping("/editarduenio/{idDue}")
	public String editarDuenio(@PathVariable int idDue, Model model) {
		model.addAttribute("duenio", duenioServicio.buscarDuenioPorId(idDue));
		return "/duenio/agregarDuenio";
	}
	
	@GetMapping("/eliminarduenio/{idDue}")
	public String eliminarDuenio(@PathVariable int idDue) {
		duenioServicio.eliminarDuenioPorId(idDue);
		return "redirect:/listarduenios";
	}

}
