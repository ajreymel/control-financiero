package com.example.demo.repositories;

import com.example.demo.models.Departamentos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentosRepository extends CrudRepository<Departamentos, Integer> {

    @Query("SELECT d FROM Departamentos d")
    List<Departamentos> findAllDepartamentos();
}