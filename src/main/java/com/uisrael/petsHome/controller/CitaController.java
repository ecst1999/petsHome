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

import com.uisrael.petsHome.model.entity.Cita;
import com.uisrael.petsHome.model.entity.Mascota;
import com.uisrael.petsHome.model.entity.Servicio;
import com.uisrael.petsHome.services.ICitaServicio;
import com.uisrael.petsHome.services.IMascotaServicio;
import com.uisrael.petsHome.services.IServicioServicio;

@Controller
public class CitaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ICitaServicio citaServicio;
	@Autowired
	private IServicioServicio servicioServicio;
	@Autowired
	private IMascotaServicio mascotaServicio;
	
	@GetMapping("/listarcitas")
	public String listadoCitas(Model model) {
		List<Cita> listaCitas = citaServicio.buscarCitaPorEstado(true);
		model.addAttribute("citas", listaCitas);
		return "/cita/listaCitas";
	}
	
	@GetMapping("/agregarcita")
	public String agregarCita(Model model) {
		Cita nuevaCita = new Cita();
		List<Mascota> listaMascotas = mascotaServicio.buscarMascotaPorEstado(true);
		List<Servicio> listaServicios = servicioServicio.buscarServicioPorEstado(true);
		
		model.addAttribute("servicios", listaServicios);
		model.addAttribute("mascotas", listaMascotas);
		model.addAttribute("cita", nuevaCita);
		
		return "/cita/formularioCita";
	}
	
	@GetMapping("/editarCita/{idCita}")
	public String editarCita(@PathVariable Integer idCita, Model model) {	
		List<Mascota> listaMascotas = mascotaServicio.buscarMascotaPorEstado(true);
		List<Servicio> listaServicios = servicioServicio.buscarServicioPorEstado(true);
		
		model.addAttribute("servicios", listaServicios);
		model.addAttribute("mascotas", listaMascotas);
		model.addAttribute("cita", citaServicio.buscarCitaPorId(idCita));
		return "/cita/formularioCita";
	}
	
	@PostMapping("/guardarCita")
	public String guardarCita(@ModelAttribute("cita") Cita cita) {
		citaServicio.insertarCita(cita);
		return "redirect:/listarcitas";
	}
	
	@GetMapping("/eliminarCita/{idCita}")
	public String eliminarCita(@PathVariable Integer idCita) {		
		citaServicio.eliminarCitaPorId(idCita);
		return "redirect:/listarcitas";
	}

}
