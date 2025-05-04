package com.example.demo.controllers;

import com.example.demo.models.PedidoCompras;
import com.example.demo.models.Proveedores;
import com.example.demo.models.Sucursales;
import com.example.demo.models.Empleados;
import com.example.demo.models.Condicion;
import com.example.demo.services.PedidoComprasService;
import com.example.demo.services.impl.ProveedoresServiceImpl;
import com.example.demo.services.impl.SucursalesServiceImpl;
import com.example.demo.services.impl.EmpleadosServiceImpl;
import com.example.demo.services.impl.CondicionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/pedido-compras")
@AllArgsConstructor
public class PedidoComprasController {

    private final PedidoComprasService pedidoComprasService;
    private final ProveedoresServiceImpl proveedoresServiceImpl;
    private final SucursalesServiceImpl sucursalesServiceImpl;
    private final EmpleadosServiceImpl empleadosServiceImpl;
    private final CondicionServiceImpl condicionServiceImpl;

    @GetMapping
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedidoComprasService.getAllPedidos());
        return "pedido-compras/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        List<Proveedores> proveedores = proveedoresServiceImpl.getAllProveedores();
        List<Sucursales> sucursales = sucursalesServiceImpl.getAlls();
        List<Empleados> empleados = empleadosServiceImpl.getAllEmpleados();
        List<Condicion> condiciones = condicionServiceImpl.getAllCondiciones();
        model.addAttribute("pedido", new PedidoCompras());
        model.addAttribute("listadoProveedores", proveedores);
        model.addAttribute("listadoSucursales", sucursales);
        model.addAttribute("listadoEmpleados", empleados);
        model.addAttribute("listadoCondiciones", condiciones);
        return "pedido-compras/formulario";
    }

    @PostMapping("/guardar")
    public String guardarPedido(@ModelAttribute PedidoCompras pedido) {
        pedidoComprasService.savePedido(pedido);
        return "redirect:/pedido-compras";
    }

    @GetMapping("/editar/{id}")
    public String editarPedido(@PathVariable Integer id, Model model) {
        Optional<PedidoCompras> pedido = pedidoComprasService.getPedidoById(id);
        if (pedido.isPresent()) {
            List<Proveedores> proveedores = proveedoresServiceImpl.getAllProveedores();
            List<Sucursales> sucursales = sucursalesServiceImpl.getAlls();
            List<Empleados> empleados = empleadosServiceImpl.getAllEmpleados();
            List<Condicion> condiciones = condicionServiceImpl.getAllCondiciones();
            model.addAttribute("pedido", pedido.get());
            model.addAttribute("listadoProveedores", proveedores);
            model.addAttribute("listadoSucursales", sucursales);
            model.addAttribute("listadoEmpleados", empleados);
            model.addAttribute("listadoCondiciones", condiciones);
            return "pedido-compras/formulario";
        }
        return "redirect:/pedido-compras";
    }

    @PostMapping("/eliminar")
    public String eliminarPedido(@RequestParam Integer id) {
        pedidoComprasService.deletePedido(id);
        return "redirect:/pedido-compras";
    }
}