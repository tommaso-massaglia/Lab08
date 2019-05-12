package it.polito.tdp.dizionariograph;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.dizionariograph.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DizionarioGraphController {
	
	private Model model = new Model();
	
	public void setModel (Model model) {
		this.model = model;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNumLettere;

    @FXML
    private TextField txtParolaDaCercare;

    @FXML
    private Button btnGeneraGrafo;

    @FXML
    private Button btnTrovaVicini;

    @FXML
    private Button btnMaxGrado;

    @FXML
    private TextArea txtOutput;

    @FXML
    private Button btnReset;

    @FXML
    void doGradoMax(ActionEvent event) {
    	this.txtOutput.setText(model.findMaxDegree()+"");
    }

    @FXML
    void doGrafo(ActionEvent event) {
    	int lettere = Integer.parseInt(this.txtNumLettere.getText());
    	model.createGraph(lettere);
    	this.txtOutput.setText("Grafo creato con successo!");
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtOutput.clear();
    	this.txtNumLettere.clear();
    	this.txtParolaDaCercare.clear();
    }

    @FXML
    void doVicini(ActionEvent event) {
    	this.txtOutput.setWrapText(true);
    	this.txtOutput.setText(model.displayNeighbours(this.txtParolaDaCercare.getText()).toString());
    }

    @FXML
    void initialize() {
        assert txtNumLettere != null : "fx:id=\"txtNumLettere\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert txtParolaDaCercare != null : "fx:id=\"txtParolaDaCercare\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnGeneraGrafo != null : "fx:id=\"btnGeneraGrafo\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnTrovaVicini != null : "fx:id=\"btnTrovaVicini\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnMaxGrado != null : "fx:id=\"btnMaxGrado\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";

    }
}

