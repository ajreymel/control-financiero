/**
 * 
 */
package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Sucursales;

/**
 * 
 */
@Repository
public interface SucursalesRepository extends CrudRepository<Sucursales, Long> {

	@Query("SELECT s from Sucursales s")
	List<Sucursales> findByAll();
}
