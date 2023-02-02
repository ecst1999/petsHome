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
import com.uisrael.petsHome.model.entity.Mascota;
import com.uisrael.petsHome.services.IDuenioServicio;
import com.uisrael.petsHome.services.IMascotaServicio;

@Controller
public class MascotaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IMascotaServicio mascotaServicio;
	@Autowired
	private IDuenioServicio duenioServicio;
	
	@GetMapping("/listarmascotas")
	public String listarMascotas(Model model) {
		List<Mascota> listaMascotas = mascotaServicio.buscarMascotaPorEstado(true);
		model.addAttribute("mascotas", listaMascotas);
		return "/mascota/listaMascotas";
	}
	
	@GetMapping("/agregarmascota")
	public String agregarMascota(Model model) {
		Mascota nuevaMascota = new Mascota();
		List<Duenio> listaDuenios = duenioServicio.buscarDuenioPorEstado(true);
		model.addAttribute("mascota", nuevaMascota);
		model.addAttribute("duenios", listaDuenios);
		return "/mascota/agregarMascota";
	}
	
	
	@PostMapping("/guardarmascota")
	public String guardarMascota(@ModelAttribute("mascota") Mascota nuevamascota) {
		mascotaServicio.insertarMascotas(nuevamascota);
		return "redirect:/listarmascotas";
	}
	
	@GetMapping("/eliminarmascota/{idMascota}")
	public String eliminarMascota(@PathVariable Integer idMascota) {
		mascotaServicio.eliminarMascotaPorId(idMascota);
		return "redirect:/listarmascotas"; 
	}
	
	@GetMapping("/editarmascota/{idMascota}")
	public String editarMascota(@PathVariable Integer idMascota, Model model) {
		List<Duenio> listaDuenios = duenioServicio.buscarDuenioPorEstado(true);
		model.addAttribute("mascota", mascotaServicio.buscarMascotaPorId(idMascota));
		model.addAttribute("duenios", listaDuenios);
		return "/mascota/agregarMascota";
	}

}
