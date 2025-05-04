package com.example.demo.services;

import com.example.demo.models.Proveedores;

import java.util.List;
import java.util.Optional;

public interface ProveedoresService {
    List<Proveedores> getAllProveedores();
    Optional<Proveedores> getProveedorById(Integer id);
    void saveProveedor(Proveedores proveedor);
    void deleteProveedor(Integer id);
}