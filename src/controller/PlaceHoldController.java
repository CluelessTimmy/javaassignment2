package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class PlaceHoldController extends Controller<Catalogue> {
	@FXML private TextField PatronIDTf;
	@FXML private Button showBtn;
	@FXML private ListView<Book> allBooksLv;
	@FXML private Button holdBtn;
	@FXML private Text holdText;
	
	private int getPatronID() { return Integer.parseInt(PatronIDTf.getText());}
	private Book getBook() { return allBooksLv.getSelectionModel().getSelectedItem();}
	
	public final Catalogue getCatalogue() {
        return model;
    }
	@FXML
    public void initialize() {
		PatronIDTf.textProperty().addListener((o, oldText, newText) -> updateButtons());
		allBooksLv.getSelectionModel().selectedItemProperty().addListener((o, oldSelect, newSelect)  -> holdBtn.setDisable(newSelect == null));
	}
	private void updateButtons() {
		showBtn.setDisable(!isTypeValid());
	}
	private boolean isTypeValid() {
		return PatronIDTf.getText().length() >= 1;
	}
	
	@FXML public void handleExit(ActionEvent event) throws Exception {
    	stage.close();
    	}
	@FXML public void handleShowAllBooks(ActionEvent event) throws Exception{
		if(getCatalogue().getPatron(getPatronID()) != null) {
			allBooksLv.setItems(getCatalogue().getAllBooks());
		}
	}
	@FXML public void handleHoldBook(ActionEvent event) throws Exception{
		if(getBook().isHeldBy(getCatalogue().getPatron(getPatronID())) == false) {
			getBook().addHold(getCatalogue().getPatron(getPatronID()));
			holdText.setText("Hold placed on " + getBook().getTitle() + " "+ getCatalogue().getPatron(getPatronID()).getName() );
		}else {
			holdText.setText(getCatalogue().getPatron(getPatronID()).getName() + " has already placed a hold on "+ getBook().getTitle());
		}
		
	}
}
