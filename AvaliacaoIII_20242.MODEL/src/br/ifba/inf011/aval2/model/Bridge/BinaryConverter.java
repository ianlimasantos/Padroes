package br.ifba.inf011.aval2.model.Bridge;

import java.text.DecimalFormat;

import br.ifba.inf011.aval2.model.Arquivo;
import br.ifba.inf011.aval2.model.Conversor2Bin;

public class BinaryConverter implements Converter {

	public String decodificarConteudo(Arquivo arquivo) throws IllegalAccessException {
		int iCont = 0;
		StringBuffer conteudo = new StringBuffer();
		while(iCont * Conversor2Bin.BIN_BLOCK_SIZE < arquivo.dump().length()) {
			int inicio = iCont * Conversor2Bin.BIN_BLOCK_SIZE;
			int fim = (iCont + 1) * Conversor2Bin.BIN_BLOCK_SIZE;
			String value = arquivo.dump().substring(inicio, fim);
			conteudo.append(this.toChar(value));
			iCont++;
		}
		return conteudo.toString();		
	}
	
	@Override
	public String codificarConteudo(Arquivo arquivo) throws IllegalAccessException {
		StringBuffer arquivoConvertido = new StringBuffer();		
		for(int iCont = 0; iCont < arquivo.dump().length(); iCont++)
			arquivoConvertido.append(this.toBin(arquivo.dump().charAt(iCont)));
		return arquivoConvertido.toString();
	}
	
	private Character toChar(String binario) {
	    Integer numPalavra = Integer.parseInt(binario, 2);
	    String characters = Character.toString(numPalavra);
		return characters.charAt(0);		
	}

	private String toBin(Character character) {
		DecimalFormat df = new DecimalFormat("00000000");
		String conteudo = Integer.toBinaryString((int) character);
		return df.format(Integer.parseInt(conteudo));		
	}
}
