package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Usuarios;

public interface UsuariosService {
	List<Usuarios> getAllUsuarios();

	Optional<Usuarios> getUsuarioById(Long id);

	void saveUsuarios(Usuarios usuario);

	void deleteUsuarios(Long id);
}
