package com.example.demo.services;

import com.example.demo.models.Paises;

import java.util.List;
import java.util.Optional;

public interface PaisesService {
    List<Paises> getAllPaises();
    Optional<Paises> getPaisesById(Integer id);
    Paises savePaises(Paises pais);
    void deletePaises(Integer id);
}