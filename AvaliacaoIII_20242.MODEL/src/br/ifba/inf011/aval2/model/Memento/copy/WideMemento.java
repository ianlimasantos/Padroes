package br.ifba.inf011.aval2.model.Memento.copy;

import java.lang.invoke.StringConcatFactory;
import java.sql.Date;
import java.time.LocalDate;

public interface WideMemento {
	String getNome();
	LocalDate getData();
	String getConteudo();
}
