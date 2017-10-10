package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Catalogue;
import model.Library;

public class CatalogueController extends Controller<Catalogue> {
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
