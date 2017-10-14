package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Catalogue;
import model.Library;

public class AdminController extends Controller<Library> {
	@FXML
    public void initialize() {

    }
	public final Library getLibrary() {
        return model;
    }
	
	
	@FXML public void handleExit(ActionEvent event) throws Exception {
    	stage.close();
    	}
	@FXML private void handleOpenAddPatron(ActionEvent event) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/addPatron.fxml", "Add Patron", new Stage());
    }
	@FXML private void handleOpenAddBook(ActionEvent event) throws Exception {
        ViewLoader.showStage(getLibrary().getCatalogue(), "/view/addBook.fxml", "Add Book", new Stage());
    }
	@FXML private void handleOpenRemovePatron(ActionEvent event) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/removePatron.fxml", "Remove Patron", new Stage());
    }
	@FXML private void handleOpenRemoveBook(ActionEvent event) throws Exception {
        ViewLoader.showStage(getLibrary().getCatalogue(), "/view/removeBook.fxml", "Remove Book", new Stage());
    }
}
