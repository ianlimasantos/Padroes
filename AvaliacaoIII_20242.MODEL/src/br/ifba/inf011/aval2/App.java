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


public class App {
	
	public void runQ1() throws IllegalAccessException  {
		BinaryConverter binaryConverter = new BinaryConverter();
		Arquivo a1 = new Arquivo("A1", LocalDate.now(), "00011000100011100000011111110101", binaryConverter);
		Arquivo b1 = new Arquivo("B1", LocalDate.now(), "UM ARQUIVO TAMANHO GRANDE", binaryConverter);
		Arquivo c1 = new Arquivo("C1", LocalDate.now(), "UM ARQUIVO TAMANHO MUITO MUITO GRANDE", binaryConverter); //76k

		Credencial user01 = new Credencial("user01");
		
		ArquivoHistorico arquivoHistorico = new ArquivoHistorico("B1", LocalDate.now(), "Criei assim", binaryConverter); //87k
		Caretaker caretaker = new Caretaker(arquivoHistorico);
		
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
	
		
		caretaker.save();
		caretaker.showSnaps();
		arquivoHistorico.escrever(user01, "pipoca de morango");
		System.out.println(arquivoHistorico.ler(user01));
		caretaker.save();
		arquivoHistorico.escrever(user01, "lagoa azul");
		System.out.println(arquivoHistorico.ler(user01));;
		arquivoHistorico.excluir();
		caretaker.showSnaps();
		caretaker.undo();
		arquivoHistorico.restaurar();
		System.out.println(arquivoHistorico.ler(user01));
		
//		System.out.println(a1.dump());
//		System.out.println(a1.ler(user01));
//		System.out.println(b1.dump());
//		System.out.println(b1.ler(user01));
//		System.out.println(c1.dump());
//		c1.excluir(); 
		
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
