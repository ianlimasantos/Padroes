package br.ifba.inf011.aval2.model.state;

import javax.naming.OperationNotSupportedException;

public class SomenteLeituraState extends AbstractArquivoState implements ArquivoState {

	@Override
	public String setConteudo(String conteudo) throws IllegalAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArquivoState liberar() throws IllegalAccessException {
		// TODO Auto-generated method stub
		return new NormalState();
	}

	@Override
	public ArquivoState bloquear() throws IllegalAccessException {
		// TODO Auto-generated method stub
		return new BloqueadoState();
	}

	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return "Somente Leitura";
	}

}
