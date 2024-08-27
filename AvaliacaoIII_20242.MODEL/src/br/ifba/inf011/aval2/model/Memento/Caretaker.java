package br.ifba.inf011.aval2.model.Memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Caretaker {
	private ArquivoHistorico arquivoHistorico;
	private Stack<NarrowMemento> snaps = new  Stack<NarrowMemento>();
	
	public Caretaker(ArquivoHistorico arquivoHistorico){
		this.arquivoHistorico = arquivoHistorico;
	}
	
	public void save() throws IllegalAccessException {
		NarrowMemento snap = this.arquivoHistorico.snapshot();
		this.snaps.push(snap);
	}
	
	public void undo() throws IllegalAccessException {
		if(this.snaps.empty())
			return;
		NarrowMemento snap = this.snaps.pop();
		if (this.arquivoHistorico.back(snap) == false) {
			this.snaps.push(snap);
		}
	}
	
	public void showSnaps() {
    	if(snaps.isEmpty())
    		System.out.println("Não há mementos na lista");
    	else {
    		for (NarrowMemento snap : snaps) {
	            System.out.println(snap.toString());
	        }
    	}
    }
}
