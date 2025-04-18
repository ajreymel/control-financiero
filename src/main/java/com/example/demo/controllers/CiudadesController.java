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

import com.example.demo.models.Ciudades;
import com.example.demo.models.Departamentos;
import com.example.demo.services.CiudadesService;
import com.example.demo.services.impl.DepartamentosServiceImpl;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(value = "/ciudades")
@AllArgsConstructor
public class CiudadesController {

    private final CiudadesService ciudadesService;
    private final DepartamentosServiceImpl departamentosServiceImpl;

    @GetMapping
    public String listarCiudades(Model model) {
        model.addAttribute("ciudades", ciudadesService.getAllCiudades());
        return "ciudades/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        List<Departamentos> departamentos = departamentosServiceImpl.getAllDepartamentos();
        model.addAttribute("ciudad", new Ciudades());
        model.addAttribute("listadoDepartamentos", departamentos);
        return "ciudades/formulario";
    }

    @PostMapping("/guardar")
    public String guardarCiudad(@ModelAttribute Ciudades ciudad) {
        ciudadesService.saveCiudades(ciudad);
        return "redirect:/ciudades";
    }

    @GetMapping("/editar/{id}")
    public String editarCiudad(@PathVariable Integer id, Model model) {
        Optional<Ciudades> ciudad = ciudadesService.getCiudadById(id);
        if (ciudad.isPresent()) {
            List<Departamentos> departamentos = departamentosServiceImpl.getAllDepartamentos();
            model.addAttribute("ciudad", ciudad.get());
            model.addAttribute("listadoDepartamentos", departamentos);
            return "ciudades/formulario";
        }
        return "redirect:/ciudades";
    }

    @PostMapping("/eliminar")
    public String eliminarCiudad(@RequestParam Integer id) {
        ciudadesService.deleteCiudades(id);
        return "redirect:/ciudades";
    }
}