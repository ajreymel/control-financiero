package com.example.demo.repositories;

import com.example.demo.models.EstadoCivil;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoCivilRepository extends CrudRepository<EstadoCivil, Integer> {

    @Query("SELECT e FROM EstadoCivil e")
    List<EstadoCivil> findByAll();
}