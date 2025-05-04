package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Barrios;

public interface BarriosService {
    List<Barrios> getAllBarrios();
    Optional<Barrios> getBarrioById(Integer id);
    void saveBarrio(Barrios barrio);
    void deleteBarrio(Integer id);
}