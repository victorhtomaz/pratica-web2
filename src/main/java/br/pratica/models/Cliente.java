package br.pratica.models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome;
	private final List<Fruta> frutasFavoritas;
	
	public Cliente(String nome) {
		this.nome = nome;
		this.frutasFavoritas = new ArrayList<Fruta>();
	}
	
	public String getNome() {
		return this.nome;
	}
	public void adicionaFruta(Fruta fruta) {
		frutasFavoritas.add(fruta);
	}
	public List<Fruta> getFrutasFavoritas() {
		return frutasFavoritas;
	}
}
