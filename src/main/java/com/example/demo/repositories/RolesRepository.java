package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Roles;

@Repository
public interface RolesRepository extends CrudRepository<Roles, Long> {

	@Query("SELECT u from Roles u")
	List<Roles> findByAll();
}
