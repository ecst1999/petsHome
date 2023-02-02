package com.uisrael.petsHome.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "direccion")
public class Direccion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dir_id")
	private int idDireccion;

	@Column(name = "dir_calle_principal", length = 80)
	private String callePrincipal;

	@Column(name = "dir_calle_secundaria", length = 80)
	private String calleSecundaria;

	@Column(name = "dir_numeracion", length = 20)
	private String numeracion;

	@Column(name = "dir_referencia", length = 80)
	private String referencia;

	@Column(name = "dir_codigo_postal", length = 10)
	private String codigoPostal;

	@Column(name = "dir_ciudad", length = 60)
	private String ciudad;

	@Column(name = "dir_provincia", length = 60)
	private String provincia;

	@Column(name = "dir_pais", length = 60)
	private String pais;

	@Column(name = "dir_estado")
	private boolean estadoDireccion = true;
	
	@OneToMany(mappedBy = "fkDireccion")
	private List<Duenio> listaDuenios = new ArrayList<>();
}
