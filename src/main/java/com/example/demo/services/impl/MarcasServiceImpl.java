package com.example.demo.services.impl;

import com.example.demo.models.Marcas;
import com.example.demo.repositories.MarcasRepository;
import com.example.demo.services.MarcasService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MarcasServiceImpl implements MarcasService {

    private final MarcasRepository marcasRepository;

    @Override
    public List<Marcas> getAllMarcas() {
        return marcasRepository.findByAll();
    }

    @Override
    public Optional<Marcas> getMarcaById(Integer id) {
        return marcasRepository.findById(id);
    }

    @Override
    public void saveMarca(Marcas marca) {
        marcasRepository.save(marca);
    }

    @Override
    public void deleteMarca(Integer id) {
        marcasRepository.findById(id).ifPresent(marca -> marcasRepository.delete(marca));
    }
}