package com.example.demo.repositories;

import com.example.demo.models.Ciudades;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CiudadesRepository extends CrudRepository<Ciudades, Integer> {

    Optional<Ciudades> findByDescripcion(String descripcion);

    @Query("SELECT c FROM Ciudades c")
    List<Ciudades> findAllCiudades();
}