package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Library;
import javafx.event.*;

public class AddPatronController extends Controller<Library>{
	@FXML private TextField patronIDTf;
	@FXML private TextField patronNameTf;
	@FXML private Text PatronAddText;
	
	private int getPatronID() { return Integer.parseInt(patronIDTf.getText()); }
	private String getPatronName() { return patronNameTf.getText(); }
	@FXML
    public void initialize() {

    }

    public final Library getLibrary() {
        return model;
    }
    
    @FXML public void handleExit(ActionEvent event) throws Exception {
    	stage.close();
    	}
    @FXML public void handleAddPatron(ActionEvent event) throws Exception {
    	if(getLibrary().getPatron(getPatronID()) == null) {
    		getLibrary().addPatron(getPatronID(),getPatronName());
        	PatronAddText.setText("Patron Added.");
    		}else {
    			PatronAddText.setText("Patron already exists!");
    		}
    	
    	}
}
