package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class ShowAllBooksController extends Controller<Catalogue> {
	
	
	@FXML
	public void initialize() {
		
	}
	public final Catalogue getCatalogue() {
		return model;
	}
	@FXML public void handleExit(ActionEvent event) throws Exception {
    	stage.close();
    	}
}
