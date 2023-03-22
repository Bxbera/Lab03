package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {

	List<String> strutturaDati; // contiene tutte le parole del dizionario
	
	public Dictionary() {
		this.strutturaDati = new LinkedList<>();
	}
	
	public void loadDictionary(String language) {
		//String ita = "\\Users\\beraa\\Documents\\Workspace Eclipse\\Lab03\\src\\main\\resources\\Italian.txt" ;
		
		// con quello la scritta di sopra va, perchè è il percorso completo in questo computer; 
		// per avere il minimo percorso devo usare quello che ho scritto qua sotto, senza \\ altrimenti da errore
		String ita = "src\\main\\resources\\Italian.txt" ;
		String eng = "src\\main\\resources\\English.txt" ;
		
		String file;
		if(language.equals("Italiano")) {
			file = ita;
		}
		else {
			file = eng;
		}
		
		try {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);		
		String word;		
		while((word = br.readLine()) != null) {
			this.strutturaDati.add(word);
		}
		
		br.close();
		fr.close();
		} catch(IOException ioe) {
			System.out.print("Errore in lettura file\n\n");
			ioe.printStackTrace();
		}
		
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList) {
		List<RichWord> richWord = new LinkedList<>();
		
		// dizionario non deve essere vuoto
		for(String si: inputTextList) {
			boolean presente = false;
			if(this.strutturaDati.contains(si.toLowerCase())) {
				presente = true;
			}
			
			richWord.add(new RichWord(si, presente));
			
		}
		return richWord;
	}
	
	public List<String> getTextList(String testo) {
		List<String> ret = new LinkedList<>();
		
		testo.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_'()\\[\\]\"]", "") ;
		for(String si: testo.split(" ")) {
			ret.add(si);
		}
		
		return ret;
	}
}
