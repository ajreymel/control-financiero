package com.example.demo.services.impl;

import com.example.demo.models.Empleados;
import com.example.demo.repositories.EmpleadosRepository;
import com.example.demo.services.EmpleadosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpleadosServiceImpl implements EmpleadosService {

    private final EmpleadosRepository empleadosRepository;

    @Override
    public List<Empleados> getAllEmpleados() {
        return empleadosRepository.findByAll();
    }

    @Override
    public Optional<Empleados> getEmpleadoById(Integer id) {
        return empleadosRepository.findById(id);
    }

    @Override
    public void saveEmpleado(Empleados empleado) {
        empleadosRepository.save(empleado);
    }

    @Override
    public void deleteEmpleado(Integer id) {
        empleadosRepository.findById(id).ifPresent(empleado -> empleadosRepository.delete(empleado));
    }
}