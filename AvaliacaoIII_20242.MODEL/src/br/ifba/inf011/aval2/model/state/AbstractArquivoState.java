package br.ifba.inf011.aval2.model.state;

public abstract class AbstractArquivoState implements ArquivoState {

    @Override
    public String setConteudo(String conteudo) throws IllegalAccessException {
        // Lança exceção por padrão, pode ser sobrescrito por subclasses
        throw new IllegalAccessException("Operação não permitida no estado atual.");
    }
    
    @Override
    public String getConteudo(String conteudo) throws IllegalAccessException {
        throw new IllegalAccessException("Operação não permitida no estado atual.");
    }
    
    @Override
    public Long getTamanho(String conteudo)  {
        return 0L; 
    }

	@Override
	public ArquivoState liberar() throws IllegalAccessException {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public ArquivoState bloquear() throws IllegalAccessException {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public ArquivoState restaurar() throws IllegalAccessException {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public ArquivoState excluir() throws IllegalAccessException {
		System.out.println("No estado atual o arquivo não pode mudar para esse estado");
		return this;
	}

	@Override
	public ArquivoState somenteLeitura() throws IllegalAccessException {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return null;
	}

}
