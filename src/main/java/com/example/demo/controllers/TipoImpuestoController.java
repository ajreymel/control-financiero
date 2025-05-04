package com.example.demo.controllers;

import com.example.demo.models.TipoImpuesto;
import com.example.demo.services.TipoImpuestoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/tipoImpuestos")
@AllArgsConstructor
public class TipoImpuestoController {

    private final TipoImpuestoService tipoImpuestoService;

    @GetMapping
    public String listarTipoImpuestos(Model model) {
        model.addAttribute("tipoImpuestos", tipoImpuestoService.getAllTipoImpuestos());
        return "tipoImpuestos/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("tipoImpuesto", new TipoImpuesto());
        return "tipoImpuestos/formulario";
    }

    @PostMapping("/guardar")
    public String guardarTipoImpuesto(@ModelAttribute TipoImpuesto tipoImpuesto) {
        tipoImpuestoService.saveTipoImpuesto(tipoImpuesto);
        return "redirect:/tipoImpuestos";
    }

    @GetMapping("/editar/{id}")
    public String editarTipoImpuesto(@PathVariable Integer id, Model model) {
        Optional<TipoImpuesto> tipoImpuesto = tipoImpuestoService.getTipoImpuestoById(id);
        if (tipoImpuesto.isPresent()) {
            model.addAttribute("tipoImpuesto", tipoImpuesto.get());
            return "tipoImpuestos/formulario";
        }
        return "redirect:/tipoImpuestos";
    }

    @PostMapping("/eliminar")
    public String eliminarTipoImpuesto(@RequestParam Integer id) {
        tipoImpuestoService.deleteTipoImpuesto(id);
        return "redirect:/tipoImpuestos";
    }
}