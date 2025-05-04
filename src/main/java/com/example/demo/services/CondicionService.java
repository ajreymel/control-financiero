package com.example.demo.services;

import com.example.demo.models.Condicion;

import java.util.List;
import java.util.Optional;

public interface CondicionService {

    List<Condicion> getAllCondiciones();

    Optional<Condicion> getCondicionById(Integer id);

    void saveCondicion(Condicion condicion);

    void deleteCondicion(Integer id);
}