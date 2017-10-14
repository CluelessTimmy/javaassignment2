package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;

public class FavouritesController extends Controller<Library>{
	@FXML private ListView<Book> favouriteLv;
	@FXML private TextField patronIDTf;
	@FXML private Text PatronText;
	@FXML private Button showBtn;
	
	@FXML
	public void initialize() {
		patronIDTf.textProperty().addListener((o, oldText, newText) -> updateButtons());
	}
	private int getPatronID() { return Integer.parseInt(patronIDTf.getText());}
	public final Library getLibrary() {
        return model;
    }
	private void updateButtons() {
		showBtn.setDisable(!isTypeValid());
	}
	private boolean isTypeValid() {
		return patronIDTf.getText().length() >= 1;
	}
	@FXML public void handleExit(ActionEvent event) throws Exception {
    	stage.close();
    	}
	
	@FXML public void handleShowFavourites(ActionEvent event) throws Exception {
		if(getLibrary().getPatron(getPatronID()) == null) {
			PatronText.setText("Invalid Patron ID");
			}else {
				PatronText.setText(getLibrary().getPatron(getPatronID()).getName() + "'s favourite books:");
				favouriteLv.setItems(getLibrary().getPatron(getPatronID()).favourites());
			}
    	}
}
