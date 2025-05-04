package com.example.demo.controllers;

import com.example.demo.models.Mercaderias;
import com.example.demo.models.Marcas;
import com.example.demo.models.TipoImpuesto;
import com.example.demo.services.MercaderiasService;
import com.example.demo.services.impl.MarcasServiceImpl;
import com.example.demo.services.impl.TipoImpuestoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/mercaderias")
@AllArgsConstructor
public class MercaderiasController {

    private final MercaderiasService mercaderiasService;
    private final MarcasServiceImpl marcasServiceImpl;
    private final TipoImpuestoServiceImpl tipoImpuestoServiceImpl;

    @GetMapping
    public String listarMercaderias(Model model) {
        model.addAttribute("mercaderias", mercaderiasService.getAllMercaderias());
        return "mercaderias/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        List<Marcas> marcas = marcasServiceImpl.getAllMarcas();
        List<TipoImpuesto> tiposImpuesto = tipoImpuestoServiceImpl.getAllTipoImpuestos();
        model.addAttribute("mercaderia", new Mercaderias());
        model.addAttribute("listadoMarcas", marcas);
        model.addAttribute("listadoTiposImpuesto", tiposImpuesto);
        return "mercaderias/formulario";
    }

    @PostMapping("/guardar")
    public String guardarMercaderia(@ModelAttribute Mercaderias mercaderia) {
        mercaderiasService.saveMercaderia(mercaderia);
        return "redirect:/mercaderias";
    }

    @GetMapping("/editar/{id}")
    public String editarMercaderia(@PathVariable Integer id, Model model) {
        Optional<Mercaderias> mercaderia = mercaderiasService.getMercaderiaById(id);
        if (mercaderia.isPresent()) {
            List<Marcas> marcas = marcasServiceImpl.getAllMarcas();
            List<TipoImpuesto> tiposImpuesto = tipoImpuestoServiceImpl.getAllTipoImpuestos();
            model.addAttribute("mercaderia", mercaderia.get());
            model.addAttribute("listadoMarcas", marcas);
            model.addAttribute("listadoTiposImpuesto", tiposImpuesto);
            return "mercaderias/formulario";
        }
        return "redirect:/mercaderias";
    }

    @PostMapping("/eliminar")
    public String eliminarMercaderia(@RequestParam Integer id) {
        mercaderiasService.deleteMercaderia(id);
        return "redirect:/mercaderias";
    }
}