package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class ShowBooksByAuthorController extends Controller<Catalogue>{
	@FXML private ListView<Author> authorLv;
	@FXML private ListView<Book> booksByAuthorLv;
	
	@FXML
    public void initialize() {

    }
	private Author getAuthor() { return authorLv.getSelectionModel().getSelectedItem(); }
	public final Catalogue getCatalogue() {
		return model;
	}
	
	@FXML public void handleExit(ActionEvent event) throws Exception {
    	stage.close();
    	}
	@FXML public void handleShowByAuthor(ActionEvent event) throws Exception{
		booksByAuthorLv.setItems(getCatalogue().getBooksByAuthor(getAuthor()));
	}
}
