package br.ifba.inf011.aval2.model.state;

import javax.naming.OperationNotSupportedException;

public class BloqueadoState extends AbstractArquivoState implements ArquivoState {

	@Override
	public String setConteudo(String conteudo) throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArquivoState liberar() throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		return new NormalState();
	}

	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return "Bloqueado";
	}

}
