package com.example.demo.services.impl;

import com.example.demo.models.PedidoCompras;
import com.example.demo.repositories.PedidoComprasRepository;
import com.example.demo.services.PedidoComprasService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PedidoComprasServiceImpl implements PedidoComprasService {

    private final PedidoComprasRepository pedidoComprasRepository;

    @Override
    public List<PedidoCompras> getAllPedidos() {
        return pedidoComprasRepository.findByAll();
    }

    @Override
    public Optional<PedidoCompras> getPedidoById(Integer id) {
        return pedidoComprasRepository.findById(id);
    }

    @Override
    public void savePedido(PedidoCompras pedido) {
        pedidoComprasRepository.save(pedido);
    }

    @Override
    public void deletePedido(Integer id) {
        pedidoComprasRepository.findById(id).ifPresent(pedido -> pedidoComprasRepository.delete(pedido));
    }
}