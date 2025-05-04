package com.example.demo.services;

import com.example.demo.models.Ciudades;

import java.util.List;
import java.util.Optional;

public interface CiudadesService {
    List<Ciudades> getAllCiudades();
    Optional<Ciudades> getCiudadById(Integer id);
    void saveCiudad(Ciudades ciudad);
    void deleteCiudad(Integer id);
}