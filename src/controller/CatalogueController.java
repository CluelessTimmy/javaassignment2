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
	 @FXML public void handleShowAvailableBook(ActionEvent event) throws Exception {
		 ViewLoader.showStage(getCatalogue(), "/view/showAvailableBooks.fxml", "Available Books", new Stage());
	    	}
	 @FXML public void handleShowByGenre(ActionEvent event) throws Exception{
		 ViewLoader.showStage(getCatalogue(), "/view/showBooksByGenre.fxml", "Browse by Genre", new Stage());
	 }
	 @FXML public void handleShowByAuthor(ActionEvent event) throws Exception{
		 ViewLoader.showStage(getCatalogue(), "/view/showBooksByAuthor.fxml", "Browse by Author", new Stage());
	 }
	 @FXML public void handleShowBorrow(ActionEvent event) throws Exception{
		 ViewLoader.showStage(getCatalogue(), "/view/borrow.fxml", "Borrow a Book", new Stage());
	 }
	 @FXML public void handleShowReturn(ActionEvent event) throws Exception{
		 ViewLoader.showStage(getCatalogue(), "/view/return.fxml", "Return a Book", new Stage());
	 }
	 @FXML public void handleShowHold(ActionEvent event) throws Exception{
		 ViewLoader.showStage(getCatalogue(), "/view/placeHold.fxml", "Place a Hold", new Stage());
	 }
}
