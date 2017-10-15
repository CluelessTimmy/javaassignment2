package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class ReturnController extends Controller<Catalogue>{
	@FXML private TextField PatronIDTf;
	@FXML private Button showBtn;
	@FXML private ListView<Book> borrowedBooksLv;
	@FXML private Button returnBtn;
	
	private int getPatronID() { return Integer.parseInt(PatronIDTf.getText());}
	private Book getBook() { return borrowedBooksLv.getSelectionModel().getSelectedItem();}
	
	@FXML
    public void initialize() {
		PatronIDTf.textProperty().addListener((o, oldText, newText) -> updateButtons());
		borrowedBooksLv.getSelectionModel().selectedItemProperty().addListener((o, oldSelect, newSelect)  -> returnBtn.setDisable(newSelect == null));
    }
	private void updateButtons() {
		showBtn.setDisable(!isTypeValid());
	}
	private boolean isTypeValid() {
		return PatronIDTf.getText().length() >= 1;
	}
	
	public final Catalogue getCatalogue() {
        return model;
    }
	
	@FXML public void handleExit(ActionEvent event) throws Exception {
    	stage.close();
    	}
	@FXML public void handleShowCurrentlyBorrowed(ActionEvent event) throws Exception{
		if(getCatalogue().getPatron(getPatronID()) != null) {
			borrowedBooksLv.setItems(getCatalogue().getPatron(getPatronID()).currentlyBorrowed());
		}
	}
	@FXML public void handleReturnBook(ActionEvent event) throws Exception{
		getCatalogue().returnBookFromPatron(getBook(), getCatalogue().getPatron(getPatronID()));
	}
}
