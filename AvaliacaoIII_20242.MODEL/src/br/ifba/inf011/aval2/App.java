package br.ifba.inf011.aval2;

import java.time.LocalDate;

import br.ifba.inf011.aval2.model.Arquivo;
import br.ifba.inf011.aval2.model.Credencial;
import br.ifba.inf011.aval2.model.Entrada;
import br.ifba.inf011.aval2.model.EntradaOperavel;
import br.ifba.inf011.aval2.model.Pasta;
import br.ifba.inf011.aval2.model.Bridge.BinaryConverter;
import br.ifba.inf011.aval2.model.Memento.ArquivoHistorico;
import br.ifba.inf011.aval2.model.Memento.Caretaker;
import br.ifba.inf011.aval2.model.Stratagy.ConversorBinario;


public class App {
	
	
	public void runQ1() throws IllegalAccessException  {
		ConversorBinario conversorBinario = new ConversorBinario();
		EntradaOperavel a1 = new Arquivo("A1", LocalDate.now(), "00011000100011100000011111110101", conversorBinario);
		EntradaOperavel b1 = new Arquivo("B1", LocalDate.now(), "UM ARQUIVO TAMANHO GRANDE", conversorBinario);
		EntradaOperavel c1 = new Arquivo("C1", LocalDate.now(), "UM ARQUIVO TAMANHO MUITO MUITO GRANDE", conversorBinario);
		
		Entrada a = new Pasta("A", LocalDate.now());
		Entrada b = new Pasta("B", LocalDate.now());
		Entrada c = new Pasta("C", LocalDate.now());
		Entrada raiz = new Pasta("/", LocalDate.now());
		
		raiz.addFilho(a);
		raiz.addFilho(b);
		
		a.addFilho(a1);
		
		b.addFilho(c);
		b.addFilho(b1);
		
		c.addFilho(c1);
		
		
		Credencial user01 = new Credencial("user01");
//		
//		System.out.println(b1.ler(user01));
//		b1.codificarConteudo();
//		System.out.println(b1.ler(user01));//
//		b1.decodificarConteudo();
//		System.out.println(b1.ler(user01));
//		
//		System.out.println("===================");
//		ConversorOctal conversorOctal = new ConversorOctal();
//		ConversorHexa conversorHexa = new ConversorHexa();
//		
//		EstrategiaCodificacao binario = new CodificacaoBinaria();
//        Arquivo arquivoBinario = new Arquivo(binario);
        
		
		ArquivoHistorico arquivoHistorico = new ArquivoHistorico("B1", LocalDate.now(), "Criei assim", conversorBinario);

		Caretaker caretaker = new Caretaker(arquivoHistorico);
		
		BinaryConverter binaryConverter = new BinaryConverter();
	
		caretaker.save();
		System.out.println("-------");
		caretaker.showSnaps();
		arquivoHistorico.editar("Editei uma vez");
		caretaker.save();
		arquivoHistorico.editar(binaryConverter.codificarConteudo(arquivoHistorico)); 
		System.out.println("-------");
		caretaker.save();
		caretaker.showSnaps();
		arquivoHistorico.editar(binaryConverter.decodificarConteudo(arquivoHistorico));
		System.out.println("-------");
		caretaker.save();
		caretaker.showSnaps();
		arquivoHistorico.editar("Editei pela segunda vez");
		caretaker.save();
		System.out.println("APOS SAVE");
		caretaker.showSnaps();
		caretaker.undo();
		System.out.println("-------");
		caretaker.showSnaps();
		caretaker.undo();
		System.out.println("-------");
		caretaker.showSnaps();
		caretaker.undo();
		System.out.println("-------");
		caretaker.showSnaps();
		
		//caretaker.undo();
		System.out.println("------------");
		
//		System.out.println("\n---------- Binario -----------");

//		ConversorContext binario = new ConversorContext(conversorBinario); 
//		System.out.println(binario.converterString(a1.ler(user01)));
//		
//		System.out.println("\n---------- Octal -----------");
//		ConversorContext octal = new ConversorContext(conversorOctal); 
//		System.out.println(octal.codificar(b1.ler(user01)));
//
//		System.out.println("\n---------- Hexa -----------");
//		ConversorContext hexa = new ConversorContext(conversorHexa); 
//		System.out.println(hexa.codificar(c1.ler(user01)));
		

//		try {
//			b1.escrever(user01, "CINCO");
//		}catch(IllegalAccessException ex) {
//			System.out.println("NÃO FOI POSSIVEL ESCREVER EM A1");
//		}
//			
//		System.out.println(raiz.getNome() + ": " + raiz.getTamanho() + "K");
//
//		try {
//			b1.escrever(user01, "CINCO+2");
//		}catch(IllegalAccessException ex) {
//			System.out.println("NÃO FOI POSSIVEL ESCREVER EM A1");
//		}
//		
//		try {
//			System.out.println("B1: " + b1.ler(user01));
//		} catch (IllegalAccessException e) {
//			System.out.println("NÃO FOI POSSIVEL LER DE A1");		}			
//		
//		System.out.println(raiz.getNome() + ": " + raiz.getTamanho() + "K");
	}
	
	
	public static void main(String[] args) throws IllegalAccessException {
		App app = new App();
		app.runQ1();
	}

}
