package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Paises;

@Repository
public interface PaisesRepository extends CrudRepository<Paises, Integer> {

    Optional<Paises> findByDescripcion(String descripcion);

    @Query("SELECT p FROM Paises p")
    List<Paises> findByAll();
}