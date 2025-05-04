package com.example.demo.controllers;

import com.example.demo.models.Barrios;
import com.example.demo.models.Proveedores;
import com.example.demo.services.ProveedoresService;
import com.example.demo.services.impl.BarriosServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/proveedores")
@AllArgsConstructor
public class ProveedoresController {

    private final ProveedoresService proveedoresService;
    private final BarriosServiceImpl barriosServiceImpl;

    @GetMapping
    public String listarProveedores(Model model) {
        model.addAttribute("proveedores", proveedoresService.getAllProveedores());
        return "proveedores/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        List<Barrios> barrios = barriosServiceImpl.getAllBarrios();
        model.addAttribute("proveedor", new Proveedores());
        model.addAttribute("listadoBarrios", barrios);
        return "proveedores/formulario";
    }

    @PostMapping("/guardar")
    public String guardarProveedor(@ModelAttribute Proveedores proveedor) {
        proveedoresService.saveProveedor(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/editar/{id}")
    public String editarProveedor(@PathVariable Integer id, Model model) {
        Optional<Proveedores> proveedor = proveedoresService.getProveedorById(id);
        if (proveedor.isPresent()) {
            List<Barrios> barrios = barriosServiceImpl.getAllBarrios();
            model.addAttribute("proveedor", proveedor.get());
            model.addAttribute("listadoBarrios", barrios);
            return "proveedores/formulario";
        }
        return "redirect:/proveedores";
    }

    @PostMapping("/eliminar")
    public String eliminarProveedor(@RequestParam Integer id) {
        proveedoresService.deleteProveedor(id);
        return "redirect:/proveedores";
    }
}