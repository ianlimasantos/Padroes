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
		System.out.println("Bloqueado");
		return new BloqueadoState();
	}

	@Override
	public ArquivoState excluir() throws IllegalAccessException {
		// TODO Auto-generated method stub
		System.out.println("Excluido");
		return new ExcluidoState();
	}

	@Override
	public ArquivoState somenteLeitura() throws IllegalAccessException {
		// TODO Auto-generated method stub
		System.out.println("Somente Leitura");
		return new SomenteLeituraState();
	}

	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return "Normal";
	}


}
