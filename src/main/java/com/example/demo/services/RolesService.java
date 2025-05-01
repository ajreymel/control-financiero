package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Roles;

public interface RolesService {

	List<Roles> getAllRoles();

	Optional<Roles> getRolById(Long id);

	void saveRoles(Roles rol);

	void deleteRol(Long id);
}
