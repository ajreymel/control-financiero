package com.example.demo.repositories;

import com.example.demo.models.Empleados;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadosRepository extends CrudRepository<Empleados, Integer> {

    @Query("SELECT e FROM Empleados e")
    List<Empleados> findByAll();
}