package br.ifba.inf011.aval2.model.state;

import javax.naming.OperationNotSupportedException;

public abstract class AbstractArquivoState implements ArquivoState {

	@Override
	public String setConteudo(String conteudo) throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		throw new OperationNotSupportedException();
	}

	@Override
	public ArquivoState liberar() throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public ArquivoState bloquear() throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public ArquivoState restaurar() throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public ArquivoState excluir() throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public ArquivoState somenteLeitura() throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return null;
	}

}
