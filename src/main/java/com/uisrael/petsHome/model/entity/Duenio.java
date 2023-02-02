package com.uisrael.petsHome.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "duenio")
public class Duenio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "due_id")
	private int idDuenio;

	@Column(name = "due_cedula", length = 13)
	private String cedula;

	@Column(name = "due_nombre", length = 50)
	private String nombre;

	@Column(name = "due_apellido", length = 50)
	private String apellido;

	@Column(name = "due_telefono", length = 10)
	private String telefono;

	@Column(name = "due_email", length = 50)
	private String email;

	@Column(name = "due_estado")
	private boolean estadoDuenio = true;
	
	@OneToMany(mappedBy = "fkDuenio")
	private List<Mascota> listaMascota = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "fkDireccion")
	private Direccion fkDireccion;
}
