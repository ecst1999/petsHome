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

import com.uisrael.petsHome.model.entity.Servicio;
import com.uisrael.petsHome.services.IServicioServicio;

@Controller
public class ServicioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IServicioServicio servicioServicio;
	
	@GetMapping("/listarservicios")
	public String listarServicios(Model model) {
		List<Servicio> listaServicios = servicioServicio.buscarServicioPorEstado(true);
		model.addAttribute("servicios", listaServicios);
		return "/servicio/listaServicios";
	}
	
	@GetMapping("/agregarservicio")
	public String agregarServicio(Model model) {
		Servicio nuevoServicio = new Servicio();
		model.addAttribute("servicio", nuevoServicio);
		return "/servicio/agregarServicio";
	}
	
	@GetMapping("/editarservicio/{idServicio}")
	public String editarServicio(@PathVariable int idServicio, Model model) {
		model.addAttribute("servicio", servicioServicio.buscarServicioPorId(idServicio));
		return "/servicio/agregarServicio";
	}
	
	
	@PostMapping("/guardarservicio")
	public String guardarServicio(@ModelAttribute("servicio") Servicio servicio) {
		servicioServicio.insertarServicios(servicio);
		return "redirect:/listarservicios";
	}
	
	@GetMapping("/eliminarservicio/{idServicio}")
	public String eliminarServicio(@PathVariable int idServicio) {
		servicioServicio.eliminarServicioPorId(idServicio);
		return "redirect:/listarservicios";
	}

}
