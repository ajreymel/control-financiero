package com.example.demo.repositories;

import com.example.demo.models.PedidoCompras;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoComprasRepository extends CrudRepository<PedidoCompras, Integer> {

    @Query("SELECT p FROM PedidoCompras p")
    List<PedidoCompras> findByAll();
}
