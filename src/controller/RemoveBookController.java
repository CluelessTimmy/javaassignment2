package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class RemoveBookController extends Controller<Catalogue>{
	@FXML private ListView<Book> booksLv;
	
	@FXML
    public void initialize() {

    }
	private Book getBook() { return booksLv.getSelectionModel().getSelectedItem(); }
	public final Catalogue getCatalogue() {
		return model;
	}
	@FXML public void handleExit(ActionEvent event) throws Exception {
    	stage.close();
    	}
	@FXML public void handleRemove(ActionEvent event) throws Exception {
    	getCatalogue().removeBook(getBook());
    	}
}
