package com.uisrael.petsHome.model.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usr_id")
	private int idUsuario;

	@Column(name = "usr_nombre", length = 70)
	private String nombreUsuario;

	@Column(name = "usr_email", length = 80)
	private String email;

	@Column(name = "usr_clave", length = 200)
	private String clave;

	@Column(name = "usr_estado")
	private boolean estadoUsuario = true;
}
