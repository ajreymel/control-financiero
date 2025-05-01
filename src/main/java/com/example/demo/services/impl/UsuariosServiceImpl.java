package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.models.Usuarios;
import com.example.demo.repositories.UsuariosRepository;
import com.example.demo.services.UsuariosService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuariosServiceImpl implements UserDetailsService, UsuariosService {

	private final UsuariosRepository usuariosRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuarios usuario = this.usuariosRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException(String.format("Unknown User with username [%s]", username)));

		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol().getAlias());

		return User.withUsername(usuario.getUsername()).password(usuario.getContrasena())
				.authorities(List.of(authority)).accountExpired(false).accountLocked(false).credentialsExpired(false)
				.disabled(!usuario.isEstado()).build();
	}

	@Override
	public List<Usuarios> getAllUsuarios() {
		return this.usuariosRepository.findByAll();
	}

	@Override
	public Optional<Usuarios> getUsuarioById(Long id) {
		return this.usuariosRepository.findById(id);
	}

	@Override
	public void saveUsuarios(Usuarios usuario) {
		this.usuariosRepository.save(usuario);
	}

	@Override
	public void deleteUsuarios(Long id) {
		this.usuariosRepository.findById(id).ifPresent(usuario -> this.usuariosRepository.delete(usuario));

	}

}
