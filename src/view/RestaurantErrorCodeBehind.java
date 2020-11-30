package src.view;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * Code Behind for the Restaurant Error Page.
 * 
 * @author Alexander Ayers
 * @version Fall 2020
 */
public class RestaurantErrorCodeBehind extends BaseCodeBehind {
	
    @FXML
    private Text tryAgainText;

    @FXML
    void handleTryAgain(MouseEvent event) {
    	super.getController().activate("Restaurant");
    }
}
