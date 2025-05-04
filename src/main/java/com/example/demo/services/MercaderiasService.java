package com.example.demo.services;

import com.example.demo.models.Mercaderias;

import java.util.List;
import java.util.Optional;

public interface MercaderiasService {
    List<Mercaderias> getAllMercaderias();
    Optional<Mercaderias> getMercaderiaById(Integer id);
    void saveMercaderia(Mercaderias mercaderia);
    void deleteMercaderia(Integer id);
}