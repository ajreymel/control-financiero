package com.example.demo.services;

import com.example.demo.models.Marcas;

import java.util.List;
import java.util.Optional;

public interface MarcasService {
    List<Marcas> getAllMarcas();
    Optional<Marcas> getMarcaById(Integer id);
    void saveMarca(Marcas marca);
    void deleteMarca(Integer id);
}