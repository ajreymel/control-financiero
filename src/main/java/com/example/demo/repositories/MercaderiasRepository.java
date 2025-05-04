package com.example.demo.repositories;

import com.example.demo.models.Mercaderias;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MercaderiasRepository extends CrudRepository<Mercaderias, Integer> {

    @Query("SELECT m FROM Mercaderias m")
    List<Mercaderias> findByAll();
}