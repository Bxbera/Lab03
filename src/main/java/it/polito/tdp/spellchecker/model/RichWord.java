package it.polito.tdp.spellchecker.model;

public class RichWord {
	String parola;
	boolean isCorretta;
	
	public RichWord(String parola, boolean isCorretta) {
		super();
		this.parola = parola;
		this.isCorretta = isCorretta;
	}

	public String getParola() {
		return parola;
	}

	public boolean isCorretta() {
		return isCorretta;
	}
	
	
	
}
