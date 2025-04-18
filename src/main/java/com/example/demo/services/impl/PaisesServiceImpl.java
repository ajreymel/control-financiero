package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Paises;
import com.example.demo.repositories.PaisesRepository;
import com.example.demo.services.PaisesService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaisesServiceImpl implements PaisesService {

    private final PaisesRepository paisesRepository;

    @Override
    public List<Paises> getAllPaises() {
        return paisesRepository.findByAll();
    }

    @Override
    public Optional<Paises> getPaisById(Integer id) {
        return paisesRepository.findById(id);
    }

    @Override
    public void savePaises(Paises pais) {
        paisesRepository.save(pais);
    }

    @Override
    public void deletePaises(Integer id) {
        paisesRepository.findById(id).ifPresent(pais -> paisesRepository.delete(pais));
    }
}