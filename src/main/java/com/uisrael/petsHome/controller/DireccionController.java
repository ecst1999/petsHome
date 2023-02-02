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

import com.uisrael.petsHome.model.entity.Direccion;
import com.uisrael.petsHome.services.IDireccionServicio;

@Controller
public class DireccionController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IDireccionServicio direccionServicio;
	
	@GetMapping("/listardirecciones")
	public String listadoDirecciones(Model model) {
		List<Direccion> listadoDirecciones = direccionServicio.buscarDireccionPorEstado(true);
		model.addAttribute("direcciones", listadoDirecciones);		
		return "/direccion/listaDirecciones";
	}
	
	@GetMapping("/agregardireccion")
	public String agregarDireccion(Model model) {
		Direccion nuevaDireccion = new Direccion();
		model.addAttribute("direccion", nuevaDireccion);
		return "/direccion/formularioDireccion";
	}
	
	@GetMapping("/editarDireccion/{idDireccion}")
	public String editarDireccion(@PathVariable Integer idDireccion, Model model){
		model.addAttribute("direccion", direccionServicio.buscarDireccionPorId(idDireccion));
		return "/direccion/formularioDireccion";
	}
	
	@PostMapping("/guardarDireccion")
	public String guardarDireccion(@ModelAttribute("direccion") Direccion direccion) {
		direccionServicio.insertarDirecciones(direccion);
		return "redirect:/listardirecciones";
	}
	
	@GetMapping("/eliminarDireccion/{idDir}")
	public String eliminarDireccion(@PathVariable Integer idDir) {
		direccionServicio.eliminarDireccionPorId(idDir);
		return "redirect:/listardirecciones";
	}

}
