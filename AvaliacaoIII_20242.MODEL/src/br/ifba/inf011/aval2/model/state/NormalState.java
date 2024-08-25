package br.ifba.inf011.aval2.model.state;

import javax.naming.OperationNotSupportedException;

public class NormalState extends AbstractArquivoState implements ArquivoState {

	@Override
	public String setConteudo(String conteudo) throws IllegalAccessException {
		// TODO Auto-generated method stub
		return conteudo;
	}


	@Override
	public ArquivoState bloquear() throws IllegalAccessException {
		// TODO Auto-generated method stub
		return new BloqueadoState();
	}

	@Override
	public ArquivoState excluir() throws IllegalAccessException {
		// TODO Auto-generated method stub
		return new ExcluidoState();
	}

	@Override
	public ArquivoState somenteLeitura() throws IllegalAccessException {
		// TODO Auto-generated method stub
		return new SomenteLeituraState();
	}

	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return "Normal";
	}

}
