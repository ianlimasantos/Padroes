package br.ifba.inf011.aval2.model.state;


public class SomenteLeituraState extends AbstractArquivoState implements ArquivoState {
	 
	@Override
	public String getConteudo(String conteudo) {
		// TODO Auto-generated method stub
		return conteudo;
	}
	
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
	public ArquivoState bloquear() throws IllegalAccessException {
		// TODO Auto-generated method stub
		return new BloqueadoState();
	}

	@Override
	public void desc() {
		System.out.println("Estado do Arquivo Somente Leitura");
	}

}
