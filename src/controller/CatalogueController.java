package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
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
	 @FXML public void handleShowAllBook(ActionEvent event) throws Exception {
		 ViewLoader.showStage(getCatalogue(), "/view/showAllBooks.fxml", "Complete Catalogue", new Stage());
	    	}
}
