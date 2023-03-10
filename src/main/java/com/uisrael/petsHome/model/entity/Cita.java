package com.uisrael.petsHome.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cita")
public class Cita implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cit_id")
	private int idCita;
	
	@Column(name = "cit_motivo", length = 150)
	private String motivo;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "cit_fecha")
	private LocalDate fechaCita;
	
	@Column(name = "cit_estado")
	private boolean estadoCita = true;
	
	@ManyToOne
	@JoinColumn(name = "fkMascota")
	private Mascota fkMascota;
	
	@ManyToOne
	@JoinColumn(name =  "fkServicio")
	private Servicio fkServicio;
}
