package br.ifba.inf011.aval2.model.state;

public interface ArquivoState {
	
	String setConteudo(String conteudo) throws IllegalAccessException;
	String getConteudo(String conteudo) throws IllegalAccessException;
	Long getTamanho(String conteudo);
	
	public ArquivoState liberar() throws IllegalAccessException;
	public ArquivoState bloquear() throws IllegalAccessException;	
	public ArquivoState restaurar() throws IllegalAccessException;
	public ArquivoState excluir() throws IllegalAccessException;
	public ArquivoState somenteLeitura() throws IllegalAccessException;
	public void desc();

}

