package br.ifba.inf011.aval2;

import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

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
		EntradaOperavel a1 = new Arquivo("A1", LocalDate.now(), "00011000100011100000011111110101");
		EntradaOperavel b1 = new Arquivo("B1", LocalDate.now(), "UM ARQUIVO TAMANHO GRANDE");
		EntradaOperavel c1 = new Arquivo("C1", LocalDate.now(), "UM ARQUIVO TAMANHO MUITO MUITO GRANDE"); //76k
		ArquivoHistorico arquivoHistorico = new ArquivoHistorico("B1", LocalDate.now(), "Criei assim"); //87k

		Credencial user01 = new Credencial("user01");
		
		Caretaker caretaker = new Caretaker(arquivoHistorico);
		BinaryConverter binaryConverter = new BinaryConverter();
		
		Entrada a = new Pasta("A", LocalDate.now());
		Entrada b = new Pasta("B", LocalDate.now());
		Entrada c = new Pasta("C", LocalDate.now());
		Entrada raiz = new Pasta("/", LocalDate.now());
		
		raiz.addFilho(a);
		raiz.addFilho(b);
		
		a.addFilho(a1);
//		
		b.addFilho(c);
		b.addFilho(b1);
//		
		c.addFilho(c1);
		c.addFilho(arquivoHistorico);
	
		
		arquivoHistorico.somenteLeitura(); // 87k
		arquivoHistorico.bloquear();
		//caretaker.save();
		caretaker.showSnaps();
		arquivoHistorico.excluir();
		arquivoHistorico.liberar();
		caretaker.save();
		arquivoHistorico.escrever(user01, "editei");
		caretaker.showSnaps();
		arquivoHistorico.excluir(); //76k
//		caretaker.showSnaps();
//		arquivoHistorico.liberar();
//		caretaker.save();
//		arquivoHistorico.restaurar(); //87k
		
		//arquivoHistorico.escrever(user01, "aaa"); //79k
		//System.out.println(arquivoHistorico.ler(user01));
		//arquivoHistorico.restaurar();
		//System.out.println(arquivoHistorico.ler(user01));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		try {
//			arquivoHistorico.escrever(user01, "aaaaaaaaaaaaaaaaaaa");
//		}catch(IllegalAccessException e) {
//			System.out.println("No Estado Atual da Mensagem, o Conteudo Não pode Ser Modificado");
//		}
//		caretaker.save();
//		System.out.println("-------");
//		caretaker.showSnaps();
//		arquivoHistorico.escrever(user01, "A"); //77k 
//		caretaker.save();
//		arquivoHistorico.escrever(user01, binaryConverter.codificarConteudo(arquivoHistorico)); //84k
//		caretaker.save();
//		System.out.println("-------");
//		caretaker.showSnaps();
//		arquivoHistorico.bloquear();
//		arquivoHistorico.liberar();
//		try {
//			caretaker.undo();
//		}catch(IllegalAccessException e) {
//			System.out.println("No Estado Atual da Mensagem, o Conteudo Não pode Ser Modificado");
//		}
//		System.out.println("-------");
//		caretaker.showSnaps();
//		caretaker.undo();

		try {
			b1.escrever(user01, "CINCO");
		}catch(IllegalAccessException ex) {
			System.out.println("NÃO FOI POSSIVEL ESCREVER EM A1");
		}
			
		System.out.println(raiz.getNome() + ": " + raiz.getTamanho() + "K");

		try {
			b1.escrever(user01, "CINCO+2");
		}catch(IllegalAccessException ex) {
			System.out.println("NÃO FOI POSSIVEL ESCREVER EM A1");
		}
		
		try {
			System.out.println("B1: " + b1.ler(user01));
		} catch (IllegalAccessException e) {
			System.out.println("NÃO FOI POSSIVEL LER DE A1");		}			
		
		System.out.println(raiz.getNome() + ": " + raiz.getTamanho() + "K");
	}
	
	
	public static void main(String[] args) throws IllegalAccessException {
		App app = new App();
		app.runQ1();
	}

}
