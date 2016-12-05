package br.com.abevieiramota.servlet.model;

public class Empresa {

	private long id;
	private String nome;

	public Empresa(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public long getId() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}

}
