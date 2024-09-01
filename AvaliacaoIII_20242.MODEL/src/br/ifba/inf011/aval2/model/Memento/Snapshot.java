package br.ifba.inf011.aval2.model.Memento;

//MEMENTO EM MEMENTO

import java.time.LocalDate;

public class Snapshot implements WideMemento, NarrowMemento{
	
	private String nome;
	private LocalDate dataCriacao;
	private String conteudo; 
	
	public Snapshot(String conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	public String getconteudo() {
		return conteudo;
	}
	
	public String toString() {
	    return "Snapshot [Conteudo = " + this.conteudo + "]" ;
	}



}