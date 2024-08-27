package br.ifba.inf011.aval2.model.state;

public class ExcluidoState extends AbstractArquivoState implements ArquivoState {
	
	@Override
	public ArquivoState restaurar() throws IllegalAccessException {
		// TODO Auto-generated method stub
		System.out.println("Restaurado");
		return new NormalState();
	}


	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return "Excluido";
	}

}
