package com.example.demo.services;

import com.example.demo.models.Departamentos;

import java.util.List;
import java.util.Optional;

public interface DepartamentosService {
    List<Departamentos> getAllDepartamentos();
    Optional<Departamentos> getDepartamentoById(Integer id);
    void saveDepartamento(Departamentos departamento);
    void deleteDepartamento(Integer id);
}
