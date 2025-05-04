package com.example.demo.services;

import com.example.demo.models.TipoImpuesto;

import java.util.List;
import java.util.Optional;

public interface TipoImpuestoService {
    List<TipoImpuesto> getAllTipoImpuestos();
    Optional<TipoImpuesto> getTipoImpuestoById(Integer id);
    void saveTipoImpuesto(TipoImpuesto tipoImpuesto);
    void deleteTipoImpuesto(Integer id);
}