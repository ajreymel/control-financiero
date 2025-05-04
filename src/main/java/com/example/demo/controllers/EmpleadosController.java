package com.example.demo.controllers;

import com.example.demo.models.*;
import com.example.demo.services.EmpleadosService;
import com.example.demo.services.impl.BarriosServiceImpl;
import com.example.demo.services.impl.EstadoCivilServiceImpl;
import com.example.demo.services.impl.NacionalidadesServiceImpl;
import com.example.demo.services.impl.UsuariosServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/empleados")
@AllArgsConstructor
public class EmpleadosController {

    private final EmpleadosService empleadosService;
    private final BarriosServiceImpl barriosServiceImpl;
    private final NacionalidadesServiceImpl nacionalidadesServiceImpl;
    private final UsuariosServiceImpl usuariosServiceImpl;
    private final EstadoCivilServiceImpl estadoCivilServiceImpl;

    @GetMapping
    public String listarEmpleados(Model model) {
        model.addAttribute("empleados", empleadosService.getAllEmpleados());
        return "empleados/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        List<Barrios> barrios = barriosServiceImpl.getAllBarrios();
        List<Nacionalidades> nacionalidades = nacionalidadesServiceImpl.getAllNacionalidades();
        List<Usuarios> usuarios = usuariosServiceImpl.getAllUsuarios();
        List<EstadoCivil> estadosCiviles = estadoCivilServiceImpl.getAllEstadoCivil();
        model.addAttribute("empleado", new Empleados());
        model.addAttribute("listadoBarrios", barrios);
        model.addAttribute("listadoNacionalidades", nacionalidades);
        model.addAttribute("listadoUsuarios", usuarios);
        model.addAttribute("listadoEstadosCiviles", estadosCiviles);
        return "empleados/formulario";
    }

    @PostMapping("/guardar")
    public String guardarEmpleado(@ModelAttribute Empleados empleado) {
        empleadosService.saveEmpleado(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/editar/{id}")
    public String editarEmpleado(@PathVariable Integer id, Model model) {
        Optional<Empleados> empleado = empleadosService.getEmpleadoById(id);
        if (empleado.isPresent()) {
            List<Barrios> barrios = barriosServiceImpl.getAllBarrios();
            List<Nacionalidades> nacionalidades = nacionalidadesServiceImpl.getAllNacionalidades();
            List<Usuarios> usuarios = usuariosServiceImpl.getAllUsuarios();
            List<EstadoCivil> estadosCiviles = estadoCivilServiceImpl.getAllEstadoCivil();
            model.addAttribute("empleado", empleado.get());
            model.addAttribute("listadoBarrios", barrios);
            model.addAttribute("listadoNacionalidades", nacionalidades);
            model.addAttribute("listadoUsuarios", usuarios);
            model.addAttribute("listadoEstadosCiviles", estadosCiviles);
            return "empleados/formulario";
        }
        return "redirect:/empleados";
    }

    @PostMapping("/eliminar")
    public String eliminarEmpleado(@RequestParam Integer id) {
        empleadosService.deleteEmpleado(id);
        return "redirect:/empleados";
    }
}