package br.ifba.inf011.aval2.model.Memento.copy;

import java.sql.Date;
import java.time.LocalDate;

public class ArquivoMemento implements NarrowMemento, WideMemento {

	private final String nome;
	private final LocalDate data; 
	private final String conteudo; 
	
	public ArquivoMemento(String nome, LocalDate data, String conteudo) {
		this.nome = nome;
		this.data = data;
		this.conteudo = conteudo; 
	}
	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}

	@Override
	public LocalDate getData() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public String getConteudo() {
		return conteudo;
	}

}
