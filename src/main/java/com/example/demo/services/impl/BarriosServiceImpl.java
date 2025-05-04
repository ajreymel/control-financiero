package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Barrios;
import com.example.demo.repositories.BarriosRepository;
import com.example.demo.services.BarriosService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BarriosServiceImpl implements BarriosService {

    private final BarriosRepository barriosRepository;

    @Override
    public List<Barrios> getAllBarrios() {
        return barriosRepository.findByAll();
    }

    @Override
    public Optional<Barrios> getBarrioById(Integer id) {
        return barriosRepository.findById(id);
    }

    @Override
    public void saveBarrio(Barrios barrio) {
        barriosRepository.save(barrio);
    }

    @Override
    public void deleteBarrio(Integer id) {
        barriosRepository.findById(id).ifPresent(barrio -> barriosRepository.delete(barrio));
    }
}