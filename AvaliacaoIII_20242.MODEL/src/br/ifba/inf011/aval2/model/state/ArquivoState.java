package br.ifba.inf011.aval2.model.state;

import java.util.Map;

import javax.naming.OperationNotSupportedException;

public interface ArquivoState {
		
	public String setConteudo(String conteudo)
		throws OperationNotSupportedException;
	
	public ArquivoState liberar() throws OperationNotSupportedException;
	public ArquivoState bloquear() throws OperationNotSupportedException;	
	public ArquivoState restaurar() throws OperationNotSupportedException;
	public ArquivoState excluir() throws OperationNotSupportedException;
	public ArquivoState somenteLeitura() throws OperationNotSupportedException;
	public String desc();
	
		
}

