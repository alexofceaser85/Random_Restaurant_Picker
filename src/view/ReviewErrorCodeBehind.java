package src.view;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * Code Behind for the No Reviews Error Screen.
 * @author Furichous Jones IV
 * @version Fall 2020
 */
public class ReviewErrorCodeBehind extends BaseCodeBehind {
    @FXML
    private Text tryAgainText;

    @FXML
    void handleTryAgain(MouseEvent event) {
    	super.getController().show("Restaurant");
    }
}
