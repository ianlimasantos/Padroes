package br.ifba.inf011.aval2.model;

import java.time.LocalDate;
import java.util.List;
import javax.naming.OperationNotSupportedException;

import br.ifba.inf011.aval2.model.Bridge.Converter;
import br.ifba.inf011.aval2.model.composite.AbstractEntrada;
import br.ifba.inf011.aval2.model.state.ArquivoState;
import br.ifba.inf011.aval2.model.state.NormalState;


public class Arquivo extends AbstractEntrada implements EntradaOperavel{
	
	protected ArquivoState state;
	private String conteudo;
	private Converter tipoDeCodificacao;

	public Arquivo(String nome, LocalDate dataCriacao, String conteudo, Converter tipoDeCodificacao) {
		super(nome, dataCriacao);
		this.conteudo =  tipoDeCodificacao.codificarConteudo(conteudo); 
		this.tipoDeCodificacao = tipoDeCodificacao; 
		this.state = new NormalState();
	}

	@Override
	public List<Entrada> getFilhos() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public void addFilho(Entrada entrada) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeFilho(Entrada entrada) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	@Override
	public Long getTamanho() throws IllegalAccessException {
		return Long.valueOf(this.state.getTamanho(conteudo));
	}
	
	@Override
	public String ler(Credencial credencial) throws IllegalAccessException{
		return tipoDeCodificacao.decodificarConteudo(this.state.getConteudo(this.conteudo));
	}

	@Override
	public void escrever(Credencial credencial, String conteudo) throws IllegalAccessException {
		this.conteudo = tipoDeCodificacao.codificarConteudo(this.state.setConteudo(conteudo));
	}

	@Override
	public String dump() throws IllegalAccessException{
		return this.conteudo;
	};
	
	protected void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public void liberar() throws IllegalAccessException {
		this.state = this.state.liberar();
	}
	
	public void bloquear() throws IllegalAccessException{	
		this.state = this.state.bloquear();
	}
	public void restaurar() throws IllegalAccessException{
		this.state = this.state.restaurar();
	}
	public void excluir() throws IllegalAccessException{
		this.state = this.state.excluir();
	}
	
	public void somenteLeitura() throws IllegalAccessException{
		this.state = this.state.somenteLeitura();
	}
	
}
