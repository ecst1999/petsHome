package com.uisrael.petsHome;

import java.time.LocalDate;
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

	@Test
	void contextLoads() {			

		// Usuario
		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.setNombreUsuario("Steve Carvajal");
		nuevoUsuario.setEmail("steve_carvajal@mail.com");
		nuevoUsuario.setClave("12345678");
		nuevoUsuario.setEstadoUsuario(true);

		//usuarioServicio.insertarUsuario(nuevoUsuario);

		// Direccion
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

		// Duenio
		Duenio nuevoDuenio = new Duenio();
		nuevoDuenio.setCedula("1709876543");
		nuevoDuenio.setNombre("Daniela");
		nuevoDuenio.setApellido("Carrera");
		nuevoDuenio.setTelefono("0987654321");
		nuevoDuenio.setEmail("dcarrera@mail.com");
		nuevoDuenio.setEstadoDuenio(true);
		nuevoDuenio.setFkDireccion(nuevaDireccion);

		//duenioServicio.insertarDuenios(nuevoDuenio);

		// Mascota
		Mascota nuevaMascota = new Mascota();
		nuevaMascota.setNombreMascota("Firulay");
		nuevaMascota.setEspecie("Perro");
		nuevaMascota.setRaza("Beagle");
		nuevaMascota.setGenero("Macho");
		nuevaMascota.setFechaNacimiento(LocalDate.of(2012, 3, 15));		
		nuevaMascota.setFkDuenio(nuevoDuenio);

		//mascotaServicio.insertarMascotas(nuevaMascota);

		// Servicio
		Servicio nuevoServicio = new Servicio();
		nuevoServicio.setNombreServicio("Peluqueria");
		nuevoServicio.setConsultorio("Peluqueria 05 Piso 4");
		nuevoServicio.setTipoServicio("Estetica");
		nuevoServicio.setEstadoServicio(true);

		//servicioServicio.insertarServicios(nuevoServicio);

		// Cita
		Cita nuevaCita = new Cita();
		nuevaCita.setMotivo("Corte de pelo");
		nuevaCita.setFechaCita(LocalDate.of(2023, 02, 20));
		nuevaCita.setEstadoCita(true);
		nuevaCita.setFkServicio(nuevoServicio);
		nuevaCita.setFkMascota(nuevaMascota);

		//citaServicio.insertarCita(nuevaCita);

		List<Cita> citasPorFecha = citaServicio.buscarCitaPorFecha(LocalDate.of(2023, 02, 20));

		citasPorFecha.forEach(cita -> {
			System.out.println(cita.getMotivo() + " " + cita.getFechaCita());
		});

		List<Cita> citasPorEstado = citaServicio.buscarCitaPorEstado(true);

		System.out.println("cita por estado");

		citasPorEstado.forEach(cita -> {
			System.out.println(cita.getMotivo() + " " + cita.isEstadoCita());
		});

		System.out.println("cita por motivo");

		List<Cita> citasPorMotivo = citaServicio.buscarCitaPorMotivo("pelo");

		citasPorMotivo.forEach(cita -> {
			System.out.println(cita.getMotivo());
		});

		System.out.println("Direcciones por ciudad:");

		List<Direccion> direccionesPorCiudad = direccionServicio.buscarPorCiudad("Quito");

		direccionesPorCiudad.forEach(direccion -> {
			System.out.println(direccion.getCallePrincipal() + " " + direccion.getCiudad());
		});

		System.out.println("Direcciones por codigo postal:");

		List<Direccion> direccionesPorCodigo = direccionServicio.buscarPorCodigoPostal("E170123");

		direccionesPorCodigo.forEach(direccion -> {
			System.out.println(direccion.getCallePrincipal() + " " + direccion.getCodigoPostal());
		});

		System.out.println("Direcciones por calle principal:");

		List<Direccion> direccionesPorCallePrin = direccionServicio.buscarPorCallePrincipal("Vicente");

		direccionesPorCallePrin.forEach(direccion -> {
			System.out.println(direccion.getCallePrincipal() + " " + direccion.getCalleSecundaria());
		});

		System.out.println("Dueños por cedula:");

		List<Duenio> dueniosPorCedula = duenioServicio.buscarDuenioPorCedula("1709876543");

		dueniosPorCedula.forEach(duenio -> {
			System.out.println(duenio.getCedula() + " " + duenio.getNombre() + " " + duenio.getApellido());
		});

		System.out.println("Dueños por celular:");

		List<Duenio> dueniosPorTelefono = duenioServicio.buscarDuenioPorTelefono("0987654321");

		dueniosPorTelefono.forEach(duenio -> {
			System.out.println(duenio.getTelefono() + " " + duenio.getNombre() + " " + duenio.getApellido());
		});

		System.out.println("Dueños por apellido:");
		
		List<Duenio> dueniosPorApellido = duenioServicio.buscarDuenioPorApellido("Carrera");		
		
		dueniosPorApellido.forEach(duenio -> {
			System.out.println(duenio.getNombre() + " " + duenio.getApellido());
		});
		
		System.out.println("Mascotas por especie:");
		
		List<Mascota> mascotasPorEspecie = mascotaServicio.buscarMascotaPorEspecie("Perro");
		
		mascotasPorEspecie.forEach(mascota -> {
			System.out.println(mascota.getNombreMascota() + " " + mascota.getEspecie() + " " + mascota.getFkDuenio().getNombre() + " " + mascota.getFkDuenio().getApellido());
		});
		
		System.out.println("Mascotas por dueños:");
		
		Duenio duenio = new Duenio();
		duenio.setIdDuenio(1);
		
		List<Mascota> mascotasPorDuenios = mascotaServicio.buscarMascotaPorDuenio(duenio);
		
		mascotasPorDuenios.forEach(mascotas -> {
			System.out.println(mascotas.getNombreMascota() + " " + mascotas.getFkDuenio().getNombre());
		});
		
		List<Mascota> mascotasPorNombre = mascotaServicio.buscarMascotaPorNombre("Firulay");
		
		mascotasPorNombre.forEach(mascota -> {
			System.out.println(mascota.getNombreMascota() + " " + mascota.getFkDuenio().getNombre());
		});
		
		System.out.println("Servicios por consultorio:");
		
		List<Servicio> serviciosPorConsultorio = servicioServicio.buscarServicioPorConsultorio("Peluqueria 05 Piso 4");
		
		serviciosPorConsultorio.forEach(servicio -> {
			System.out.println(servicio.getConsultorio() + " " + servicio.getNombreServicio());
		});
		
		System.out.println("Servicios por nombre:");
		
		List<Servicio> serviciosPorNombre = servicioServicio.buscarServicioPorNombre("Peluqueria");
		
		serviciosPorNombre.forEach(servicio -> {
			System.out.println(servicio.getNombreServicio() + " " + servicio.getConsultorio() + " " + servicio.getTipoServicio());
		});
		
		System.out.println("Servicios por tipo:");
		
		List<Servicio> serviciosPorTipo = servicioServicio.buscarServicioPorTipo("Estetica");
		
		serviciosPorTipo.forEach(servicio -> {
			System.out.println(servicio.getTipoServicio() + " " + servicio.getNombreServicio());
		});
	}

}
