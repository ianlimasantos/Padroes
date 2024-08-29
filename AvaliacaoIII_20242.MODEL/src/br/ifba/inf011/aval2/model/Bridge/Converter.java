package br.ifba.inf011.aval2.model.Bridge;

import br.ifba.inf011.aval2.model.Arquivo;

public interface Converter {
	String decodificarConteudo(String conteudo) throws IllegalAccessException;
	String codificarConteudo(String conteudo) throws IllegalAccessException;
}
