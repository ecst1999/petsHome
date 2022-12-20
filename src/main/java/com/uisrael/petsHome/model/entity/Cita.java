package com.uisrael.petsHome.model.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cita")
public class Cita implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cit_id")
	private int idCita;
	
	@Column(name = "cit_motivo", length = 150)
	private String motivo;
	
	@Column(name = "cit_fecha")
	private Date fechaCita;
	
	@Column(name = "cit_estado")
	private boolean estadoCita;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fkMascota")
	private Mascota fkMascota;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name =  "fkServicio")
	private Servicio fkServicio;
}
