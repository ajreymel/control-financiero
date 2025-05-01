package com.example.demo.services.impl;

import com.example.demo.models.Departamentos;
import com.example.demo.repositories.DepartamentosRepository;
import com.example.demo.services.DepartamentosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartamentosServiceImpl implements DepartamentosService {

    private final DepartamentosRepository departamentosRepository;

    @Override
    public List<Departamentos> getAllDepartamentos() {
        return departamentosRepository.findAllDepartamentos();
    }

    @Override
    public Optional<Departamentos> getDepartamentoById(Integer id) {
        return departamentosRepository.findById(id);
    }

    @Override
    public void saveDepartamento(Departamentos departamento) {
        departamentosRepository.save(departamento);
    }

    @Override
    public void deleteDepartamento(Integer id) {
        departamentosRepository.findById(id).ifPresent(departamentosRepository::delete);
    }
}