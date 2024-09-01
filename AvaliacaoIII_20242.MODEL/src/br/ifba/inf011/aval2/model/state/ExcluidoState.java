package br.ifba.inf011.aval2.model.state;

public class ExcluidoState extends AbstractArquivoState implements ArquivoState {
	
	@Override
	public ArquivoState restaurar() throws IllegalAccessException {
		// TODO Auto-generated method stub
		return new NormalState();
	}


	@Override
	public void desc() {
		System.out.println("Estado do Arquivo Excluído");
	}

}
