package com.example.demo.services.impl;

import com.example.demo.models.EstadoCivil;
import com.example.demo.repositories.EstadoCivilRepository;
import com.example.demo.services.EstadoCivilService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstadoCivilServiceImpl implements EstadoCivilService {

    private final EstadoCivilRepository estadoCivilRepository;

    @Override
    public List<EstadoCivil> getAllEstadoCivil() {
        return estadoCivilRepository.findByAll();
    }
}