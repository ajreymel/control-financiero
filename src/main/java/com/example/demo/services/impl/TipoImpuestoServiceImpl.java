package com.example.demo.services.impl;

import com.example.demo.models.TipoImpuesto;
import com.example.demo.repositories.TipoImpuestoRepository;
import com.example.demo.services.TipoImpuestoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TipoImpuestoServiceImpl implements TipoImpuestoService {

    private final TipoImpuestoRepository tipoImpuestoRepository;

    @Override
    public List<TipoImpuesto> getAllTipoImpuestos() {
        return tipoImpuestoRepository.findByAll();
    }

    @Override
    public Optional<TipoImpuesto> getTipoImpuestoById(Integer id) {
        return tipoImpuestoRepository.findById(id);
    }

    @Override
    public void saveTipoImpuesto(TipoImpuesto tipoImpuesto) {
        tipoImpuestoRepository.save(tipoImpuesto);
    }

    @Override
    public void deleteTipoImpuesto(Integer id) {
        tipoImpuestoRepository.findById(id).ifPresent(tipoImpuesto -> tipoImpuestoRepository.delete(tipoImpuesto));
    }
}