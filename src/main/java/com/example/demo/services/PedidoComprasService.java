package com.example.demo.services;

import com.example.demo.models.PedidoCompras;

import java.util.List;
import java.util.Optional;

public interface PedidoComprasService {
    List<PedidoCompras> getAllPedidos();
    Optional<PedidoCompras> getPedidoById(Integer id);
    void savePedido(PedidoCompras pedido);
    void deletePedido(Integer id);
}