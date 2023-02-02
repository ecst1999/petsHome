package com.uisrael.petsHome.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "servicio")
public class Servicio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ser_id")
	private int idServicio;
	
	@Column(name = "ser_nombre", length = 80)
	private String nombreServicio;
	
	@Column(name = "ser_consultorio", length = 80)
	private String consultorio;
	
	@Column(name = "ser_tipo", length = 80)
	private String tipoServicio;
	
	@Column(name = "ser_estado")
	private boolean estadoServicio = true;

	@OneToMany(mappedBy = "fkServicio")
	private List<Cita> listaCitas = new ArrayList<>();
}
