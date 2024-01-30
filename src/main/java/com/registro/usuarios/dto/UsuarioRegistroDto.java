package com.registro.usuarios.dto;

public class UsuarioRegistroDto {
	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsuarioRegistroDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioRegistroDto(String nombre, String apellido, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
	}

	public UsuarioRegistroDto(String email) {
		super();
		this.email = email;
	}

}
