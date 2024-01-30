package com.registro.usuarios.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registro.usuarios.dto.UsuarioRegistroDto;
import com.registro.usuarios.servicio.UsuarioServiceImpl;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {
	private UsuarioServiceImpl usuarioservice;

	public RegistroUsuarioControlador(UsuarioServiceImpl usuarioservice) {
		super();
		this.usuarioservice = usuarioservice;
	}

	@ModelAttribute("usuario")
	public UsuarioRegistroDto retornarNuevoUsuarioRegistroDto() {
		return new UsuarioRegistroDto();

	}

	@GetMapping
	public String mostarFormularioDeRegistro() {
		return "registro";
	}

	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDto registrodto) {
		usuarioservice.guardar(registrodto);
		return "redirect:/registro?exito";

	}
}
