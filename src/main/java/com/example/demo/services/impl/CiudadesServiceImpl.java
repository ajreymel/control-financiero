package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Ciudades;
import com.example.demo.repositories.CiudadesRepository;
import com.example.demo.services.CiudadesService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CiudadesServiceImpl implements CiudadesService {

    private final CiudadesRepository ciudadesRepository;

    @Override
    public List<Ciudades> getAllCiudades() {
        return ciudadesRepository.findByAll();
    }

    @Override
    public Optional<Ciudades> getCiudadById(Integer id) {
        return ciudadesRepository.findById(id);
    }

    @Override
    public void saveCiudades(Ciudades ciudad) {
        ciudadesRepository.save(ciudad);
    }

    @Override
    public void deleteCiudades(Integer id) {
        ciudadesRepository.findById(id).ifPresent(ciudad -> ciudadesRepository.delete(ciudad));
    }
}