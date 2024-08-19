package br.ifba.inf011.aval2.model;

import java.time.LocalDate;


public class ArquivoHistorico1 extends Arquivo implements EntradaOperavel{ 

	public ArquivoHistorico1(String nome, LocalDate dataCriacao, String conteudo) {
		super(nome, dataCriacao, conteudo);
	}
	
//	public ArquivoMemento createWideMemento() {
//		return new ArquivoMemento(getNome(), getDataCriacao(), getConteudo()); 
//	}
//	
//	public NarrowMemento createNarrowMemento() {
//		return new NarrowMemento() {
//			private final String narrowNome = getNome();
//			private final LocalDate narrowData = getDataCriacao();
//			private final String narrowConteudo = getConteudo();
//			
//			public String getNarrowNome() {
//				return narrowNome;
//			}
//			public LocalDate getNarrowData() {
//				return narrowData;
//			}
//			
//			public String getNarrowConteudo() {
//				return narrowConteudo;
//			}
//		};
//	}
	
}
