package it.polito.tdp.spellchecker.model;

import java.util.List;

public class testDizionario {

	public static void main(String[] args) {
		Dictionary diz = new Dictionary();
		String lingua = "Italiano";
		
		String testo = "Ciao come stai?";
		diz.loadDictionary(lingua);
		
		List<String> textList = diz.getTextList(testo);
		List<RichWord> rxList = diz.spellCheckText(textList);
		
		for(RichWord si: rxList) {
			System.out.println(si.getParola() + si.isCorretta());
		}

	}

}
