package com.example.demo.services.impl;

import com.example.demo.models.Ciudades;
import com.example.demo.repositories.CiudadesRepository;
import com.example.demo.services.CiudadesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CiudadesServiceImpl implements CiudadesService {

    private final CiudadesRepository ciudadesRepository;

    @Override
    public List<Ciudades> getAllCiudades() {
        return ciudadesRepository.findAllCiudades();
    }

    @Override
    public Optional<Ciudades> getCiudadById(Integer id) {
        return ciudadesRepository.findById(id);
    }

    @Override
    public void saveCiudad(Ciudades ciudad) {
        ciudadesRepository.save(ciudad);
    }

    @Override
    public void deleteCiudad(Integer id) {
        ciudadesRepository.findById(id).ifPresent(ciudadesRepository::delete);
    }
}