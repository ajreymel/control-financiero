package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Barrios;
import com.example.demo.models.Ciudades;
import com.example.demo.services.BarriosService;
import com.example.demo.services.impl.CiudadesServiceImpl;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(value = "/barrios")
@AllArgsConstructor
public class BarriosController {

    private final BarriosService barriosService;
    private final CiudadesServiceImpl ciudadesServiceImpl;

    @GetMapping
    public String listarBarrios(Model model) {
        model.addAttribute("barrios", barriosService.getAllBarrios());
        return "barrios/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        List<Ciudades> ciudades = ciudadesServiceImpl.getAllCiudades();
        model.addAttribute("barrio", new Barrios());
        model.addAttribute("listadoCiudades", ciudades);
        return "barrios/formulario";
    }

    @PostMapping("/guardar")
    public String guardarBarrio(@ModelAttribute Barrios barrio) {
        barriosService.saveBarrio(barrio);
        return "redirect:/barrios";
    }

    @GetMapping("/editar/{id}")
    public String editarBarrio(@PathVariable Integer id, Model model) {
        Optional<Barrios> barrio = barriosService.getBarrioById(id);
        if (barrio.isPresent()) {
            List<Ciudades> ciudades = ciudadesServiceImpl.getAllCiudades();
            model.addAttribute("barrio", barrio.get());
            model.addAttribute("listadoCiudades", ciudades);
            return "barrios/formulario";
        }
        return "redirect:/barrios";
    }

    @PostMapping("/eliminar")
    public String eliminarBarrio(@RequestParam Integer id) {
        barriosService.deleteBarrio(id);
        return "redirect:/barrios";
    }
}