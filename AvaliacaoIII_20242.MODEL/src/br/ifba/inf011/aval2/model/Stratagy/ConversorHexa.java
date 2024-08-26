package br.ifba.inf011.aval2.model.Stratagy;

public class ConversorHexa implements ConversorStrategy {
	
	public static int HEX_BLOCK_SIZE = 4;
	
	@Override
	public String converterString(String hex) {
		int iCont = 0;
		StringBuffer conteudo = new StringBuffer();
		while(iCont * ConversorHexa.HEX_BLOCK_SIZE < hex.length()) {
			int inicio = iCont * ConversorHexa.HEX_BLOCK_SIZE;
			int fim = (iCont + 1) * ConversorHexa.HEX_BLOCK_SIZE;
			String value = hex.substring(inicio, fim);
			conteudo.append(this.toChar(value));
			iCont++;
		}
		return conteudo.toString();	
	}
	
	@Override
	public String codificar(String string) {
		StringBuffer conteudo = new StringBuffer();		
		for(int iCont = 0; iCont < string.length(); iCont++)
			conteudo.append(this.toHex(string.charAt(iCont)));
		return conteudo.toString();
	}
	
	private Character toChar(String hexadecimal) {
	    Integer numPalavra = Integer.parseInt(hexadecimal, 16);
	    String characters = Character.toString(numPalavra);
		return characters.charAt(0);		
	}	

	private String toHex(Character character) {
		String conteudo = Integer.toHexString((int) character).toUpperCase();
		return String.format("%04X", Integer.parseInt(conteudo, 16));		
	}

}
