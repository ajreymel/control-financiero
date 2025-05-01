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

import com.example.demo.models.Roles;
import com.example.demo.models.Usuarios;
import com.example.demo.services.UsuariosService;
import com.example.demo.services.impl.RolesServiceImpl;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(value = "/usuarios")
@AllArgsConstructor
public class UsuariosController {

	private UsuariosService usuariosService;
	private RolesServiceImpl rolesServiceImpl;

	@GetMapping
	public String listarUsuarios(Model model) {
		model.addAttribute("usuarios", usuariosService.getAllUsuarios());
		return "usuarios/listar";
	}

	@GetMapping("/form")
	public String mostrarFormulario(Model model) {
		List<Roles> roles = rolesServiceImpl.getAllRoles();
		model.addAttribute("usuario", new Usuarios());
		model.addAttribute("listadoRoles", roles);

		return "usuarios/formulario";
	}

	@PostMapping("/guardar")
	public String guardarUsuario(@ModelAttribute Usuarios usuario) {
		usuariosService.saveUsuarios(usuario);
		return "redirect:/usuarios";
	}

	@GetMapping("/editar/{id}")
	public String editarUsuario(@PathVariable Long id, Model model) {

		Optional<Usuarios> usuario = usuariosService.getUsuarioById(id);

		if (usuario.isPresent()) {
			List<Roles> roles = rolesServiceImpl.getAllRoles();
			model.addAttribute("usuario", usuario.get());
			model.addAttribute("listadoRoles", roles);
			return "usuarios/formulario";
		}

		return "redirect:/usuarios";
	}

	@PostMapping("/eliminar")
	public String eliminarUsuario(@RequestParam Long id) {
		usuariosService.deleteUsuarios(id);
		return "redirect:/usuarios";
	}
}
