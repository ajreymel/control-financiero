package com.example.demo.repositories;

import com.example.demo.models.TipoImpuesto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoImpuestoRepository extends CrudRepository<TipoImpuesto, Integer> {

    @Query("SELECT t FROM TipoImpuesto t")
    List<TipoImpuesto> findByAll();
}