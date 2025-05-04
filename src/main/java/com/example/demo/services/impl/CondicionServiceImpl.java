package com.example.demo.services.impl;

import com.example.demo.models.Condicion;
import com.example.demo.repositories.CondicionRepository;
import com.example.demo.services.CondicionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CondicionServiceImpl implements CondicionService {

    private final CondicionRepository condicionRepository;

    @Override
    public List<Condicion> getAllCondiciones() {
        return condicionRepository.findAll();
    }

    @Override
    public Optional<Condicion> getCondicionById(Integer id) {
        return condicionRepository.findById(id);
    }

    @Override
    public void saveCondicion(Condicion condicion) {
        condicionRepository.save(condicion);
    }

    @Override
    public void deleteCondicion(Integer id) {
        condicionRepository.findById(id).ifPresent(condicion -> condicionRepository.delete(condicion));
    }
}