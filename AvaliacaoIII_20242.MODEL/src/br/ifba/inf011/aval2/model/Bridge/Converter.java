package br.ifba.inf011.aval2.model.Bridge;

import br.ifba.inf011.aval2.model.Arquivo;

public interface Converter {
	String decodificarConteudo(Arquivo arquivo) throws IllegalAccessException;
	String codificarConteudo(Arquivo arquivo) throws IllegalAccessException;
}
