package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class ShowBooksByGenreController extends Controller<Catalogue> {
	@FXML private ListView<Genre> genreLv;
	@FXML private ListView<Book> booksInGenreLv;
	
	@FXML
    public void initialize() {

    }
	private Genre getGenre() { return genreLv.getSelectionModel().getSelectedItem(); }
	public final Catalogue getCatalogue() {
		return model;
	}
	
	@FXML public void handleExit(ActionEvent event) throws Exception {
    	stage.close();
    	}
	@FXML public void handleShowByGenre(ActionEvent event) throws Exception{
		booksInGenreLv.setItems(getCatalogue().getBooksInGenre(getGenre()));
	}
}
