package com.example.demo.repositories;

import com.example.demo.models.Condicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicionRepository extends JpaRepository<Condicion, Integer> {
}
