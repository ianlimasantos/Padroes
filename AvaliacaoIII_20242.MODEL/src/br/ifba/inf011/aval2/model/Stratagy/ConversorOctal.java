package br.ifba.inf011.aval2.model.Stratagy;

import java.text.DecimalFormat;

public class ConversorOctal implements ConversorStrategy {

	public static int OCTAL_BLOCK_SIZE = 3;
	
	@Override
	public String converterString(String octal) {
		int iCont = 0;
		StringBuffer conteudo = new StringBuffer();
		while(iCont * ConversorOctal.OCTAL_BLOCK_SIZE < octal.length()) {
			int inicio = iCont * ConversorOctal.OCTAL_BLOCK_SIZE;
			int fim = (iCont + 1) * ConversorOctal.OCTAL_BLOCK_SIZE;
			String value = octal.substring(inicio, fim);
			conteudo.append(this.toChar(value));
			iCont++;
		}
		return conteudo.toString();	
	}
	
	@Override
	public String codificar(String string) {
		StringBuffer conteudo = new StringBuffer();		
		for(int iCont = 0; iCont < string.length(); iCont++)
			conteudo.append(this.toOct(string.charAt(iCont)));
		return conteudo.toString();
	}
	
	private Character toChar(String octal) {
	    Integer numPalavra = Integer.parseInt(octal, 8);
	    String characters = Character.toString(numPalavra);
		return characters.charAt(0);		
	}	

	private String toOct(Character character) {
		DecimalFormat df = new DecimalFormat("000");
		String conteudo = Integer.toOctalString((int) character);
		return df.format(Integer.parseInt(conteudo));		
	}

}
