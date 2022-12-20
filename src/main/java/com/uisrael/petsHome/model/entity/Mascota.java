package com.uisrael.petsHome.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "mascota")
public class Mascota implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mas_id")
	private int idMascota;

	@Column(name = "mas_nombre", length = 40)
	private String nombreMascota;

	@Column(name = "mas_especie", length = 60)
	private String especie;

	@Column(name = "mas_raza", length = 60)
	private String raza;

	@Column(name = "mas_genero", length = 40)
	private String genero;

	@Column(name = "mas_fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name = "mas_estado")
	private boolean estadoMacota;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fkDuenio")
	private Duenio fkDuenio;
	
	@OneToMany(mappedBy = "fkMascota")
	private List<Cita> listaCitas = new ArrayList<>();
}
