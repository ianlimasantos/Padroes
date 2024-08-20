package br.ifba.inf011.aval2.model.Memento;

import java.time.LocalDate;

import br.ifba.inf011.aval2.model.Arquivo;
import br.ifba.inf011.aval2.model.EntradaOperavel;
import br.ifba.inf011.aval2.model.Stratagy.ConversorStrategy;


public class ArquivoHistorico extends Arquivo implements EntradaOperavel{ 

//	private String nome;
//	private LocalDate data;
//	private String conteudo;
	

	public ArquivoHistorico(String nome, LocalDate dataCriacao, String conteudo, ConversorStrategy tipoCodificacao) {
		super(nome, dataCriacao, conteudo, tipoCodificacao);
	}
	
	public ConcreteMemento saveMemento() {
		return new ConcreteMemento(getNome(), getDataCriacao(), getConteudo());
	}
	
	public void restoreMemento(MementoInterface memento) {
		 if (memento instanceof ConcreteMemento) {
	            ConcreteMemento concreteMemento = (ConcreteMemento) memento;
	            this.setNome(concreteMemento.getNome());
	            this.setConteudo(concreteMemento.getconteudo());
	            this.setDataCriacao(concreteMemento.getData());
	            System.out.println("Conteudo:" + concreteMemento.getconteudo());
	        }
		 

	}
	
	public void alterarArquivo(String nome, String conteudo) {
	    super.setNome(nome);
	    super.setConteudo(conteudo);
	}
	
}
