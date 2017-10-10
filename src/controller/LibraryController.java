package controller;



import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Library;
import javafx.event.*;

public class LibraryController extends Controller<Library> {

    @FXML
    public void initialize() {

    }

    public final Library getLibrary() {
        return model;
    }
    
    @FXML public void handleExit(ActionEvent event) throws Exception {
    	stage.close();
    	}
    @FXML private void handleOpenCatalogue(ActionEvent event) throws Exception {
        ViewLoader.showStage(getLibrary().getCatalogue(), "/view/catalogue.fxml", "Complete Catalogue", new Stage());
    }
}
