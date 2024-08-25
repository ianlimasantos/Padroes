package br.ifba.inf011.aval2.model.Memento;

import java.time.LocalDate;

import br.ifba.inf011.aval2.model.Arquivo;
import br.ifba.inf011.aval2.model.EntradaOperavel;
import br.ifba.inf011.aval2.model.Stratagy.ConversorStrategy;

//Originator
public class ArquivoHistorico extends Arquivo implements EntradaOperavel{
	
	
	public ArquivoHistorico(String nome, LocalDate dataCriacao, String conteudo, ConversorStrategy tipoCodificacao) {
		super(nome, dataCriacao, conteudo, tipoCodificacao);
	}
	
	public NarrowMemento snapshot(){
		return new Snapshot(this.getNome(), this.getDataCriacao(), this.getConteudo());
	}
	
	
	public void back(NarrowMemento snapshot){
		WideMemento snap = (WideMemento) snapshot;
		this.setNome(snap.getNome());
		this.setDataCriacao(snap.getDataCriacao());
	}
	
	public void editar(String conteudo) {
		this.setConteudo(conteudo);
	}

	
}
