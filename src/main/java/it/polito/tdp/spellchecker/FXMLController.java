/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {

	Dictionary model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML
    private Button btnClearText;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private ComboBox<String> comboBoxLanguages;

    @FXML
    private Label txtErrori;

    @FXML
    private TextArea txtInputText;

    @FXML
    private TextArea txtResultErrori;

    @FXML
    private Label txtTempoEsecuzione;
    
    public void setModel(Dictionary model) {
    	this.model = model;
    }

    @FXML
    void doClearText(ActionEvent event) {
    	this.txtInputText.clear();
    	this.txtResultErrori.clear();
    	this.txtErrori.setText("");
    	this.txtTempoEsecuzione.setText("");
    	
    	this.txtInputText.setEditable(true);
    	this.btnSpellCheck.setDisable(false);
    	
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	String lingua = this.comboBoxLanguages.getValue();
    	String input = this.txtInputText.getText();
    	int numErrate = 0;
    	model.loadDictionary(lingua);
    	
    	List<RichWord> result = model.spellCheckText(model.getTextList(input));
    	
    	for(RichWord rw : result) {
    		if(! rw.isCorretta()) {
    			numErrate++;
    			this.txtResultErrori.appendText(rw.getParola()+"\n");
    		}
    	}
    	
    	this.txtErrori.setText("Ci sono: " + numErrate + " parole errate");
    	
    	this.txtInputText.setEditable(false);
    	this.btnSpellCheck.setDisable(true);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	 assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";
         assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
         assert comboBoxLanguages != null : "fx:id=\"comboBoxLanguages\" was not injected: check your FXML file 'Scene.fxml'.";
         assert txtErrori != null : "fx:id=\"txtErrori\" was not injected: check your FXML file 'Scene.fxml'.";
         assert txtInputText != null : "fx:id=\"txtInputText\" was not injected: check your FXML file 'Scene.fxml'.";
         assert txtResultErrori != null : "fx:id=\"txtResultErrori\" was not injected: check your FXML file 'Scene.fxml'.";
         assert txtTempoEsecuzione != null : "fx:id=\"txtTempoEsecuzione\" was not injected: check your FXML file 'Scene.fxml'.";
         
         this.comboBoxLanguages.getItems().add("English");
         this.comboBoxLanguages.getItems().add("Italiano");

    }
}


