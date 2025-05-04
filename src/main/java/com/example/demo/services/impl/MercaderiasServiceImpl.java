package com.example.demo.services.impl;

import com.example.demo.models.Mercaderias;
import com.example.demo.repositories.MercaderiasRepository;
import com.example.demo.services.MercaderiasService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MercaderiasServiceImpl implements MercaderiasService {

    private final MercaderiasRepository mercaderiasRepository;

    @Override
    public List<Mercaderias> getAllMercaderias() {
        return mercaderiasRepository.findByAll();
    }

    @Override
    public Optional<Mercaderias> getMercaderiaById(Integer id) {
        return mercaderiasRepository.findById(id);
    }

    @Override
    public void saveMercaderia(Mercaderias mercaderia) {
        mercaderiasRepository.save(mercaderia);
    }

    @Override
    public void deleteMercaderia(Integer id) {
        mercaderiasRepository.findById(id).ifPresent(mercaderia -> mercaderiasRepository.delete(mercaderia));
    }
}