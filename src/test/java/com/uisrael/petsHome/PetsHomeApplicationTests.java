package com.uisrael.petsHome;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.uisrael.petsHome.model.entity.Cita;
import com.uisrael.petsHome.model.entity.Direccion;
import com.uisrael.petsHome.model.entity.Duenio;
import com.uisrael.petsHome.model.entity.Mascota;
import com.uisrael.petsHome.model.entity.Servicio;
import com.uisrael.petsHome.model.entity.Usuario;
import com.uisrael.petsHome.services.ICitaServicio;
import com.uisrael.petsHome.services.IDireccionServicio;
import com.uisrael.petsHome.services.IDuenioServicio;
import com.uisrael.petsHome.services.IMascotaServicio;
import com.uisrael.petsHome.services.IServicioServicio;
import com.uisrael.petsHome.services.IUsuarioServicio;




@SpringBootTest
class PetsHomeApplicationTests {

	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@Autowired
	private IDireccionServicio direccionServicio;
	
	@Autowired
	private IDuenioServicio duenioServicio;
	
	@Autowired
	private IMascotaServicio mascotaServicio;
	
	@Autowired
	private IServicioServicio servicioServicio;
	
	@Autowired
	private ICitaServicio citaServicio;
	
	 private static final Logger logger = LogManager.getLogger(PetsHomeApplicationTests.class);

	
	@Test
	void contextLoads() {
		
		
		//Usuario
		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.setNombreUsuario("Steve Carvajal");
		nuevoUsuario.setEmail("steve_carvajal@mail.com");
		nuevoUsuario.setClave("12345678");
		nuevoUsuario.setEstadoUsuario(true);
		
		//usuarioServicio.insertarUsuario(nuevoUsuario);
		
		//Direccion
		Direccion nuevaDireccion = new Direccion();
		nuevaDireccion.setCallePrincipal("Pedro Vicente Maldonado");
		nuevaDireccion.setCalleSecundaria("21 de agosto");
		nuevaDireccion.setNumeracion("EU-123");
		nuevaDireccion.setReferencia("Diagonal a la farmacia Sana Sana");
		nuevaDireccion.setCodigoPostal("E170123");
		nuevaDireccion.setCiudad("Quito");
		nuevaDireccion.setProvincia("Pichincha");
		nuevaDireccion.setPais("Ecuador");
		nuevaDireccion.setEstadoDireccion(true);
		
		//direccionServicio.insertarDirecciones(nuevaDireccion);
		
		//Duenio
		Duenio nuevoDuenio = new Duenio();
		nuevoDuenio.setCedula("1709876543");
		nuevoDuenio.setNombre("Daniela");
		nuevoDuenio.setApellido("Carrera");
		nuevoDuenio.setTelefono("0987654321");
		nuevoDuenio.setEmail("dcarrera@mail.com");
		nuevoDuenio.setEstadoDuenio(true);
		nuevoDuenio.setFkDireccion(nuevaDireccion);
		
		//duenioServicio.insertarDuenios(nuevoDuenio);
		
		//Macota
		Mascota nuevaMascota = new Mascota();
		nuevaMascota.setNombreMascota("Firulay");
		nuevaMascota.setEspecie("Perro");
		nuevaMascota.setRaza("Beagle");
		nuevaMascota.setGenero("Macho");
		nuevaMascota.setFechaNacimiento(new Date(2012, 3, 15));
		nuevaMascota.setEstadoMacota(true);
		nuevaMascota.setFkDuenio(nuevoDuenio);
		
		//mascotaServicio.insertarMascotas(nuevaMascota);
		
		//Servicio
		Servicio nuevoServicio = new Servicio();
		nuevoServicio.setNombreServicio("Peluqueria");
		nuevoServicio.setConsultorio("Peluqueria 05 Piso 4");
		nuevoServicio.setTipoServicio("Estetica");
		nuevoServicio.setEstadoServicio(true);
		
		//servicioServicio.insertarServicios(nuevoServicio);
		
		//Cita
		Cita nuevaCita = new Cita();
		nuevaCita.setMotivo("Corte de pelo");
		nuevaCita.setFechaCita(new Date(2022, 12, 27));
		nuevaCita.setEstadoCita(true);
		nuevaCita.setFkServicio(nuevoServicio);
		nuevaCita.setFkMascota(nuevaMascota);
		
		//citaServicio.insertarCita(nuevaCita);
		
		List<Mascota> listadoMascotas = mascotaServicio.listarMascotas();		
		
		logger.debug(listadoMascotas);
		
		listadoMascotas.forEach(mascotas -> {
			logger.debug(mascotas);
		});
		
	}

}
