package com.example.demo.repositories;

import com.example.demo.models.Nacionalidades;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NacionalidadesRepository extends CrudRepository<Nacionalidades, Integer> {

    @Query("SELECT n FROM Nacionalidades n")
    List<Nacionalidades> findByAll();
}