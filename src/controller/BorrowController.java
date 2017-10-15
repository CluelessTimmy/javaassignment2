package controller;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class BorrowController extends Controller<Catalogue>{
	@FXML private TextField PatronIDTf;
	@FXML private Button showBtn;
	@FXML private ListView<Book> availBooksLv;
	@FXML private Button borrowBtn;
	
	private int getPatronID() { return Integer.parseInt(PatronIDTf.getText());}
	private Book getBook() { return availBooksLv.getSelectionModel().getSelectedItem();}
	
	@FXML
    public void initialize() {
		PatronIDTf.textProperty().addListener((o, oldText, newText) -> updateButtons());
		availBooksLv.getSelectionModel().selectedItemProperty().addListener((o, oldSelect, newSelect)  -> borrowBtn.setDisable(newSelect == null));
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
	@FXML public void handleShowBooks(ActionEvent event) throws Exception{
		if(getCatalogue().getPatron(getPatronID()) != null) {
			availBooksLv.setItems(getCatalogue().getBooksOnShelf());
		}
	}
	@FXML public void handleBorrowBook(ActionEvent event) throws Exception{
		getCatalogue().loanBookToPatron(getBook(), getCatalogue().getPatron(getPatronID()));
	}
}
