package br.ifba.inf011.aval2.model.Memento;

//MEMENTO EM MEMENTO

import java.time.LocalDate;

public class Snapshot implements WideMemento, NarrowMemento{
	
	private String nome;
	private LocalDate dataCriacao;
	private String conteudo; 
	
	public Snapshot(String nome, LocalDate dataCriacao, String conteudo) {
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.conteudo = conteudo;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	@Override
	public String getconteudo() {
		return conteudo;
	}
	
	public String toString() {
	    return "Snapshot [Nome = " + this.nome + ", Data = " + this.dataCriacao + " Conteudo = " + this.conteudo + "]";
	}



}