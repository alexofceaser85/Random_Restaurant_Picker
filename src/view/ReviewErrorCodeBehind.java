package src.view;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ReviewErrorCodeBehind extends BaseCodeBehind{

    @FXML
    private Text tryAgainText;

    @FXML
    void handleTryAgain(MouseEvent event) {
    	super.getController().activate("Restaurant");
    }


}
