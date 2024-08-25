package br.ifba.inf011.aval2.model.state;

import javax.naming.OperationNotSupportedException;

public class BloqueadoState extends AbstractArquivoState implements ArquivoState {

	@Override
	public ArquivoState liberar() throws IllegalAccessException {
		// TODO Auto-generated method stub
		return new NormalState();
	}

	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return "Bloqueado";
	}

}
