package com.example.demo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Barrios;

@Repository
public interface BarriosRepository extends CrudRepository<Barrios, Integer> {

    @Query("SELECT b FROM Barrios b")
    List<Barrios> findByAll();
}