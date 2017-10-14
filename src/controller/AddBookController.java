package controller;

import model.Catalogue;
import au.edu.uts.ap.javafx.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.*;

public class AddBookController extends Controller<Catalogue>{
	@FXML private TextField titleTf;
	@FXML private TextField authorTf;
	@FXML private TextField genreTf;
	@FXML private Text addText;
	
	private String getTitle() { return titleTf.getText(); }
	private String getAuthor() { return authorTf.getText(); }
	private String getGenre() { return genreTf.getText(); }
	
	@FXML public void handleExit(ActionEvent event) throws Exception {
    	stage.close();
    	}
	private Catalogue getCatalogue() {
		return model;
	}
	
	@FXML public void handleAddBook(ActionEvent event) throws Exception {
    	if(getCatalogue().hasBook(getTitle(),getAuthor()) == false) {
    			getCatalogue().addBook(getTitle(), getAuthor(), getGenre());
    			addText.setText("Book added to Catalogue.");
    		}else {
    			addText.setText("That book is already in the Catalgoue.");
    		}
    	}
}
