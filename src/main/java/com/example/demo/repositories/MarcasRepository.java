package com.example.demo.repositories;

import com.example.demo.models.Marcas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcasRepository extends CrudRepository<Marcas, Integer> {

    @Query("SELECT m FROM Marcas m")
    List<Marcas> findByAll();
}