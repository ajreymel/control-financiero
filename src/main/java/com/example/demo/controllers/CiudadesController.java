package com.example.demo.controllers;

import com.example.demo.models.Ciudades;
import com.example.demo.models.Departamentos;
import com.example.demo.services.CiudadesService;
import com.example.demo.services.impl.DepartamentosServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/ciudades")
@AllArgsConstructor
public class CiudadesController {

    private CiudadesService ciudadesService;
    private DepartamentosServiceImpl departamentosServiceImpl;

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
        ciudadesService.saveCiudad(ciudad);
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
        ciudadesService.deleteCiudad(id);
        return "redirect:/ciudades";
    }
}