package com.example.demo.controllers;

import com.example.demo.models.Departamentos;
import com.example.demo.models.Paises;
import com.example.demo.services.DepartamentosService;
import com.example.demo.services.impl.PaisesServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/departamentos")
@AllArgsConstructor
public class DepartamentosController {

    private DepartamentosService departamentosService;
    private PaisesServiceImpl paisesServiceImpl;

    @GetMapping
    public String listarDepartamentos(Model model) {
        model.addAttribute("departamentos", departamentosService.getAllDepartamentos());
        return "departamentos/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        List<Paises> paises = paisesServiceImpl.getAllPaises();
        model.addAttribute("departamento", new Departamentos());
        model.addAttribute("listadoPaises", paises);
        return "departamentos/formulario";
    }

    @PostMapping("/guardar")
    public String guardarDepartamento(@ModelAttribute Departamentos departamento) {
        departamentosService.saveDepartamento(departamento);
        return "redirect:/departamentos";
    }

    @GetMapping("/editar/{id}")
    public String editarDepartamento(@PathVariable Integer id, Model model) {
        Optional<Departamentos> departamento = departamentosService.getDepartamentoById(id);
        if (departamento.isPresent()) {
            List<Paises> paises = paisesServiceImpl.getAllPaises();
            model.addAttribute("departamento", departamento.get());
            model.addAttribute("listadoPaises", paises);
            return "departamentos/formulario";
        }
        return "redirect:/departamentos";
    }

    @PostMapping("/eliminar")
    public String eliminarDepartamento(@RequestParam Integer id) {
        departamentosService.deleteDepartamento(id);
        return "redirect:/departamentos";
    }
}
