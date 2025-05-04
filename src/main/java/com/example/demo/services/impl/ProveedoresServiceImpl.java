package com.example.demo.services.impl;

import com.example.demo.models.Proveedores;
import com.example.demo.repositories.ProveedoresRepository;
import com.example.demo.services.ProveedoresService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProveedoresServiceImpl implements ProveedoresService {

    private final ProveedoresRepository proveedoresRepository;

    @Override
    public List<Proveedores> getAllProveedores() {
        return proveedoresRepository.findByAll();
    }

    @Override
    public Optional<Proveedores> getProveedorById(Integer id) {
        return proveedoresRepository.findById(id);
    }

    @Override
    public void saveProveedor(Proveedores proveedor) {
        proveedoresRepository.save(proveedor);
    }

    @Override
    public void deleteProveedor(Integer id) {
        proveedoresRepository.findById(id).ifPresent(proveedor -> proveedoresRepository.delete(proveedor));
    }
}