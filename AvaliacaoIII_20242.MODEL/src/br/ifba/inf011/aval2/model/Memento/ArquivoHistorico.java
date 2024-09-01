package br.ifba.inf011.aval2.model.Memento;

import java.time.LocalDate;

import br.ifba.inf011.aval2.model.Arquivo;
import br.ifba.inf011.aval2.model.EntradaOperavel;
import br.ifba.inf011.aval2.model.Bridge.Converter;

//Originator
public class ArquivoHistorico extends Arquivo implements EntradaOperavel{
	
	
	public ArquivoHistorico(String nome, LocalDate dataCriacao, String conteudo, Converter tipoDeCodificacao) {
		super(nome, dataCriacao, conteudo, tipoDeCodificacao);
	}
	
	public NarrowMemento snapshot() throws IllegalAccessException{
		return new Snapshot(this.dump());
	}
	
	
	public Boolean back(NarrowMemento snapshot) throws IllegalAccessException{
		WideMemento snap = (WideMemento) snapshot;
		try {
			this.setConteudo(snap.getconteudo());;
			return true;
		} catch (Exception e) {
			return false; 
		}
		
	}
	
	
}
