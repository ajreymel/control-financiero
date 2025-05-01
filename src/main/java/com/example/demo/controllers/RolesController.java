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

import com.example.demo.models.Roles;
import com.example.demo.services.RolesService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(value = "/roles")
@AllArgsConstructor
public class RolesController {

	private RolesService rolesService;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("roles", rolesService.getAllRoles());
		return "roles/listar";
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		model.addAttribute("rol", new Roles());
		return "roles/formulario";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Roles rol) {
		rolesService.saveRoles(rol);
		return "redirect:/roles";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {

		Optional<Roles> rol = rolesService.getRolById(id);

		if (rol.isPresent()) {
			model.addAttribute("rol", rol.get());
			return "roles/formulario";
		}

		return "redirect:/roles";
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam Long id) {
		rolesService.deleteRol(id);
		return "redirect:/roles";
	}
}
