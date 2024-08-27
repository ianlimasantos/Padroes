package br.ifba.inf011.aval2.model.Memento;

import java.time.LocalDate;

import br.ifba.inf011.aval2.model.Arquivo;
import br.ifba.inf011.aval2.model.EntradaOperavel;
import br.ifba.inf011.aval2.model.Stratagy.ConversorStrategy;

//Originator
public class ArquivoHistorico extends Arquivo implements EntradaOperavel{
	
	
	public ArquivoHistorico(String nome, LocalDate dataCriacao, String conteudo) {
		super(nome, dataCriacao, conteudo);
	}
	
	public NarrowMemento snapshot() throws IllegalAccessException{
		return new Snapshot(this.getNome(), this.getDataCriacao(), this.getConteudo());
	}
	
	
	public Boolean back(NarrowMemento snapshot) throws IllegalAccessException{
		WideMemento snap = (WideMemento) snapshot;
		try {
			this.state.setConteudo(snap.getconteudo());
			return true;
		} catch (Exception e) {
			return false; 
		}
		
	}
	
	
}
