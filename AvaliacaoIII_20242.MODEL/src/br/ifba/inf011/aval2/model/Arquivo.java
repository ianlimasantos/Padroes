package br.ifba.inf011.aval2.model;

import java.time.LocalDate;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import br.ifba.inf011.aval2.model.composite.AbstractEntrada;
import br.ifba.inf011.aval2.model.state.ArquivoState;
import br.ifba.inf011.aval2.model.state.NormalState;


public class Arquivo extends AbstractEntrada implements EntradaOperavel{
	
	private ArquivoState state;
	private String conteudo;

	public Arquivo(String nome, LocalDate dataCriacao, String conteudo) {
		super(nome, dataCriacao);
		this.conteudo =  conteudo; 
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
	public Long getTamanho() throws IllegalAccessException{
		return Long.valueOf(this.conteudo.length());
	}
	
	@Override
	public String ler(Credencial credencial) throws IllegalAccessException{
		return this.conteudo;
	}

	@Override
	public void escrever(Credencial credencial, String conteudo) throws IllegalAccessException {
		this.conteudo = this.state.setConteudo(conteudo); 
	}

	@Override
	public String dump(){
		return this.conteudo;
	};

	protected String getConteudo() {
		return conteudo;
	}
	
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
		this.state = this.state.bloquear();
	}
	public void somenteLeitura() throws IllegalAccessException{
		this.state = this.state.somenteLeitura();
	}
	
}
