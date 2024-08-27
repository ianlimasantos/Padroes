package br.ifba.inf011.aval2.model.state;

public class BloqueadoState extends AbstractArquivoState implements ArquivoState {
	
	@Override
    public Long getTamanho(String conteudo) {
        return Long.valueOf(conteudo.length());
    }

	@Override
	public ArquivoState liberar() throws IllegalAccessException {
		// TODO Auto-generated method stub
		System.out.println("Liberado");
		return new NormalState();
	}

	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return "Bloqueado";
	}

}
