package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	@NotNull
	@Column(unique = true)
	private String username;

	@ManyToOne
	@JoinColumn(name = "id_rol")
	@NotNull
	private Roles rol;

	@Size(max = 50)
	@NotNull
	private String descripcion;

	@Size(max = 255)
	@NotNull
	private String contrasena;

	@NotNull
	private boolean estado;

	@ManyToOne
	@JoinColumn(name = "id_sucursal")
	private Sucursales sucursal;
}
