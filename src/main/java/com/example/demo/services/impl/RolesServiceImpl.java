package com.example.demo.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Roles;
import com.example.demo.repositories.RolesRepository;
import com.example.demo.services.RolesService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RolesServiceImpl implements RolesService {

	private final RolesRepository rolesRepository;

	@Override
	public List<Roles> getAllRoles() {
		return this.rolesRepository.findByAll();
	}

	@Override
	public Optional<Roles> getRolById(Long id) {
		return this.rolesRepository.findById(id);
	}

	@Override
	public void saveRoles(Roles rol) {
		if (Objects.nonNull(rol)) {
			this.rolesRepository.save(rol);
		}
	}

	@Override
	public void deleteRol(Long id) {
		if(Objects.nonNull(id)) {
			this.rolesRepository.findById(id).ifPresent(rol -> this.rolesRepository.delete(rol));
		}
	}

}
