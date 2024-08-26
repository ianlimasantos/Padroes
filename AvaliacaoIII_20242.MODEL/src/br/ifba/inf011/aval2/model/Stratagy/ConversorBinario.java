package br.ifba.inf011.aval2.model.Stratagy;

import java.text.DecimalFormat;

import br.ifba.inf011.aval2.model.Conversor2Bin;

public class ConversorBinario implements ConversorStrategy {
	
	public static int BIN_BLOCK_SIZE = 8;
	

	@Override
	public String converterString(String binary) {
		int iCont = 0;
		StringBuffer conteudo = new StringBuffer();
		while(iCont * ConversorBinario.BIN_BLOCK_SIZE < binary.length()) {
			int inicio = iCont * ConversorBinario.BIN_BLOCK_SIZE;
			int fim = (iCont + 1) * ConversorBinario.BIN_BLOCK_SIZE;
			String value = binary.substring(inicio, fim);
			conteudo.append(this.toChar(value));
			iCont++;
		}
		return conteudo.toString();	
	}
	
	@Override
	public String codificar(String string) {
		StringBuffer conteudo = new StringBuffer();		
		for(int iCont = 0; iCont < string.length(); iCont++)
			conteudo.append(this.toBin(string.charAt(iCont)));
		return conteudo.toString();
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
