package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class RemovePatronController extends Controller<Library>{
	@FXML private ListView<Patron> patronsLv;
	
	@FXML
    public void initialize() {

    }
	private Patron getPatron() { return patronsLv.getSelectionModel().getSelectedItem(); }
	public final Library getLibrary() {
        return model;
    }
	
	@FXML public void handleExit(ActionEvent event) throws Exception {
    	stage.close();
    	}
	@FXML public void handleRemove(ActionEvent event) throws Exception {
		getLibrary().removePatron(getPatron());
	}
}
