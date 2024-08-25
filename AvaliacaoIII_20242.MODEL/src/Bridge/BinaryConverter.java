package Bridge;

import java.text.DecimalFormat;

public class BinaryConverter implements Converter {

	@Override
	public String codificarConteudo(String conteudo) {
		StringBuffer conteudoConvertido = new StringBuffer();		
		for(int iCont = 0; iCont < conteudo.length(); iCont++)
			conteudoConvertido.append(this.toBin(conteudo.charAt(iCont)));
		return conteudoConvertido.toString();
	}

	private String toBin(Character character) {
		DecimalFormat df = new DecimalFormat("00000000");
		String conteudo = Integer.toBinaryString((int) character);
		return df.format(Integer.parseInt(conteudo));		
	}
}
