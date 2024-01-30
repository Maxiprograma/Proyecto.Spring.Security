package com.registro.usuarios.servicio;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.registro.usuarios.dto.UsuarioRegistroDto;

import registro.usuarios.modelo.Usuario;

public interface UsuarioServicio extends UserDetailsService {
	public Usuario guardar(UsuarioRegistroDto registrodto);

	UserDetails loadUserByUserName(String username);

}
