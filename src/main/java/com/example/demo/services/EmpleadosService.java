package com.example.demo.services;

import com.example.demo.models.Empleados;

import java.util.List;
import java.util.Optional;

public interface EmpleadosService {
    List<Empleados> getAllEmpleados();
    Optional<Empleados> getEmpleadoById(Integer id);
    void saveEmpleado(Empleados empleado);
    void deleteEmpleado(Integer id);
}