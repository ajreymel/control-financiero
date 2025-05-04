package com.example.demo.repositories;

import com.example.demo.models.Paises;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaisesRepository extends CrudRepository<Paises, Integer> {

    Optional<Paises> findByDescripcion(String descripcion);

    @Query("SELECT p FROM Paises p")
    List<Paises> findAllPaises();
}
