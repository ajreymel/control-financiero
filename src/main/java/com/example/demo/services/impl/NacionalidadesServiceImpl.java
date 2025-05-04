package com.example.demo.services.impl;

import com.example.demo.models.Nacionalidades;
import com.example.demo.repositories.NacionalidadesRepository;
import com.example.demo.services.NacionalidadesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NacionalidadesServiceImpl implements NacionalidadesService {

    private final NacionalidadesRepository nacionalidadesRepository;

    @Override
    public List<Nacionalidades> getAllNacionalidades() {
        return nacionalidadesRepository.findByAll();
    }
}