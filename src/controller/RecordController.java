package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;

import javafx.event.*;
public class RecordController extends Controller<Library>{
	@FXML private TextField PatronIDTf;
	@FXML private Button showBtn;
	@FXML private Text PatronText;
	@FXML private ListView<Book> currentlyBorrowedLv;
	@FXML private ListView<Book> borrowingHistoryLv;
	
	private int getPatronID() { return Integer.parseInt(PatronIDTf.getText());}
	
	@FXML
    public void initialize() {
		PatronIDTf.textProperty().addListener((o, oldText, newText) -> updateButtons());
    }
	private void updateButtons() {
		showBtn.setDisable(!isTypeValid());
	}
	private boolean isTypeValid() {
		return PatronIDTf.getText().length() >= 1;
	}
	public final Library getLibrary() {
        return model;
    }
	@FXML public void handleExit(ActionEvent event) throws Exception {
    	stage.close();
    	}
	@FXML public void handleShowRecord(ActionEvent event) throws Exception{
		if(getLibrary().getPatron(getPatronID()) == null) {
			PatronText.setText("Invalid Patron ID");
		}else {
			PatronText.setText(getLibrary().getPatron(getPatronID()).toString());
			currentlyBorrowedLv.setItems(getLibrary().getPatron(getPatronID()).currentlyBorrowed());
			borrowingHistoryLv.setItems(getLibrary().getPatron(getPatronID()).borrowingHistory());
		}
	}
}
