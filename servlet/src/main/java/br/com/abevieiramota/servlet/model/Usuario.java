package br.com.abevieiramota.servlet.model;

public class Usuario {

	private long id;
	private String senha;
	private String email;

	public Usuario(long andIncrement, String email, String senha) {
		this.id = andIncrement;
		this.email = email;
		this.senha = senha;
	}

	public Long getId() {
		return this.id;
	}

	public String getEmail() {
		return this.email;
	}

	public String getSenha() {
		return this.senha;
	}

}
