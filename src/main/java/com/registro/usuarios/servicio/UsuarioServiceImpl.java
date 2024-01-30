package com.registro.usuarios.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.registro.usuarios.dto.UsuarioRegistroDto;
import com.registro.usuarios.repositorio.UsuarioRepositorio;

import registro.usuarios.modelo.Rol;
import registro.usuarios.modelo.Usuario;

@Service
public abstract class UsuarioServiceImpl implements UsuarioServicio {
	private UsuarioRepositorio usuariorepositorio;

	public UsuarioServiceImpl(UsuarioRepositorio usuariorepositorio) {
		super();
		this.usuariorepositorio = usuariorepositorio;
	}

	@Override
	@Bean
	public Usuario guardar(UsuarioRegistroDto registrodto) {
		Usuario usuario = new Usuario(registrodto.getNombre(), registrodto.getApellido(), registrodto.getEmail(),
				(registrodto.getPassword()), Arrays.asList(new Rol("ROLE_USER")));
		return usuariorepositorio.save(usuario);

	}

	public UserDetails loadUserByUserName(String username) throws UsernameNotFoundException {
		Usuario usuario = usuariorepositorio.findByEmail(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("usuario o password");
		}
		return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());

	}

}
