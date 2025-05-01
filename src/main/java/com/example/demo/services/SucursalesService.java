package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Sucursales;

public interface SucursalesService {

	List<Sucursales> getAlls();

	Optional<Sucursales> getById(Long id);

	void save(Sucursales rol);

	void delete(Long id);
}
