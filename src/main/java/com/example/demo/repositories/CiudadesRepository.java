package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Ciudades;

@Repository
public interface CiudadesRepository extends CrudRepository<Ciudades, Integer> {

    Optional<Ciudades> findByDescripcion(String descripcion);

    @Query("SELECT c FROM Ciudades c")
    List<Ciudades> findByAll();
}