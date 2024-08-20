package br.ifba.inf011.aval2.model.Memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
	  	private final List<MementoInterface> mementos = new ArrayList<>();
	  
	    private final ArquivoHistorico arquivoHistorico;

	    public Caretaker(ArquivoHistorico arquivoHistorico) {
	        this.arquivoHistorico = arquivoHistorico;
	    }

	    public void backup() {
	        System.out.println("Backup: salvando o estado de ArquivoHistorico");
	        mementos.add(arquivoHistorico.saveMemento());
	    }

	    public void undo() {
	        if (mementos.isEmpty()) {
	            System.out.println("Backup: no mementos");
	            return;
	        }

	        MementoInterface mementoInterface = mementos.remove(mementos.size() - 1);
	        arquivoHistorico.restoreMemento(mementoInterface);
	        System.out.println("Backup: " + mementoInterface.getNome() + " foi restaurado com sucesso.");
	    }

	   
	    public void showMementos() {
	    	if(mementos.isEmpty())
	    		System.out.println("Não há mementos na lista");
	    	else {
	    		for (MementoInterface memento : mementos) {
		            System.out.println(memento.getNome() + " " + memento.getData());
		        }
	    	}
	    }


}
