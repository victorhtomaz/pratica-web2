package br.pratica.models;

public class Fruta {
	private final int id;
	private String nome;
	
	public Fruta(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return this.id;
	}
	public String getNome() {
		return this.nome;
	}
}
