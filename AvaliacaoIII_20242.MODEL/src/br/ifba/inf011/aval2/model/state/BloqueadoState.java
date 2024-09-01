package br.ifba.inf011.aval2.model.state;

public class BloqueadoState extends AbstractArquivoState implements ArquivoState {
	
	@Override
    public Long getTamanho(String conteudo) {
        return Long.valueOf(conteudo.length());
    }

	@Override
	public ArquivoState liberar() throws IllegalAccessException {
		// TODO Auto-generated method stub
		return new NormalState();
	}

	@Override
	public void desc() {
		System.out.println("Estado do Arquivo Bloqueado");
	}

}
