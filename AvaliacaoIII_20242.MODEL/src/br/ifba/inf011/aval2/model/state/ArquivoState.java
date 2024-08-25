package br.ifba.inf011.aval2.model.state;

import java.util.Map;

import javax.naming.OperationNotSupportedException;

public interface ArquivoState {
		
	public String setConteudo(String conteudo)
		throws IllegalAccessException;
	
	public ArquivoState liberar() throws IllegalAccessException;
	public ArquivoState bloquear() throws IllegalAccessException;	
	public ArquivoState restaurar() throws IllegalAccessException;
	public ArquivoState excluir() throws IllegalAccessException;
	public ArquivoState somenteLeitura() throws IllegalAccessException;
	public String desc();
	
		
}

