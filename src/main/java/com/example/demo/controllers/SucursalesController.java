package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Sucursales;
import com.example.demo.services.SucursalesService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = { "sucursales" })
@AllArgsConstructor
public class SucursalesController {

	private SucursalesService service;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("sucursales", service.getAlls());
		return "sucursales/listar";
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		model.addAttribute("sucursal", new Sucursales());
		return "sucursales/formulario";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Sucursales sucursal) {
		service.save(sucursal);
		return "redirect:/sucursales";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {

		Optional<Sucursales> sucursal = service.getById(id);

		if (sucursal.isPresent()) {
			model.addAttribute("sucursal", sucursal.get());
			return "sucursales/formulario";
		}

		return "redirect:/sucursales";
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam Long id) {
		service.delete(id);
		return "redirect:/sucursales";
	}
}
