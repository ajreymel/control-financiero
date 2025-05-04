package com.example.demo.controllers;

import com.example.demo.models.Marcas;
import com.example.demo.services.MarcasService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/marcas")
@AllArgsConstructor
public class MarcasController {

    private final MarcasService marcasService;

    @GetMapping
    public String listarMarcas(Model model) {
        model.addAttribute("marcas", marcasService.getAllMarcas());
        return "marcas/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("marca", new Marcas());
        return "marcas/formulario";
    }

    @PostMapping("/guardar")
    public String guardarMarca(@ModelAttribute Marcas marca) {
        marcasService.saveMarca(marca);
        return "redirect:/marcas";
    }

    @GetMapping("/editar/{id}")
    public String editarMarca(@PathVariable Integer id, Model model) {
        Optional<Marcas> marca = marcasService.getMarcaById(id);
        if (marca.isPresent()) {
            model.addAttribute("marca", marca.get());
            return "marcas/formulario";
        }
        return "redirect:/marcas";
    }

    @PostMapping("/eliminar")
    public String eliminarMarca(@RequestParam Integer id) {
        marcasService.deleteMarca(id);
        return "redirect:/marcas";
    }
}