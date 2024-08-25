package br.ifba.inf011.aval2.model;

import javax.naming.OperationNotSupportedException;

public interface Operavel {
	
	public String dump();
	public String ler(Credencial credencial) throws IllegalAccessException;
	public void escrever(Credencial credencial, String escrever) throws IllegalAccessException, OperationNotSupportedException;
}
