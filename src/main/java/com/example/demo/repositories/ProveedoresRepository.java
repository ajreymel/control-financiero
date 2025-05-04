package com.example.demo.repositories;

import com.example.demo.models.Proveedores;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedoresRepository extends CrudRepository<Proveedores, Integer> {

    @Query("SELECT p FROM Proveedores p")
    List<Proveedores> findByAll();
}