package controller;



import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Library;
import javafx.application.Platform;
import javafx.event.*;

public class LibraryController extends Controller<Library> {

    @FXML
    public void initialize() {

    }

    public final Library getLibrary() {
        return model;
    }
    
    @FXML public void handleExit(ActionEvent event) throws Exception {
    	Platform.exit();
    	System.exit(0);
    	}
    @FXML private void handleOpenCatalogue(ActionEvent event) throws Exception {
        ViewLoader.showStage(getLibrary().getCatalogue(), "/view/catalogue.fxml", "Catalogue", new Stage());
    }
    @FXML private void handleViewPatron(ActionEvent event) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/record.fxml", "Patron Record", new Stage());
    }
    @FXML private void handleViewFavouriteBooks(ActionEvent event) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/favourites.fxml", "Favourites", new Stage());
    }
    @FXML private void handleOpenAdmin(ActionEvent event) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/admin.fxml", "Administration Menu", new Stage());
    }
}
