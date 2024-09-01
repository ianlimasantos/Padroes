package br.ifba.inf011.aval2.model.state;


public class NormalState extends AbstractArquivoState implements ArquivoState {

	@Override
	public String getConteudo(String conteudo) {
		// TODO Auto-generated method stub
		return conteudo;
	}
	
    @Override
    public String setConteudo(String conteudo) {
        return conteudo;
    }
    
    @Override
    public Long getTamanho(String conteudo) {
        return Long.valueOf(conteudo.length());
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
	public void desc() {
		System.out.println("Estado do Arquivo Normal");
	}


}
