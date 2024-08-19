package br.ifba.inf011.aval2.model.Memento;

import java.lang.invoke.StringConcatFactory;
import java.time.LocalDate;

public class ConcreteMemento implements MementoInterface {
	private String nome;
	private LocalDate data;
	private String conteudo;
	
	public ConcreteMemento(String name, LocalDate date, String conteudo) {
        this.nome = name;
        this.data = date;
        this.conteudo = conteudo; 
    }

	@Override
    public String toString() {
        return this.nome; // Retorna o nome do elemento
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
	
	public String getconteudo() {
		return conteudo; 
	}

}
