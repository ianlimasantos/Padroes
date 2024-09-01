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
	
	public static void main(String[] args) throws IllegalAccessException {
		App app = new App();
		app.runQ1(); // Testando bridge com todos os arquivos. Testando memento e state com arquivoHistorico
//		app.testeArquivo(); // bridge e state com arquivo
	}
	
	public void runQ1() throws IllegalAccessException  {
		BinaryConverter binaryConverter = new BinaryConverter();
		
//		Adicionamos o tipo de codificação para o arquivo e setamos no construtor o estado do arquivo para iniciar como normal
//		No construtor de todos os estados do state estamos chamando um método que descreve o nome do próprio estado
		Arquivo a1 = new Arquivo("A1", LocalDate.now(), "00011000100011100000011111110101", binaryConverter);
		Arquivo b1 = new Arquivo("B1", LocalDate.now(), "UM ARQUIVO TAMANHO GRANDE", binaryConverter);
		Arquivo c1 = new Arquivo("C1", LocalDate.now(), "UM ARQUIVO TAMANHO MUITO MUITO GRANDE", binaryConverter); 

		Credencial user01 = new Credencial("user01");
		
		ArquivoHistorico arquivoHistorico = new ArquivoHistorico("B1", LocalDate.now(), "Criei assim", binaryConverter); 
		Caretaker caretaker = new Caretaker(arquivoHistorico);
		
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
		c.addFilho(arquivoHistorico);
	
		
		caretaker.save(); // Salvando o último estado do conteúdo do arquivo
		caretaker.showSnaps(); // Mostrando todos os históricos salvos do conteúdo do arquivo
		arquivoHistorico.ler(user01); // Lendo conteúdo do arquivo
		try {
			arquivoHistorico.bloquear(); // Setando o estado do arquivo para bloqueado
			
			// A escrita não será permitida porque o estado do arquivo é bloqueado
			arquivoHistorico.escrever(user01, "Bolo de chocolate");
		}catch(IllegalAccessException ex) {
			System.out.println("No estado atual não é possível realizar essa operação");
		}
		arquivoHistorico.liberar(); // Setando o estado do arquivo para normal
		arquivoHistorico.escrever(user01, "Pipoca de morango");
		caretaker.save(); // Salvando o último estado do conteúdo do arquivo
		try {
			arquivoHistorico.somenteLeitura(); // Setando o estado do arquivo para somente leitura
			
			// A escrita não será permitida porque o estado do arquivo é somente leitura
			arquivoHistorico.escrever(user01, "Coxinha de frango");
		}catch(IllegalAccessException ex) {
			System.out.println("No estado atual não é possível realizar essa operação");
		}
		arquivoHistorico.ler(user01); // Lendo conteúdo do arquivo
		arquivoHistorico.liberar(); // Setando o estado do arquivo para normal
		arquivoHistorico.escrever(user01, "Lagoa azul");
		arquivoHistorico.ler(user01); // Lendo conteúdo do arquivo
		try {
			arquivoHistorico.excluir(); // Setando o estado do arquivo para excluido
			
			// O arquivo não vai ser lido porque o estado está excluído
			arquivoHistorico.ler(user01); // Lendo conteúdo do arquivo
		}catch(IllegalAccessException ex) {
			System.out.println("No estado atual não é possível realizar essa operação");
		}
		caretaker.showSnaps(); // Mostrando todos os históricos salvos do conteúdo do arquivo
		caretaker.undo(); // Restaurando o último conteúdo do arquivo
		arquivoHistorico.restaurar(); // Setando o estado do arquivo para normal
		arquivoHistorico.ler(user01); // Lendo conteúdo do arquivo
		
		// Na linha abaixo por conta do estado o tamanho do arquivo retorna 0
		arquivoHistorico.excluir(); // Setando o estado do arquivo para excluído 
		
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

	
	public void testeArquivo() throws IllegalAccessException  {
		BinaryConverter binaryConverter = new BinaryConverter();
		
//		Adicionamos o tipo de codificação para o arquivo e setamos no construtor o estado do arquivo para iniciar como normal
//		No construtor de todos os estados do state estamos chamando um método que descreve o nome do próprio estado
		Arquivo a1 = new Arquivo("A1", LocalDate.now(), "00011000100011100000011111110101", binaryConverter);
		Arquivo b1 = new Arquivo("B1", LocalDate.now(), "UM ARQUIVO TAMANHO GRANDE", binaryConverter);
		Arquivo c1 = new Arquivo("C1", LocalDate.now(), "UM ARQUIVO TAMANHO MUITO MUITO GRANDE", binaryConverter); 

		Credencial user01 = new Credencial("user01");
		
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
	
		c1.ler(user01); // Lendo conteúdo do arquivo
		try {
			c1.bloquear(); // Setando o estado do arquivo para bloqueado
			
			// A escrita não será permitida porque o estado do arquivo é bloqueado
			c1.escrever(user01, "Chico Coins");
		}catch(IllegalAccessException ex) {
			System.out.println("No estado atual não é possível realizar essa operação");
		}
		c1.liberar(); // Setando o estado do arquivo para normal
		c1.escrever(user01, "Ariana Grande");
		
		try {
			c1.somenteLeitura(); // Setando o estado do arquivo para somente leitura
			
			// A escrita não será permitida porque o estado do arquivo é somente leitura
			c1.escrever(user01, "Claudia Milk");
		}catch(IllegalAccessException ex) {
			System.out.println("No estado atual não é possível realizar essa operação");
		}
		c1.ler(user01); // Lendo conteúdo do arquivo
		c1.liberar(); // Setando o estado do arquivo para normal
		c1.escrever(user01, "Lady Gaga");
		c1.ler(user01); // Lendo conteúdo do arquivo
		try {
			c1.excluir(); // Setando o estado do arquivo para excluido
			
			// O arquivo não vai ser lido porque o estado está excluído
			c1.ler(user01); // Lendo conteúdo do arquivo
		}catch(IllegalAccessException ex) {
			System.out.println("No estado atual não é possível realizar essa operação");
		}
		
		c1.restaurar(); // Setando o estado do arquivo para normal
		c1.ler(user01); // Lendo conteúdo do arquivo
		
		System.out.println("\nTamanho da raiz com arquivo no estado não excluído");
		System.out.println(raiz.getNome() + ": " + raiz.getTamanho() + "K");
		
		// Na linha abaixo por conta do estado o tamanho do arquivo retorna 0
		c1.excluir(); // Setando o estado do arquivo para excluído 
		
		System.out.println("\nTamanho da raiz com arquivo no estado excluído");
		System.out.println(raiz.getNome() + ": " + raiz.getTamanho() + "K");
	
	}
	

}
